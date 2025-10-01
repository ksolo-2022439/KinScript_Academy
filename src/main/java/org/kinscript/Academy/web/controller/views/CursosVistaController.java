package org.kinscript.Academy.web.controller.views;

import org.kinscript.Academy.dominio.dto.CursosDto;
import org.kinscript.Academy.dominio.dto.ModCursosDto;
import org.kinscript.Academy.dominio.service.CursosService;
import org.kinscript.Academy.persistence.entity.Cursos;
import org.kinscript.Academy.persistence.mapper.CursosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/cursos")
public class CursosVistaController {

    @Autowired
    private CursosService cursosService;
    @Autowired
    private CursosMapper cursosMapper;

    @GetMapping
    public String mostrarPaginaCursos(Model model, @RequestParam(name = "add", required = false) Boolean add) {
        List<CursosDto> cursos = cursosService.obtenerTodo();
        model.addAttribute("cursos", cursos);

        model.addAttribute("totalCursos", cursos.size());
        model.addAttribute("cursosActivos", cursos.size());

        if (!model.containsAttribute("cursoParaFormulario")) {
            model.addAttribute("cursoParaFormulario", new Cursos());
        }

        model.addAttribute("paginaActiva", "cursos");

        if (Boolean.TRUE.equals(add)) {
            model.addAttribute("openAddModal", true);
        }

        return "gestion-cursos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Long idCurso, Model model, RedirectAttributes redirectAttributes) {
        try {
            CursosDto cursoDto = cursosService.buscarPorCodigo(idCurso);
            if (cursoDto == null) {
                throw new IllegalArgumentException("ID de Curso inválido:" + idCurso);
            }
            model.addAttribute("cursoParaFormulario", cursosMapper.toEntity(cursoDto));
            model.addAttribute("editar", true);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: No se pudo encontrar el curso para editar.");
            return "redirect:/cursos";
        }
        return mostrarPaginaCursos(model, null);
    }

    @PostMapping("/guardar")
    public String guardarCurso(@ModelAttribute("cursoParaFormulario") Cursos cursoEntity, RedirectAttributes redirectAttributes) {
        try {
            if (cursoEntity.getIdCurso() == null) {
                CursosDto nuevoDto = cursosMapper.toDto(cursoEntity);
                cursosService.guardarCursos(nuevoDto);
                redirectAttributes.addFlashAttribute("successMessage", "Curso creado correctamente.");
            } else {
                ModCursosDto modDto = new ModCursosDto(cursoEntity.getNombreCurso());
                cursosService.modificarCursos(cursoEntity.getIdCurso(), modDto);
                redirectAttributes.addFlashAttribute("successMessage", "Curso actualizado correctamente.");
            }
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: El nombre del curso '" + cursoEntity.getNombreCurso() + "' ya existe.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ocurrió un error inesperado al guardar el curso.");
        }
        return "redirect:/cursos";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarCurso(@PathVariable("id") Long idCurso, RedirectAttributes redirectAttributes) {
        try {
            cursosService.eliminarCursos(idCurso);
            redirectAttributes.addFlashAttribute("successMessage", "Curso eliminado correctamente.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Acción denegada: No se puede eliminar el curso porque está en uso.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ocurrió un error inesperado al eliminar el curso.");
        }
        return "redirect:/cursos";
    }
}