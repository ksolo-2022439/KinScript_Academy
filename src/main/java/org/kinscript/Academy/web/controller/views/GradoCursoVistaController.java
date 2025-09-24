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
import java.util.Collections;
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

    private Long idGradoSeleccionado;
    private Long idCursoParaAsociar;
    private GradoCurso asociacionSeleccionada;

    private List<Grados> listaGrados;
    private List<Cursos> listaCursos;
    private List<GradoCurso> cursosDelGrado;

    @PostConstruct
    public void init() {
        cargarListasSoporte();
    }

    private void cargarListasSoporte() {
        this.listaGrados = gradosService.obtenerTodo().stream()
                .map(gradosMapper::toEntity)
                .collect(Collectors.toList());
        this.listaCursos = cursosService.obtenerTodo().stream()
                .map(cursosMapper::toEntity)
                .collect(Collectors.toList());
    }

    public void cargarCursosPorGrado() {
        if (idGradoSeleccionado == null) {
            this.cursosDelGrado = Collections.emptyList();
            return;
        }

        List<GradoCursoDto> dtos = gradoCursoService.obtenerCursosPorGrado(idGradoSeleccionado);

        Map<Long, Cursos> cursosMap = listaCursos.stream()
                .collect(Collectors.toMap(Cursos::getIdCurso, Function.identity()));
        Map<Long, Grados> gradosMap = listaGrados.stream()
                .collect(Collectors.toMap(Grados::getIdGrado, Function.identity()));

        this.cursosDelGrado = dtos.stream().map(dto -> {
            GradoCurso gc = new GradoCurso();
            gc.setIdGrado(dto.idGrado());
            gc.setIdCurso(dto.idCurso());
            gc.setGrado(gradosMap.get(dto.idGrado()));
            gc.setCurso(cursosMap.get(dto.idCurso()));
            return gc;
        }).collect(Collectors.toList());
    }

    public void asociarCurso() {
        if (idGradoSeleccionado != null && idCursoParaAsociar != null) {
            try {
                GradoCursoDto dto = new GradoCursoDto(idGradoSeleccionado, idCursoParaAsociar);
                gradoCursoService.guardarAsociacion(dto);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Asociación Creada", "El curso fue asociado al grado."));
                cargarCursosPorGrado();
                idCursoParaAsociar = null;
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
                cargarCursosPorGrado();
                asociacionSeleccionada = null;
            } catch (DataIntegrityViolationException e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Acción Denegada", "La asociación está en uso."));
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un error inesperado."));
            }
        }
    }
}