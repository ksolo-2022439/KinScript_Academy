package org.kinscript.Academy.web.controller.views;

import org.kinscript.Academy.dominio.dto.ModTutoresDto;
import org.kinscript.Academy.dominio.dto.TutoresDto;
import org.kinscript.Academy.dominio.service.TutoresService;
import org.kinscript.Academy.persistence.entity.Tutores;
import org.kinscript.Academy.persistence.mapper.TutoresMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/tutores")
public class TutoresVistaController {

    @Autowired
    private TutoresService tutoresService;
    @Autowired
    private TutoresMapper tutoresMapper;

    @GetMapping
    public String mostrarPaginaTutores(Model model,
                                       @RequestParam(required = false) String nombreFilter,
                                       @RequestParam(required = false) String telefonoFilter,
                                       @RequestParam(name = "add", required = false) Boolean add) {

        List<TutoresDto> tutoresFiltrados = tutoresService.buscarPorFiltros(nombreFilter, telefonoFilter);
        long totalActivos = tutoresService.contarTotal();

        model.addAttribute("tutores", tutoresFiltrados);
        model.addAttribute("nombreFilter", nombreFilter);
        model.addAttribute("telefonoFilter", telefonoFilter);

        model.addAttribute("totalTutores", tutoresFiltrados.size());
        model.addAttribute("tutoresActivos", totalActivos);

        if (!model.containsAttribute("tutorParaFormulario")) {
            model.addAttribute("tutorParaFormulario", new Tutores());
        }

        model.addAttribute("paginaActiva", "tutores");

        if (Boolean.TRUE.equals(add)) {
            model.addAttribute("openAddModal", true);
        }

        return "gestion-tutores";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Integer idTutor, Model model, RedirectAttributes redirectAttributes,
                                           @RequestParam(required = false) String nombreFilter,
                                           @RequestParam(required = false) String telefonoFilter) {
        try {
            TutoresDto tutorDto = tutoresService.buscarPorCodigo(idTutor)
                    .orElseThrow(() -> new IllegalArgumentException("ID de Tutor inválido:" + idTutor));

            model.addAttribute("tutorParaFormulario", tutoresMapper.toEntity(tutorDto));
            model.addAttribute("editar", true);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: No se pudo encontrar el tutor para editar.");
            return "redirect:/tutores";
        }
        return mostrarPaginaTutores(model, nombreFilter, telefonoFilter, null);
    }

    @PostMapping("/guardar")
    public String guardarTutor(@ModelAttribute("tutorParaFormulario") Tutores tutorEntity, RedirectAttributes redirectAttributes) {
        try {
            if (tutorEntity.getIdTutor() == null) {
                TutoresDto nuevoDto = tutoresMapper.toDto(tutorEntity);
                tutoresService.guardarTutor(nuevoDto);
                redirectAttributes.addFlashAttribute("successMessage", "Tutor creado correctamente.");
            } else {
                ModTutoresDto modDto = new ModTutoresDto(
                        tutorEntity.getNombreCompleto(),
                        tutorEntity.getApellidoCompleto(),
                        tutorEntity.getNumeroTelefono(),
                        tutorEntity.getDireccion()
                );
                tutoresService.modificarTutor(tutorEntity.getIdTutor().intValue(), modDto);
                redirectAttributes.addFlashAttribute("successMessage", "Tutor actualizado correctamente.");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ocurrió un error inesperado al guardar el tutor.");
        }
        return "redirect:/tutores";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarTutor(@PathVariable("id") Integer idTutor, RedirectAttributes redirectAttributes) {
        try {
            tutoresService.eliminarTutor(idTutor);
            redirectAttributes.addFlashAttribute("successMessage", "Tutor eliminado correctamente.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Acción denegada: No se puede eliminar al tutor porque está asignado a uno o más alumnos.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ocurrió un error inesperado al eliminar al tutor.");
        }
        return "redirect:/tutores";
    }
}