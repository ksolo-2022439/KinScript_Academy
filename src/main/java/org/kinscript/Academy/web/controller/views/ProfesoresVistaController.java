package org.kinscript.Academy.web.controller.views;

import org.kinscript.Academy.dominio.dto.ModProfesoresDto;
import org.kinscript.Academy.dominio.dto.ProfesoresDto;
import org.kinscript.Academy.dominio.service.ProfesoresService;
import org.kinscript.Academy.persistence.entity.Profesores;
import org.kinscript.Academy.persistence.mapper.ProfesoresMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/profesores")
public class ProfesoresVistaController {

    @Autowired private ProfesoresService profesoresService;
    @Autowired private ProfesoresMapper profesoresMapper;

    @GetMapping
    public String mostrarPaginaProfesores(Model model,
                                          @RequestParam(required = false) String nombreFilter,
                                          @RequestParam(required = false) String apellidoFilter,
                                          @RequestParam(required = false) String telefonoFilter,
                                          @RequestParam(required = false) String emailFilter,
                                          @RequestParam(name = "add", required = false) Boolean add) {

        List<ProfesoresDto> profesoresFiltrados = profesoresService.buscarPorFiltros(nombreFilter, apellidoFilter, telefonoFilter, emailFilter);
        long totalActivos = profesoresService.contarTotal();

        model.addAttribute("profesores", profesoresFiltrados);
        model.addAttribute("nombreFilter", nombreFilter);
        model.addAttribute("apellidoFilter", apellidoFilter);
        model.addAttribute("telefonoFilter", telefonoFilter);
        model.addAttribute("emailFilter", emailFilter);

        model.addAttribute("totalProfesores", profesoresFiltrados.size());
        model.addAttribute("profesoresActivos", totalActivos);

        if (!model.containsAttribute("profesorParaFormulario")) {
            model.addAttribute("profesorParaFormulario", new Profesores());
        }

        model.addAttribute("paginaActiva", "profesores");

        if (Boolean.TRUE.equals(add)) {
            model.addAttribute("openAddModal", true);
        }
        return "gestion-profesores";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Long idProfesor, Model model, RedirectAttributes redirectAttributes,
                                           @RequestParam(required = false) String nombreFilter,
                                           @RequestParam(required = false) String apellidoFilter,
                                           @RequestParam(required = false) String telefonoFilter,
                                           @RequestParam(required = false) String emailFilter) {
        try {
            ProfesoresDto profesorDto = profesoresService.buscarPorId(idProfesor);
            model.addAttribute("profesorParaFormulario", profesoresMapper.toEntity(profesorDto));
            model.addAttribute("editar", true);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: No se pudo encontrar al profesor para editar.");
            return "redirect:/profesores";
        }
        return mostrarPaginaProfesores(model, nombreFilter, apellidoFilter, telefonoFilter, emailFilter, null);
    }

    @PostMapping("/guardar")
    public String guardarProfesor(@ModelAttribute("profesorParaFormulario") Profesores profesorEntity, RedirectAttributes redirectAttributes) {
        try {
            if (profesorEntity.getIdProfesor() == null) {
                profesoresService.guardarProfesor(profesoresMapper.toDto(profesorEntity));
                redirectAttributes.addFlashAttribute("successMessage", "Profesor creado correctamente.");
            } else {
                if (profesorEntity.getContrasena() == null || profesorEntity.getContrasena().isEmpty()) {
                    ProfesoresDto profesorActual = profesoresService.buscarPorId(profesorEntity.getIdProfesor());
                    profesorEntity.setContrasena(profesorActual.contrasena());
                }
                ModProfesoresDto modDto = new ModProfesoresDto(profesorEntity.getNombreCompleto(), profesorEntity.getApellidoCompleto(), profesorEntity.getDireccion(), profesorEntity.getNumeroTelefono(), profesorEntity.getEmail(), profesorEntity.getContrasena());
                profesoresService.modificarProfesor(profesorEntity.getIdProfesor(), modDto);
                redirectAttributes.addFlashAttribute("successMessage", "Profesor actualizado correctamente.");
            }
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: El email '" + profesorEntity.getEmail() + "' ya está registrado.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ocurrió un error inesperado al guardar al profesor.");
        }
        return "redirect:/profesores";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarProfesor(@PathVariable("id") Long idProfesor, RedirectAttributes redirectAttributes) {
        try {
            profesoresService.eliminarProfesor(idProfesor);
            redirectAttributes.addFlashAttribute("successMessage", "Profesor eliminado correctamente.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Acción denegada: No se puede eliminar al profesor porque está asignado a otras entidades.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ocurrió un error inesperado al eliminar al profesor.");
        }
        return "redirect:/profesores";
    }
}