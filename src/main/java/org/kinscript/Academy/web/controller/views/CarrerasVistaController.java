package org.kinscript.Academy.web.controller.views;

import org.kinscript.Academy.dominio.dto.CarrerasDto;
import org.kinscript.Academy.dominio.dto.ModCarrerasDto;
import org.kinscript.Academy.dominio.service.CarrerasService;
import org.kinscript.Academy.persistence.entity.Carreras;
import org.kinscript.Academy.persistence.mapper.CarrerasMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/carreras")
public class CarrerasVistaController {

    @Autowired
    private CarrerasService carrerasService;
    @Autowired
    private CarrerasMapper carrerasMapper;

    @GetMapping
    public String mostrarPaginaCarreras(Model model, @RequestParam(name = "add", required = false) Boolean add) {
        List<CarrerasDto> carreras = carrerasService.obtenerTodo();
        model.addAttribute("carreras", carreras);

        model.addAttribute("totalCarreras", carreras.size());
        model.addAttribute("carrerasActivas", carreras.size());

        if (!model.containsAttribute("carreraParaFormulario")) {
            model.addAttribute("carreraParaFormulario", new Carreras());
        }

        model.addAttribute("paginaActiva", "carreras");

        if (Boolean.TRUE.equals(add)) {
            model.addAttribute("openAddModal", true);
        }

        return "gestion-carreras";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Long idCarrera, Model model, RedirectAttributes redirectAttributes) {
        try {
            CarrerasDto carreraDto = carrerasService.buscarPorCodigo(idCarrera);
            if (carreraDto == null) {
                throw new IllegalArgumentException("ID de Carrera inválido:" + idCarrera);
            }
            model.addAttribute("carreraParaFormulario", carrerasMapper.toEntity(carreraDto));
            model.addAttribute("editar", true);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: No se pudo encontrar la carrera para editar.");
            return "redirect:/carreras";
        }
        return mostrarPaginaCarreras(model, null);
    }

    @PostMapping("/guardar")
    public String guardarCarrera(@ModelAttribute("carreraParaFormulario") Carreras carreraEntity, RedirectAttributes redirectAttributes) {
        try {
            if (carreraEntity.getIdCarrera() == null) {
                CarrerasDto nuevoDto = carrerasMapper.toDto(carreraEntity);
                carrerasService.guardarCarrera(nuevoDto);
                redirectAttributes.addFlashAttribute("successMessage", "Carrera creada correctamente.");
            } else {
                ModCarrerasDto modDto = new ModCarrerasDto(carreraEntity.getNombreCarrera());
                carrerasService.modificarCarrera(carreraEntity.getIdCarrera(), modDto);
                redirectAttributes.addFlashAttribute("successMessage", "Carrera actualizada correctamente.");
            }
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: El nombre de la carrera '" + carreraEntity.getNombreCarrera() + "' ya existe.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ocurrió un error inesperado al guardar la carrera.");
        }
        return "redirect:/carreras";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarCarrera(@PathVariable("id") Long idCarrera, RedirectAttributes redirectAttributes) {
        try {
            carrerasService.eliminarCarrera(idCarrera);
            redirectAttributes.addFlashAttribute("successMessage", "Carrera eliminada correctamente.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Acción denegada: No se puede eliminar la carrera porque está asignada a uno o más alumnos.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ocurrió un error inesperado al eliminar la carrera.");
        }
        return "redirect:/carreras";
    }
}