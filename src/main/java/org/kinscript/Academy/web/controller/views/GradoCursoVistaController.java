package org.kinscript.Academy.web.controller.views;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.kinscript.Academy.dominio.dto.GradoCursoDto;
import org.kinscript.Academy.dominio.service.CursosService;
import org.kinscript.Academy.dominio.service.GradoCursoService;
import org.kinscript.Academy.dominio.service.GradosService;
import org.kinscript.Academy.persistence.entity.Cursos;
import org.kinscript.Academy.persistence.entity.GradoCurso;
import org.kinscript.Academy.persistence.entity.Grados;
import org.kinscript.Academy.persistence.mapper.CursosMapper;
import org.kinscript.Academy.persistence.mapper.GradosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Named("gradoCursoVistaController")
@ViewScoped
@Getter
@Setter
public class GradoCursoVistaController implements Serializable {

    @Autowired
    private GradoCursoService gradoCursoService;
    @Autowired
    private GradosService gradosService;
    @Autowired
    private CursosService cursosService;
    @Autowired
    private GradosMapper gradosMapper;
    @Autowired
    private CursosMapper cursosMapper;

    private List<GradoCurso> todasLasAsociaciones;
    private GradoCurso nuevaAsociacion;
    private GradoCurso asociacionSeleccionada;
    private List<Grados> listaGrados;
    private List<Cursos> listaCursos;

    @PostConstruct
    public void init() {
        cargarListasSoporte();
        cargarTodasLasAsociaciones();
    }

    private void cargarListasSoporte() {
        this.listaGrados = gradosService.obtenerTodo().stream()
                .map(gradosMapper::toEntity)
                .collect(Collectors.toList());
        this.listaCursos = cursosService.obtenerTodo().stream()
                .map(cursosMapper::toEntity)
                .collect(Collectors.toList());
    }

    public void cargarTodasLasAsociaciones() {
        List<GradoCursoDto> dtos = gradoCursoService.obtenerTodo();

        Map<Long, Cursos> cursosMap = listaCursos.stream()
                .collect(Collectors.toMap(Cursos::getIdCurso, Function.identity()));
        Map<Long, Grados> gradosMap = listaGrados.stream()
                .collect(Collectors.toMap(Grados::getIdGrado, Function.identity()));

        this.todasLasAsociaciones = dtos.stream().map(dto -> {
            GradoCurso gc = new GradoCurso();
            gc.setIdGrado(dto.idGrado());
            gc.setIdCurso(dto.idCurso());
            gc.setGrado(gradosMap.get(dto.idGrado()));
            gc.setCurso(cursosMap.get(dto.idCurso()));
            return gc;
        }).collect(Collectors.toList());
    }

    public void prepararNuevaAsociacion() {
        this.nuevaAsociacion = new GradoCurso();
        this.nuevaAsociacion.setGrado(new Grados());
        this.nuevaAsociacion.setCurso(new Cursos());
    }

    public void guardarAsociacion() {
        if (nuevaAsociacion != null && nuevaAsociacion.getGrado() != null && nuevaAsociacion.getGrado().getIdGrado() != null
                && nuevaAsociacion.getCurso() != null && nuevaAsociacion.getCurso().getIdCurso() != null) {
            try {
                GradoCursoDto dto = new GradoCursoDto(nuevaAsociacion.getGrado().getIdGrado(), nuevaAsociacion.getCurso().getIdCurso());
                gradoCursoService.guardarAsociacion(dto);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Asociación Creada", "El curso fue asociado al grado."));
                cargarTodasLasAsociaciones();
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El curso ya está asociado a este grado."));
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", "Debe seleccionar un grado y un curso."));
        }
    }

    public void eliminarAsociacion() {
        if (asociacionSeleccionada != null) {
            try {
                gradoCursoService.eliminarAsociacion(asociacionSeleccionada.getIdGrado(), asociacionSeleccionada.getIdCurso());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Asociación Eliminada", "Se ha eliminado el curso del grado."));
                cargarTodasLasAsociaciones();
                asociacionSeleccionada = null;
            } catch (DataIntegrityViolationException e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Acción Denegada", "La asociación está en uso."));
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un error inesperado."));
            }
        }
    }
}