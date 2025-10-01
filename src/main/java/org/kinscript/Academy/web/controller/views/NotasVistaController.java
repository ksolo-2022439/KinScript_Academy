package org.kinscript.Academy.web.controller.views;

import org.kinscript.Academy.dominio.dto.*;
import org.kinscript.Academy.dominio.service.*;
import org.kinscript.Academy.persistence.entity.Notas;
import org.kinscript.Academy.persistence.mapper.NotasMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/notas")
public class NotasVistaController {

    @Autowired private NotasService notasService;
    @Autowired private AlumnosService alumnosService;
    @Autowired private CursosService cursosService;
    @Autowired private NotasMapper notasMapper;

    @GetMapping
    public String mostrarPaginaNotas(Model model,
                                     @RequestParam(required = false) Long alumnoFilter,
                                     @RequestParam(required = false) Long cursoFilter,
                                     @RequestParam(required = false) BigDecimal promedioFilter,
                                     @RequestParam(name = "add", required = false) Boolean add) {

        List<NotasDto> notasFiltradas = notasService.buscarPorFiltros(alumnoFilter, cursoFilter);

        if (promedioFilter != null) {
            notasFiltradas = notasFiltradas.stream()
                    .filter(nota -> {
                        BigDecimal b1 = nota.bimestre1() != null ? nota.bimestre1() : BigDecimal.ZERO;
                        BigDecimal b2 = nota.bimestre2() != null ? nota.bimestre2() : BigDecimal.ZERO;
                        BigDecimal b3 = nota.bimestre3() != null ? nota.bimestre3() : BigDecimal.ZERO;
                        BigDecimal b4 = nota.bimestre4() != null ? nota.bimestre4() : BigDecimal.ZERO;
                        BigDecimal promedio = b1.add(b2).add(b3).add(b4).divide(new BigDecimal(4), 2, RoundingMode.HALF_UP);
                        return promedio.compareTo(promedioFilter) >= 0;
                    })
                    .collect(Collectors.toList());
        }

        long totalActivos = notasService.contarTotal();

        model.addAttribute("notas", notasFiltradas);
        model.addAttribute("alumnoFilter", alumnoFilter);
        model.addAttribute("cursoFilter", cursoFilter);
        model.addAttribute("promedioFilter", promedioFilter);

        model.addAttribute("totalNotas", notasFiltradas.size());
        model.addAttribute("notasActivas", totalActivos);

        List<AlumnosDto> todosLosAlumnos = alumnosService.obtenerTodo();
        List<CursosDto> todosLosCursos = cursosService.obtenerTodo();
        model.addAttribute("listaAlumnos", todosLosAlumnos);
        model.addAttribute("listaCursos", todosLosCursos);
        model.addAttribute("alumnosMap", todosLosAlumnos.stream().collect(Collectors.toMap(AlumnosDto::idAlumno, alumno -> alumno.nombreCompleto() + " " + alumno.apellidoCompleto())));
        model.addAttribute("cursosMap", todosLosCursos.stream().collect(Collectors.toMap(CursosDto::idCurso, CursosDto::nombreCurso)));

        if (!model.containsAttribute("notaParaFormulario")) {
            model.addAttribute("notaParaFormulario", new Notas());
        }

        model.addAttribute("paginaActiva", "notas");

        if (Boolean.TRUE.equals(add)) {
            model.addAttribute("openAddModal", true);
        }
        return "gestion-notas";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Long idNota, Model model, RedirectAttributes redirectAttributes,
                                           @RequestParam(required = false) Long alumnoFilter,
                                           @RequestParam(required = false) Long cursoFilter,
                                           @RequestParam(required = false) BigDecimal promedioFilter) {
        try {
            NotasDto notaDto = notasService.buscarPorCodigo(idNota);
            model.addAttribute("notaParaFormulario", notasMapper.toEntity(notaDto));
            model.addAttribute("editar", true);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: No se pudo encontrar la nota para editar.");
            return "redirect:/notas";
        }
        return mostrarPaginaNotas(model, alumnoFilter, cursoFilter, promedioFilter, null);
    }

    @PostMapping("/guardar")
    public String guardarNota(@ModelAttribute("notaParaFormulario") Notas notaEntity, RedirectAttributes redirectAttributes) {
        try {
            if (notaEntity.getIdNota() == null) {
                notasService.guardarNota(notasMapper.toDto(notaEntity));
                redirectAttributes.addFlashAttribute("successMessage", "Nota creada correctamente.");
            } else {
                ModNotasDto modDto = new ModNotasDto(notaEntity.getIdAlumno(), notaEntity.getIdCurso(), notaEntity.getBimestre1(), notaEntity.getBimestre2(), notaEntity.getBimestre3(), notaEntity.getBimestre4());
                notasService.modificarNota(notaEntity.getIdNota(), modDto);
                redirectAttributes.addFlashAttribute("successMessage", "Nota actualizada correctamente.");
            }
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: Ya existe una nota para este alumno en este curso.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ocurrió un error inesperado al guardar la nota.");
        }
        return "redirect:/notas";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarNota(@PathVariable("id") Long idNota, RedirectAttributes redirectAttributes) {
        try {
            notasService.eliminarNota(idNota);
            redirectAttributes.addFlashAttribute("successMessage", "Nota eliminada correctamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ocurrió un error inesperado al eliminar la nota.");
        }
        return "redirect:/notas";
    }
}