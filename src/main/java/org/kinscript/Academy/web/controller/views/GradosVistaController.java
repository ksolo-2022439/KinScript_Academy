package org.kinscript.Academy.web.controller.views;

import org.kinscript.Academy.dominio.dto.GradosDto;
import org.kinscript.Academy.dominio.dto.ModGradosDto;
import org.kinscript.Academy.dominio.service.GradosService;
import org.kinscript.Academy.persistence.entity.Grados;
import org.kinscript.Academy.persistence.mapper.GradosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/grados")
public class GradosVistaController {

    @Autowired
    private GradosService gradosService;
    @Autowired
    private GradosMapper gradosMapper;

    @GetMapping
    public String mostrarPaginaGrados(Model model, @RequestParam(name = "add", required = false) Boolean add) {
        List<GradosDto> grados = gradosService.obtenerTodo();
        model.addAttribute("grados", grados);

        model.addAttribute("totalGrados", grados.size());
        model.addAttribute("gradosActivos", grados.size());

        if (!model.containsAttribute("gradoParaFormulario")) {
            model.addAttribute("gradoParaFormulario", new Grados());
        }

        model.addAttribute("paginaActiva", "grados");

        if (Boolean.TRUE.equals(add)) {
            model.addAttribute("openAddModal", true);
        }

        return "gestion-grados";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Long idGrado, Model model, RedirectAttributes redirectAttributes) {
        try {
            GradosDto gradoDto = gradosService.buscarPorCodigo(idGrado);
            if (gradoDto == null) {
                throw new IllegalArgumentException("ID de Grado inválido:" + idGrado);
            }
            model.addAttribute("gradoParaFormulario", gradosMapper.toEntity(gradoDto));
            model.addAttribute("editar", true);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: No se pudo encontrar el grado para editar.");
            return "redirect:/grados";
        }
        return mostrarPaginaGrados(model, null);
    }

    @PostMapping("/guardar")
    public String guardarGrado(@ModelAttribute("gradoParaFormulario") Grados gradoEntity, RedirectAttributes redirectAttributes) {
        try {
            if (gradoEntity.getIdGrado() == null) {
                GradosDto nuevoDto = gradosMapper.toDto(gradoEntity);
                gradosService.guardarGrados(nuevoDto);
                redirectAttributes.addFlashAttribute("successMessage", "Grado creado correctamente.");
            } else {
                ModGradosDto modDto = new ModGradosDto(gradoEntity.getNombreGrado());
                gradosService.modificarGrados(gradoEntity.getIdGrado(), modDto);
                redirectAttributes.addFlashAttribute("successMessage", "Grado actualizado correctamente.");
            }
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: El nombre del grado '" + gradoEntity.getNombreGrado() + "' ya existe.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ocurrió un error inesperado al guardar el grado.");
        }
        return "redirect:/grados";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarGrado(@PathVariable("id") Long idGrado, RedirectAttributes redirectAttributes) {
        try {
            gradosService.eliminarGrados(idGrado);
            redirectAttributes.addFlashAttribute("successMessage", "Grado eliminado correctamente.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Acción denegada: No se puede eliminar el grado porque está asignado a uno o más alumnos.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ocurrió un error inesperado al eliminar el grado.");
        }
        return "redirect:/grados";
    }
}