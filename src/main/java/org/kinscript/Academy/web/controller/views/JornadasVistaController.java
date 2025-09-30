package org.kinscript.Academy.web.controller.views;

import org.kinscript.Academy.dominio.dto.JornadasDto;
import org.kinscript.Academy.dominio.dto.ModJornadasDto;
import org.kinscript.Academy.dominio.service.JornadasService;
import org.kinscript.Academy.persistence.entity.Jornadas;
import org.kinscript.Academy.persistence.mapper.JornadasMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/jornadas")
public class JornadasVistaController {

    @Autowired
    private JornadasService jornadasService;
    @Autowired
    private JornadasMapper jornadasMapper;

    @GetMapping
    public String mostrarPaginaJornadas(Model model, @RequestParam(name = "add", required = false) Boolean add) {
        List<JornadasDto> jornadas = jornadasService.obtenerTodo();
        model.addAttribute("jornadas", jornadas);

        model.addAttribute("totalJornadas", jornadas.size());
        model.addAttribute("jornadasActivas", jornadas.size());

        if (!model.containsAttribute("jornadaParaFormulario")) {
            model.addAttribute("jornadaParaFormulario", new Jornadas());
        }

        model.addAttribute("paginaActiva", "jornadas");

        if (Boolean.TRUE.equals(add)) {
            model.addAttribute("openAddModal", true);
        }

        return "gestion-jornadas";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Long idJornada, Model model, RedirectAttributes redirectAttributes) {
        try {
            JornadasDto jornadaDto = jornadasService.buscarPorCodigo(idJornada);
            if (jornadaDto == null) {
                throw new IllegalArgumentException("ID de Jornada inválido:" + idJornada);
            }
            model.addAttribute("jornadaParaFormulario", jornadasMapper.toEntity(jornadaDto));
            model.addAttribute("editar", true);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: No se pudo encontrar la jornada para editar.");
            return "redirect:/jornadas";
        }
        return mostrarPaginaJornadas(model, null);
    }

    @PostMapping("/guardar")
    public String guardarJornada(@ModelAttribute("jornadaParaFormulario") Jornadas jornadaEntity, RedirectAttributes redirectAttributes) {
        try {
            if (jornadaEntity.getIdJornada() == null) {
                JornadasDto nuevoDto = jornadasMapper.toDto(jornadaEntity);
                jornadasService.guardarJornadas(nuevoDto);
                redirectAttributes.addFlashAttribute("successMessage", "Jornada creada correctamente.");
            } else {
                ModJornadasDto modDto = new ModJornadasDto(jornadaEntity.getNombreJornada());
                jornadasService.modificarJornadas(jornadaEntity.getIdJornada(), modDto);
                redirectAttributes.addFlashAttribute("successMessage", "Jornada actualizada correctamente.");
            }
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: El nombre de la jornada '" + jornadaEntity.getNombreJornada() + "' ya existe.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ocurrió un error inesperado al guardar la jornada.");
        }
        return "redirect:/jornadas";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarJornada(@PathVariable("id") Long idJornada, RedirectAttributes redirectAttributes) {
        try {
            jornadasService.eliminarJornadas(idJornada);
            redirectAttributes.addFlashAttribute("successMessage", "Jornada eliminada correctamente.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Acción denegada: No se puede eliminar la jornada porque está asignada a uno o más alumnos.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ocurrió un error inesperado al eliminar la jornada.");
        }
        return "redirect:/jornadas";
    }
}