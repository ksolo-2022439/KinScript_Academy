package org.kinscript.Academy.web.controller.views;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.kinscript.Academy.dominio.dto.ModNotasDto;
import org.kinscript.Academy.dominio.dto.NotasDto;
import org.kinscript.Academy.dominio.service.AlumnosService;
import org.kinscript.Academy.dominio.service.CursosService;
import org.kinscript.Academy.dominio.service.NotasService;
import org.kinscript.Academy.persistence.entity.Alumnos;
import org.kinscript.Academy.persistence.entity.Cursos;
import org.kinscript.Academy.persistence.entity.Notas;
import org.kinscript.Academy.persistence.mapper.AlumnosMapper;
import org.kinscript.Academy.persistence.mapper.CursosMapper;
import org.kinscript.Academy.persistence.mapper.NotasMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Named("notasVistaController")
@ViewScoped
@Getter
@Setter
public class NotasVistaController implements Serializable {

    @Autowired private NotasService notasService;
    @Autowired private AlumnosService alumnosService;
    @Autowired private CursosService cursosService;
    @Autowired private NotasMapper notasMapper;
    @Autowired private AlumnosMapper alumnosMapper;
    @Autowired private CursosMapper cursosMapper;

    private List<Notas> notas;
    private Notas notaSeleccionada;
    private List<Alumnos> listaAlumnos;
    private List<Cursos> listaCursos;

    @PostConstruct
    public void init() {
        cargarListasSoporte();
        cargarNotas();
    }

    private void cargarListasSoporte() {
        this.listaAlumnos = alumnosService.obtenerTodo().stream()
                .map(alumnosMapper::toEntity)
                .collect(Collectors.toList());
        this.listaCursos = cursosService.obtenerTodo().stream()
                .map(cursosMapper::toEntity)
                .collect(Collectors.toList());
    }

    private void cargarNotas() {
        List<Notas> notasNoOptimizadas = notasService.obtenerTodo().stream()
                .map(notasMapper::toEntity)
                .collect(Collectors.toList());

        Map<Long, Alumnos> alumnosMap = listaAlumnos.stream()
                .collect(Collectors.toMap(Alumnos::getIdAlumno, Function.identity()));
        Map<Long, Cursos> cursosMap = listaCursos.stream()
                .collect(Collectors.toMap(Cursos::getIdCurso, Function.identity()));

        notasNoOptimizadas.forEach(nota -> {
            if (nota.getIdAlumno() != null) {
                nota.setAlumno(alumnosMap.get(nota.getIdAlumno()));
            }
            if (nota.getIdCurso() != null) {
                nota.setCurso(cursosMap.get(nota.getIdCurso()));
            }
        });

        this.notas = notasNoOptimizadas;
    }

    public void prepararNuevaNota() {
        this.notaSeleccionada = new Notas();
    }

    public void guardarNota() {
        try {
            if (notaSeleccionada.getAlumno() != null) {
                notaSeleccionada.setIdAlumno(notaSeleccionada.getAlumno().getIdAlumno());
            }
            if (notaSeleccionada.getCurso() != null) {
                notaSeleccionada.setIdCurso(notaSeleccionada.getCurso().getIdCurso());
            }

            if (this.notaSeleccionada.getIdNota() == null) {
                NotasDto nuevoDto = notasMapper.toDto(this.notaSeleccionada);
                notasService.guardarNota(nuevoDto);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nota Creada", "Se ha registrado la nueva nota."));
            } else {
                ModNotasDto modDto = new ModNotasDto(
                        notaSeleccionada.getIdAlumno(),
                        notaSeleccionada.getIdCurso(),
                        notaSeleccionada.getBimestre1(),
                        notaSeleccionada.getBimestre2(),
                        notaSeleccionada.getBimestre3(),
                        notaSeleccionada.getBimestre4()
                );
                notasService.modificarNota(this.notaSeleccionada.getIdNota(), modDto);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nota Actualizada", "Los datos han sido actualizados."));
            }
            cargarNotas();
            this.notaSeleccionada = null;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un error al guardar la nota."));
        }
    }

    public void eliminarNota() {
        if (this.notaSeleccionada != null && this.notaSeleccionada.getIdNota() != null) {
            try {
                notasService.eliminarNota(this.notaSeleccionada.getIdNota());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nota Eliminada", "El registro ha sido eliminado."));
                cargarNotas();
                this.notaSeleccionada = null;
            } catch (DataIntegrityViolationException e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Acción Denegada", "No se puede eliminar esta nota."));
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un error inesperado al eliminar."));
            }
        }
    }
}