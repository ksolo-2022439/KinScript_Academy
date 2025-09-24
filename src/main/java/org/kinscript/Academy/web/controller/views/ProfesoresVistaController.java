package org.kinscript.Academy.web.controller.views;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.kinscript.Academy.dominio.dto.ModProfesoresDto;
import org.kinscript.Academy.dominio.dto.ProfesoresDto;
import org.kinscript.Academy.dominio.service.ProfesoresService;
import org.kinscript.Academy.persistence.entity.Profesores;
import org.kinscript.Academy.persistence.mapper.ProfesoresMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named("profesoresVistaController")
@ViewScoped
@Getter
@Setter
public class ProfesoresVistaController implements Serializable {

    @Autowired
    private ProfesoresService profesoresService;
    @Autowired
    private ProfesoresMapper profesoresMapper;

    private List<Profesores> profesores;
    private Profesores profesorSeleccionado;

    @PostConstruct
    public void init() {
        cargarProfesores();
    }

    private void cargarProfesores() {
        List<ProfesoresDto> dtos = profesoresService.obtenerTodo();
        this.profesores = dtos.stream()
                .map(profesoresMapper::toEntity)
                .collect(Collectors.toList());
    }

    public void prepararNuevoProfesor() {
        this.profesorSeleccionado = new Profesores();
    }

    public void guardarProfesor() {
        try {
            if (this.profesorSeleccionado.getIdProfesor() == null) {
                ProfesoresDto nuevoDto = profesoresMapper.toDto(this.profesorSeleccionado);
                profesoresService.guardarProfesor(nuevoDto);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Profesor Creado", "Se ha registrado al nuevo profesor."));
            } else {
                ModProfesoresDto modDto = new ModProfesoresDto(
                        profesorSeleccionado.getNombreCompleto(),
                        profesorSeleccionado.getApellidoCompleto(),
                        profesorSeleccionado.getDireccion(),
                        profesorSeleccionado.getNumeroTelefono(),
                        profesorSeleccionado.getEmail(),
                        profesorSeleccionado.getContrasena()
                );
                profesoresService.modificarProfesor(this.profesorSeleccionado.getIdProfesor(), modDto);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Profesor Actualizado", "Los datos del profesor han sido actualizados."));
            }
            cargarProfesores();
            this.profesorSeleccionado = null;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un error al guardar al profesor: " + e.getMessage()));
        }
    }

    public void eliminarProfesor() {
        if (this.profesorSeleccionado != null && this.profesorSeleccionado.getIdProfesor() != null) {
            try {
                profesoresService.eliminarProfesor(this.profesorSeleccionado.getIdProfesor());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Profesor Eliminado", "El profesor ha sido eliminado correctamente."));
                cargarProfesores();
                this.profesorSeleccionado = null;
            } catch (DataIntegrityViolationException e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Acción Denegada", "No se puede eliminar al profesor porque está asignado a otras tablas (ej. cursos, materias)."));
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un error inesperado al eliminar al profesor."));
            }
        }
    }
}