package org.kinscript.Academy.web.controller.views;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.kinscript.Academy.dominio.dto.ProfesorAsignacionDto;
import org.kinscript.Academy.dominio.service.*;
import org.kinscript.Academy.persistence.entity.*;
import org.kinscript.Academy.persistence.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Named("profesorAsignacionVistaController")
@ViewScoped
@Getter
@Setter
public class ProfesorAsignacionVistaController implements Serializable {

    @Autowired private ProfesorAsignacionService profesorAsignacionService;
    @Autowired private ProfesoresService profesoresService;
    @Autowired private CursosService cursosService;
    @Autowired private GradosService gradosService;
    @Autowired private SeccionesService seccionesService;
    @Autowired private JornadasService jornadasService;

    @Autowired private ProfesorAsignacionMapper profesorAsignacionMapper;
    @Autowired private ProfesoresMapper profesoresMapper;
    @Autowired private CursosMapper cursosMapper;
    @Autowired private GradosMapper gradosMapper;
    @Autowired private SeccionesMapper seccionesMapper;
    @Autowired private JornadasMapper jornadasMapper;

    private List<ProfesorAsignacion> asignaciones;
    private ProfesorAsignacion asignacionSeleccionada;

    private List<Profesores> listaProfesores;
    private List<Cursos> listaCursos;
    private List<Grados> listaGrados;
    private List<Secciones> listaSecciones;
    private List<Jornadas> listaJornadas;

    @PostConstruct
    public void init() {
        cargarListasSoporte();
        cargarAsignaciones();
    }

    private void cargarListasSoporte() {
        listaProfesores = profesoresService.obtenerTodo().stream().map(profesoresMapper::toEntity).collect(Collectors.toList());
        listaCursos = cursosService.obtenerTodo().stream().map(cursosMapper::toEntity).collect(Collectors.toList());
        listaGrados = gradosService.obtenerTodo().stream().map(gradosMapper::toEntity).collect(Collectors.toList());
        listaSecciones = seccionesService.obtenerSeccion().stream().map(seccionesMapper::toEntity).collect(Collectors.toList());
        listaJornadas = jornadasService.obtenerTodo().stream().map(jornadasMapper::toEntity).collect(Collectors.toList());
    }

    private void cargarAsignaciones() {
        List<ProfesorAsignacion> asignacionesNoOptimizadas = profesorAsignacionService.obtenerTodo().stream()
                .map(profesorAsignacionMapper::toEntity)
                .collect(Collectors.toList());

        Map<Long, Profesores> profesoresMap = listaProfesores.stream().collect(Collectors.toMap(Profesores::getIdProfesor, Function.identity()));
        Map<Long, Cursos> cursosMap = listaCursos.stream().collect(Collectors.toMap(Cursos::getIdCurso, Function.identity()));
        Map<Long, Grados> gradosMap = listaGrados.stream().collect(Collectors.toMap(Grados::getIdGrado, Function.identity()));
        Map<Long, Secciones> seccionesMap = listaSecciones.stream().collect(Collectors.toMap(Secciones::getIdSeccion, Function.identity()));
        Map<Long, Jornadas> jornadasMap = listaJornadas.stream().collect(Collectors.toMap(Jornadas::getIdJornada, Function.identity()));

        asignacionesNoOptimizadas.forEach(asignacion -> {
            asignacion.setProfesor(profesoresMap.get(asignacion.getIdProfesor()));
            asignacion.setCurso(cursosMap.get(asignacion.getIdCurso()));
            asignacion.setGrado(gradosMap.get(asignacion.getIdGrado()));
            asignacion.setSeccion(seccionesMap.get(asignacion.getIdSeccion()));
            if (asignacion.getIdJornada() != null) {
                asignacion.setJornada(jornadasMap.get(asignacion.getIdJornada()));
            }
        });

        this.asignaciones = asignacionesNoOptimizadas;
    }

    public void prepararNuevaAsignacion() {
        this.asignacionSeleccionada = new ProfesorAsignacion();
    }

    public void guardarAsignacion() {
        try {
            ProfesorAsignacionDto nuevoDto = new ProfesorAsignacionDto(
                    asignacionSeleccionada.getProfesor().getIdProfesor(),
                    asignacionSeleccionada.getCurso().getIdCurso(),
                    asignacionSeleccionada.getGrado().getIdGrado(),
                    asignacionSeleccionada.getSeccion().getIdSeccion(),
                    asignacionSeleccionada.getJornada() != null ? asignacionSeleccionada.getJornada().getIdJornada() : null
            );

            profesorAsignacionService.guardarAsignacion(nuevoDto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Asignación Creada", "Se ha creado la nueva asignación."));
            cargarAsignaciones();
            this.asignacionSeleccionada = null;
        } catch (DataIntegrityViolationException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Esta asignación ya existe."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un error al guardar la asignación."));
        }
    }

    public void eliminarAsignacion() {
        if (this.asignacionSeleccionada != null) {
            try {
                ProfesorAsignacionDto dtoAEliminar = profesorAsignacionMapper.toDto(this.asignacionSeleccionada);
                profesorAsignacionService.eliminarAsignacion(dtoAEliminar);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Asignación Eliminada", "El registro ha sido eliminado."));
                cargarAsignaciones();
                this.asignacionSeleccionada = null;
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un error inesperado al eliminar."));
            }
        }
    }
}