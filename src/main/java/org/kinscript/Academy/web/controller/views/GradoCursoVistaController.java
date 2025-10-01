package org.kinscript.Academy.web.controller.views;

import org.kinscript.Academy.dominio.dto.CursosDto;
import org.kinscript.Academy.dominio.dto.GradoCursoDto;
import org.kinscript.Academy.dominio.dto.GradosDto;
import org.kinscript.Academy.dominio.service.CursosService;
import org.kinscript.Academy.dominio.service.GradoCursoService;
import org.kinscript.Academy.dominio.service.GradosService;
import org.kinscript.Academy.persistence.entity.GradoCurso;
import org.kinscript.Academy.persistence.mapper.GradoCursoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/gradocurso")
public class GradoCursoVistaController {

    @Autowired private GradoCursoService gradoCursoService;
    @Autowired private GradosService gradosService;
    @Autowired private CursosService cursosService;
    @Autowired private GradoCursoMapper gradoCursoMapper;

    @GetMapping
    public String mostrarPaginaGradoCurso(Model model,
                                          @RequestParam(required = false) Long gradoFilter,
                                          @RequestParam(name = "add", required = false) Boolean add) {

        List<GradoCursoDto> asociacionesFiltradas = gradoCursoService.buscarPorFiltro(gradoFilter);
        long totalActivos = gradoCursoService.contarTotal();

        model.addAttribute("asociaciones", asociacionesFiltradas);
        model.addAttribute("gradoFilter", gradoFilter);

        model.addAttribute("totalAsociaciones", asociacionesFiltradas.size());
        model.addAttribute("asociacionesActivas", totalActivos);

        List<GradosDto> todosLosGrados = gradosService.obtenerTodo();
        List<CursosDto> todosLosCursos = cursosService.obtenerTodo();
        model.addAttribute("listaGrados", todosLosGrados);
        model.addAttribute("listaCursos", todosLosCursos);
        model.addAttribute("gradosMap", todosLosGrados.stream().collect(Collectors.toMap(GradosDto::idGrado, GradosDto::nombreGrado)));
        model.addAttribute("cursosMap", todosLosCursos.stream().collect(Collectors.toMap(CursosDto::idCurso, CursosDto::nombreCurso)));

        if (!model.containsAttribute("asociacionParaFormulario")) {
            model.addAttribute("asociacionParaFormulario", new GradoCurso());
        }

        model.addAttribute("paginaActiva", "gradocurso");

        if (Boolean.TRUE.equals(add)) {
            model.addAttribute("openAddModal", true);
        }
        return "gestion-gradocurso";
    }

    @PostMapping("/guardar")
    public String guardarAsociacion(@ModelAttribute("asociacionParaFormulario") GradoCurso asociacionEntity, RedirectAttributes redirectAttributes) {
        try {
            if (asociacionEntity.getIdGrado() == null || asociacionEntity.getIdCurso() == null) {
                redirectAttributes.addFlashAttribute("errorMessage", "Debe seleccionar un grado y un curso.");
                return "redirect:/gradocurso";
            }
            gradoCursoService.guardarAsociacion(gradoCursoMapper.toDto(asociacionEntity));
            redirectAttributes.addFlashAttribute("successMessage", "Asociación creada correctamente.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: Este curso ya está asociado a este grado.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ocurrió un error inesperado al guardar la asociación.");
        }
        return "redirect:/gradocurso";
    }

    @PostMapping("/eliminar")
    public String eliminarAsociacion(@RequestParam Long idGrado, @RequestParam Long idCurso, RedirectAttributes redirectAttributes) {
        try {
            gradoCursoService.eliminarAsociacion(idGrado, idCurso);
            redirectAttributes.addFlashAttribute("successMessage", "Asociación eliminada correctamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ocurrió un error inesperado al eliminar la asociación.");
        }
        return "redirect:/gradocurso";
    }
}