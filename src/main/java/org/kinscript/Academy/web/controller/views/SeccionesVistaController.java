package org.kinscript.Academy.web.controller.views;

import org.kinscript.Academy.dominio.dto.ModSeccionesDto;
import org.kinscript.Academy.dominio.dto.SeccionesDto;
import org.kinscript.Academy.dominio.service.SeccionesService;
import org.kinscript.Academy.persistence.entity.Secciones;
import org.kinscript.Academy.persistence.mapper.SeccionesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/secciones")
public class SeccionesVistaController {

    @Autowired
    private SeccionesService seccionesService;
    @Autowired
    private SeccionesMapper seccionesMapper;

    @GetMapping
    public String mostrarPaginaSecciones(Model model) {
        List<SeccionesDto> secciones = seccionesService.obtenerSeccion();
        model.addAttribute("secciones", secciones);

        model.addAttribute("totalSecciones", secciones.size());
        model.addAttribute("seccionesActivas", secciones.size());

        if (!model.containsAttribute("seccionParaFormulario")) {
            model.addAttribute("seccionParaFormulario", new Secciones());
        }

        model.addAttribute("paginaActiva", "secciones");

        return "gestion-secciones";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Long idSeccion, Model model, RedirectAttributes redirectAttributes) {
        try {
            SeccionesDto seccionDto = seccionesService.buscarSeccion(idSeccion);
            if (seccionDto == null) {
                throw new IllegalArgumentException("ID de Sección inválido:" + idSeccion);
            }
            model.addAttribute("seccionParaFormulario", seccionesMapper.toEntity(seccionDto));
            model.addAttribute("editar", true);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: No se pudo encontrar la sección para editar.");
            return "redirect:/secciones";
        }
        return mostrarPaginaSecciones(model);
    }

    @PostMapping("/guardar")
    public String guardarSeccion(@ModelAttribute("seccionParaFormulario") Secciones seccionEntity, RedirectAttributes redirectAttributes) {
        try {
            if (seccionEntity.getIdSeccion() == null) {
                SeccionesDto nuevoDto = seccionesMapper.toDto(seccionEntity);
                seccionesService.guardarSeccion(nuevoDto);
                redirectAttributes.addFlashAttribute("successMessage", "Sección creada correctamente.");
            } else {
                ModSeccionesDto modDto = new ModSeccionesDto(seccionEntity.getNombreSeccion());
                seccionesService.modificarSeccion(seccionEntity.getIdSeccion(), modDto);
                redirectAttributes.addFlashAttribute("successMessage", "Sección actualizada correctamente.");
            }
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: El nombre de la sección '" + seccionEntity.getNombreSeccion() + "' ya existe.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ocurrió un error inesperado al guardar la sección.");
        }
        return "redirect:/secciones";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarSeccion(@PathVariable("id") Long idSeccion, RedirectAttributes redirectAttributes) {
        try {
            seccionesService.eliminarSeccion(idSeccion);
            redirectAttributes.addFlashAttribute("successMessage", "Sección eliminada correctamente.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Acción denegada: No se puede eliminar la sección porque está asignada a uno o más alumnos.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ocurrió un error inesperado al eliminar la sección.");
        }
        return "redirect:/secciones";
    }
}