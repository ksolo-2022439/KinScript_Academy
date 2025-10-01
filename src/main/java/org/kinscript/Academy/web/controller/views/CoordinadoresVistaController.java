package org.kinscript.Academy.web.controller.views;

import org.kinscript.Academy.dominio.dto.CoordinadoresDto;
import org.kinscript.Academy.dominio.dto.GradosDto;
import org.kinscript.Academy.dominio.dto.ModCoordinadoresDto;
import org.kinscript.Academy.dominio.service.CoordinadoresService;
import org.kinscript.Academy.dominio.service.GradosService;
import org.kinscript.Academy.persistence.entity.Coordinadores;
import org.kinscript.Academy.persistence.mapper.CoordinadoresMapper;
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
@RequestMapping("/coordinadores")
public class CoordinadoresVistaController {

    @Autowired private CoordinadoresService coordinadoresService;
    @Autowired private GradosService gradosService;
    @Autowired private CoordinadoresMapper coordinadoresMapper;

    @GetMapping
    public String mostrarPaginaCoordinadores(Model model,
                                             @RequestParam(required = false) String nombreFilter,
                                             @RequestParam(required = false) String apellidoFilter,
                                             @RequestParam(required = false) String emailFilter,
                                             @RequestParam(required = false) Long gradoFilter,
                                             @RequestParam(name = "add", required = false) Boolean add) {

        List<CoordinadoresDto> coordinadoresFiltrados = coordinadoresService.buscarPorFiltros(nombreFilter, apellidoFilter, emailFilter, gradoFilter);
        long totalActivos = coordinadoresService.contarTotal();

        model.addAttribute("coordinadores", coordinadoresFiltrados);
        model.addAttribute("nombreFilter", nombreFilter);
        model.addAttribute("apellidoFilter", apellidoFilter);
        model.addAttribute("emailFilter", emailFilter);
        model.addAttribute("gradoFilter", gradoFilter);

        model.addAttribute("totalCoordinadores", coordinadoresFiltrados.size());
        model.addAttribute("coordinadoresActivos", totalActivos);

        List<GradosDto> todosLosGrados = gradosService.obtenerTodo();
        model.addAttribute("listaGrados", todosLosGrados);
        model.addAttribute("gradosMap", todosLosGrados.stream().collect(Collectors.toMap(GradosDto::idGrado, GradosDto::nombreGrado)));

        if (!model.containsAttribute("coordinadorParaFormulario")) {
            model.addAttribute("coordinadorParaFormulario", new Coordinadores());
        }

        model.addAttribute("paginaActiva", "coordinadores");

        if (Boolean.TRUE.equals(add)) {
            model.addAttribute("openAddModal", true);
        }
        return "gestion-coordinadores";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Long idCoordinador, Model model, RedirectAttributes redirectAttributes,
                                           @RequestParam(required = false) String nombreFilter,
                                           @RequestParam(required = false) String apellidoFilter,
                                           @RequestParam(required = false) String emailFilter,
                                           @RequestParam(required = false) Long gradoFilter) {
        try {
            CoordinadoresDto coordinadorDto = coordinadoresService.buscarPorCodigo(idCoordinador);
            model.addAttribute("coordinadorParaFormulario", coordinadoresMapper.toEntity(coordinadorDto));
            model.addAttribute("editar", true);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: No se pudo encontrar al coordinador para editar.");
            return "redirect:/coordinadores";
        }
        return mostrarPaginaCoordinadores(model, nombreFilter, apellidoFilter, emailFilter, gradoFilter, null);
    }

    @PostMapping("/guardar")
    public String guardarCoordinador(@ModelAttribute("coordinadorParaFormulario") Coordinadores coordinadorEntity, RedirectAttributes redirectAttributes) {
        try {
            if (coordinadorEntity.getIdCoordinador() == null) {
                coordinadoresService.guardarCoordinador(coordinadoresMapper.toDto(coordinadorEntity));
                redirectAttributes.addFlashAttribute("successMessage", "Coordinador creado correctamente.");
            } else {
                if (coordinadorEntity.getContrasena() == null || coordinadorEntity.getContrasena().isEmpty()) {
                    CoordinadoresDto coordinadorActual = coordinadoresService.buscarPorCodigo(coordinadorEntity.getIdCoordinador());
                    coordinadorEntity.setContrasena(coordinadorActual.contrasena());
                }
                ModCoordinadoresDto modDto = new ModCoordinadoresDto(coordinadorEntity.getNombreCompleto(), coordinadorEntity.getApellidoCompleto(), coordinadorEntity.getEmail(), coordinadorEntity.getContrasena(), coordinadorEntity.getIdGrado());
                coordinadoresService.modificarCoordinador(coordinadorEntity.getIdCoordinador(), modDto);
                redirectAttributes.addFlashAttribute("successMessage", "Coordinador actualizado correctamente.");
            }
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: El email '" + coordinadorEntity.getEmail() + "' ya está registrado.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ocurrió un error inesperado al guardar al coordinador.");
        }
        return "redirect:/coordinadores";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarCoordinador(@PathVariable("id") Long idCoordinador, RedirectAttributes redirectAttributes) {
        try {
            coordinadoresService.eliminarCoordinador(idCoordinador);
            redirectAttributes.addFlashAttribute("successMessage", "Coordinador eliminado correctamente.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Acción denegada: No se puede eliminar al coordinador porque está en uso.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ocurrió un error inesperado al eliminar al coordinador.");
        }
        return "redirect:/coordinadores";
    }
}