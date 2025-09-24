package org.kinscript.Academy.web.controller.views;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.kinscript.Academy.dominio.dto.CursosDto;
import org.kinscript.Academy.dominio.dto.ModCursosDto;
import org.kinscript.Academy.dominio.service.CursosService;
import org.kinscript.Academy.persistence.entity.Cursos;
import org.kinscript.Academy.persistence.mapper.CursosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named("cursosVistaController")
@ViewScoped
@Getter
@Setter
public class CursosVistaController implements Serializable {

    @Autowired
    private CursosService cursosService;

    @Autowired
    private CursosMapper cursosMapper;

    private List<Cursos> cursos;
    private Cursos cursoSeleccionado;

    @PostConstruct
    public void init() {
        cargarCursos();
    }

    private void cargarCursos() {
        List<CursosDto> dtos = cursosService.obtenerTodo();
        this.cursos = dtos.stream()
                .map(cursosMapper::toEntity)
                .collect(Collectors.toList());
    }

    public void prepararNuevoCurso() {
        this.cursoSeleccionado = new Cursos();
    }

    public void guardarCurso() {
        try {
            if (this.cursoSeleccionado.getIdCurso() == null) {
                // Crear nuevo curso
                CursosDto nuevoDto = cursosMapper.toDto(this.cursoSeleccionado);
                cursosService.guardarCurso(nuevoDto);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Curso Creado", "Se ha registrado el nuevo curso."));
            } else {
                // Modificar curso existente
                ModCursosDto modDto = new ModCursosDto(
                        cursoSeleccionado.getNombreCurso()
                );
                cursosService.modificarCurso(this.cursoSeleccionado.getIdCurso(), modDto);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Curso Actualizado", "Los datos han sido actualizados."));
            }
            cargarCursos();
            this.cursoSeleccionado = null;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un error al guardar el curso."));
        }
    }

    public void eliminarCurso() {
        if (this.cursoSeleccionado != null && this.cursoSeleccionado.getIdCurso() != null) {
            try {
                cursosService.eliminarCurso(this.cursoSeleccionado.getIdCurso());
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Curso Eliminado", "El registro ha sido eliminado."));
                cargarCursos();
                this.cursoSeleccionado = null;
            } catch (DataIntegrityViolationException e) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Acción Denegada", "No se puede eliminar el curso porque está en uso."));
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un error inesperado al eliminar."));
            }
        }
    }
}
