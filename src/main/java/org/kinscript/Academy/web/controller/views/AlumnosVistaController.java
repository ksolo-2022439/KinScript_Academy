package org.kinscript.Academy.web.controller.views;

import org.kinscript.Academy.dominio.dto.AlumnosDto;
import org.kinscript.Academy.dominio.dto.GradosDto;
import org.kinscript.Academy.dominio.dto.ModAlumnosDto;
import org.kinscript.Academy.dominio.exception.AlumnoExistsException;
import org.kinscript.Academy.dominio.service.*;
import org.kinscript.Academy.persistence.entity.Alumnos;
import org.kinscript.Academy.persistence.mapper.AlumnosMapper;
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
@RequestMapping("/alumnos")
public class AlumnosVistaController {

    @Autowired
    private AlumnosService alumnosService;
    @Autowired
    private GradosService gradosService;
    @Autowired
    private SeccionesService seccionesService;
    @Autowired
    private JornadasService jornadasService;
    @Autowired
    private CarrerasService carrerasService;
    @Autowired
    private TutoresService tutoresService;
    @Autowired
    private AlumnosMapper alumnosMapper;

    @GetMapping
    public String mostrarPaginaAlumnos(Model model,
                                       @RequestParam(required = false) String carnetFilter,
                                       @RequestParam(required = false) String nombreFilter,
                                       @RequestParam(required = false) String emailFilter,
                                       @RequestParam(name = "add", required = false) Boolean add) {

        List<AlumnosDto> alumnosFiltrados = alumnosService.buscarPorFiltros(carnetFilter, nombreFilter, emailFilter);
        long totalActivos = alumnosService.contarTotal();

        model.addAttribute("alumnos", alumnosFiltrados);
        model.addAttribute("carnetFilter", carnetFilter);
        model.addAttribute("nombreFilter", nombreFilter);
        model.addAttribute("emailFilter", emailFilter);

        model.addAttribute("totalAlumnos", alumnosFiltrados.size());
        model.addAttribute("alumnosActivos", totalActivos);

        List<GradosDto> todosLosGrados = gradosService.obtenerTodo();
        Map<Long, String> gradosMap = todosLosGrados.stream()
                .collect(Collectors.toMap(GradosDto::idGrado, GradosDto::nombreGrado));
        model.addAttribute("gradosMap", gradosMap);

        if (!model.containsAttribute("alumnoParaFormulario")) {
            model.addAttribute("alumnoParaFormulario", new Alumnos());
        }
        cargarListasDesplegables(model);
        model.addAttribute("paginaActiva", "alumnos");

        if (Boolean.TRUE.equals(add)) {
            model.addAttribute("openAddModal", true);
        }
        return "gestion-alumnos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Long idAlumno,
                                           Model model,
                                           RedirectAttributes redirectAttributes,
                                           @RequestParam(required = false) String carnetFilter,
                                           @RequestParam(required = false) String nombreFilter,
                                           @RequestParam(required = false) String emailFilter) {
        try {
            AlumnosDto alumnoDto = alumnosService.buscarPorCodigo(idAlumno);
            Alumnos alumnoEntity = alumnosMapper.toEntity(alumnoDto);
            model.addAttribute("alumnoParaFormulario", alumnoEntity);
            model.addAttribute("editar", true);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: No se pudo encontrar el alumno para editar.");
            return "redirect:/alumnos";
        }

        return mostrarPaginaAlumnos(model, carnetFilter, nombreFilter, emailFilter, null);
    }

    @PostMapping("/guardar")
    public String guardarAlumno(@ModelAttribute("alumnoParaFormulario") Alumnos alumnoEntity, RedirectAttributes redirectAttributes) {
        try {
            if (alumnoEntity.getIdAlumno() == null) {
                AlumnosDto dtoParaGuardar = alumnosMapper.toDto(alumnoEntity);
                alumnosService.guardarAlumno(dtoParaGuardar);
                redirectAttributes.addFlashAttribute("successMessage", "Alumno creado correctamente.");
            } else {
                if (alumnoEntity.getContrasena() == null || alumnoEntity.getContrasena().isEmpty()) {
                    AlumnosDto alumnoActual = alumnosService.buscarPorCodigo(alumnoEntity.getIdAlumno());
                    alumnoEntity.setContrasena(alumnoActual.contrasena());
                }

                ModAlumnosDto modDto = new ModAlumnosDto(
                        alumnoEntity.getCarnetAlumno(),
                        alumnoEntity.getNombreCompleto(),
                        alumnoEntity.getApellidoCompleto(),
                        alumnoEntity.getEmailAcademico(),
                        alumnoEntity.getContrasena(),
                        alumnoEntity.getDireccion(),
                        alumnoEntity.getIdGrado(),
                        alumnoEntity.getIdSeccion(),
                        alumnoEntity.getIdJornada(),
                        alumnoEntity.getIdCarrera(),
                        alumnoEntity.getIdTutor()
                );
                alumnosService.modificarAlumno(alumnoEntity.getIdAlumno(), modDto);
                redirectAttributes.addFlashAttribute("successMessage", "Alumno actualizado correctamente.");
            }
        } catch (AlumnoExistsException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: El carnet '" + alumnoEntity.getCarnetAlumno() + "' ya está registrado.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error de integridad de datos. Verifique que los valores no estén duplicados (ej. email).");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ocurrió un error inesperado al guardar el alumno.");
        }
        return "redirect:/alumnos";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarAlumno(@PathVariable("id") Long idAlumno, RedirectAttributes redirectAttributes) {
        try {
            alumnosService.eliminarAlumno(idAlumno);
            redirectAttributes.addFlashAttribute("successMessage", "Alumno eliminado correctamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error al eliminar el alumno.");
        }
        return "redirect:/alumnos";
    }

    private void cargarListasDesplegables(Model model) {
        model.addAttribute("listaGrados", gradosService.obtenerTodo());
        model.addAttribute("listaSecciones", seccionesService.obtenerSeccion());
        model.addAttribute("listaJornadas", jornadasService.obtenerTodo());
        model.addAttribute("listaCarreras", carrerasService.obtenerTodo());
        model.addAttribute("listaTutores", tutoresService.obtenerTodo());
    }
}