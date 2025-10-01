package org.kinscript.Academy.web.controller.views;

import org.kinscript.Academy.dominio.dto.*;
import org.kinscript.Academy.dominio.service.*;
import org.kinscript.Academy.persistence.entity.ProfesorAsignacion;
import org.kinscript.Academy.persistence.mapper.ProfesorAsignacionMapper;
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
@RequestMapping("/profesorasignacion")
public class ProfesorAsignacionVistaController {

    @Autowired private ProfesorAsignacionService profesorAsignacionService;
    @Autowired private ProfesoresService profesoresService;
    @Autowired private CursosService cursosService;
    @Autowired private GradosService gradosService;
    @Autowired private SeccionesService seccionesService;
    @Autowired private JornadasService jornadasService;
    @Autowired private ProfesorAsignacionMapper profesorAsignacionMapper;

    @GetMapping
    public String mostrarPaginaAsignaciones(Model model,
                                            @RequestParam(required = false) Long profesorFilter,
                                            @RequestParam(required = false) Long cursoFilter,
                                            @RequestParam(required = false) Long gradoFilter,
                                            @RequestParam(required = false) Long seccionFilter,
                                            @RequestParam(required = false) Long jornadaFilter,
                                            @RequestParam(name = "add", required = false) Boolean add) {

        List<ProfesorAsignacionDto> asignacionesFiltradas = profesorAsignacionService.buscarPorFiltros(profesorFilter, cursoFilter, gradoFilter, seccionFilter, jornadaFilter);
        long totalActivos = profesorAsignacionService.contarTotal();

        model.addAttribute("asignaciones", asignacionesFiltradas);
        model.addAttribute("profesorFilter", profesorFilter);
        model.addAttribute("cursoFilter", cursoFilter);
        model.addAttribute("gradoFilter", gradoFilter);
        model.addAttribute("seccionFilter", seccionFilter);
        model.addAttribute("jornadaFilter", jornadaFilter);

        model.addAttribute("totalAsignaciones", asignacionesFiltradas.size());
        model.addAttribute("asignacionesActivas", totalActivos);

        cargarMapasYListas(model);

        if (!model.containsAttribute("asignacionParaFormulario")) {
            model.addAttribute("asignacionParaFormulario", new ProfesorAsignacion());
        }

        model.addAttribute("paginaActiva", "profesorasignacion");

        if (Boolean.TRUE.equals(add)) {
            model.addAttribute("openAddModal", true);
        }
        return "gestion-profesorasignacion";
    }

    @PostMapping("/guardar")
    public String guardarAsignacion(@ModelAttribute("asignacionParaFormulario") ProfesorAsignacion asignacionEntity, RedirectAttributes redirectAttributes) {
        try {
            if (asignacionEntity.getIdProfesor() == null || asignacionEntity.getIdCurso() == null || asignacionEntity.getIdGrado() == null || asignacionEntity.getIdSeccion() == null) {
                redirectAttributes.addFlashAttribute("errorMessage", "Debe seleccionar profesor, curso, grado y sección.");
                return "redirect:/profesorasignacion";
            }
            profesorAsignacionService.guardarAsignacion(profesorAsignacionMapper.toDto(asignacionEntity));
            redirectAttributes.addFlashAttribute("successMessage", "Asignación creada correctamente.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: Esta asignación ya existe.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ocurrió un error inesperado al guardar la asignación.");
        }
        return "redirect:/profesorasignacion";
    }

    @PostMapping("/eliminar")
    public String eliminarAsignacion(@RequestParam Long idProfesor, @RequestParam Long idCurso, @RequestParam Long idGrado, @RequestParam Long idSeccion, RedirectAttributes redirectAttributes) {
        try {
            ProfesorAsignacionDto dto = new ProfesorAsignacionDto(idProfesor, idCurso, idGrado, idSeccion, null);
            profesorAsignacionService.eliminarAsignacion(dto);
            redirectAttributes.addFlashAttribute("successMessage", "Asignación eliminada correctamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ocurrió un error inesperado al eliminar la asignación.");
        }
        return "redirect:/profesorasignacion";
    }

    private void cargarMapasYListas(Model model) {
        List<ProfesoresDto> todosLosProfesores = profesoresService.obtenerTodo();
        List<CursosDto> todosLosCursos = cursosService.obtenerTodo();
        List<GradosDto> todosLosGrados = gradosService.obtenerTodo();
        List<SeccionesDto> todasLasSecciones = seccionesService.obtenerSeccion();
        List<JornadasDto> todasLasJornadas = jornadasService.obtenerTodo();

        model.addAttribute("listaProfesores", todosLosProfesores);
        model.addAttribute("listaCursos", todosLosCursos);
        model.addAttribute("listaGrados", todosLosGrados);
        model.addAttribute("listaSecciones", todasLasSecciones);
        model.addAttribute("listaJornadas", todasLasJornadas);

        model.addAttribute("profesoresMap", todosLosProfesores.stream().collect(Collectors.toMap(ProfesoresDto::idProfesor, p -> p.nombreCompleto() + " " + p.apellidoCompleto())));
        model.addAttribute("cursosMap", todosLosCursos.stream().collect(Collectors.toMap(CursosDto::idCurso, CursosDto::nombreCurso)));
        model.addAttribute("gradosMap", todosLosGrados.stream().collect(Collectors.toMap(GradosDto::idGrado, GradosDto::nombreGrado)));
        model.addAttribute("seccionesMap", todasLasSecciones.stream().collect(Collectors.toMap(SeccionesDto::idSeccion, SeccionesDto::nombreSeccion)));
        model.addAttribute("jornadasMap", todasLasJornadas.stream().collect(Collectors.toMap(JornadasDto::idJornada, JornadasDto::nombreJornada)));
    }
}