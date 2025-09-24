package org.kinscript.Academy.web.controller.views;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.kinscript.Academy.dominio.dto.ModTutoresDto;
import org.kinscript.Academy.dominio.dto.TutoresDto;
import org.kinscript.Academy.dominio.service.TutoresService;
import org.kinscript.Academy.persistence.entity.Tutores;
import org.kinscript.Academy.persistence.mapper.TutoresMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named("tutoresVistaController")
@ViewScoped
@Getter
@Setter
public class TutoresVistaController implements Serializable {

    @Autowired
    private TutoresService tutoresService;
    @Autowired
    private TutoresMapper tutoresMapper;

    private List<Tutores> tutores;
    private Tutores tutorSeleccionado;

    @PostConstruct
    public void init() {
        cargarTutores();
    }

    private void cargarTutores() {
        this.tutores = tutoresService.obtenerTodo().stream()
                .map(tutoresMapper::toEntity)
                .collect(Collectors.toList());
    }

    public void prepararNuevoTutor() {
        this.tutorSeleccionado = new Tutores();
    }

    public void guardarTutor() {
        try {
            if (this.tutorSeleccionado.getIdTutor() == null) {
                TutoresDto nuevoDto = tutoresMapper.toDto(this.tutorSeleccionado);
                tutoresService.guardarTutor(nuevoDto);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tutor Creado", "Se ha registrado al nuevo tutor."));
            } else {
                ModTutoresDto modDto = new ModTutoresDto(
                        tutorSeleccionado.getNombreCompleto(),
                        tutorSeleccionado.getApellidoCompleto(),
                        tutorSeleccionado.getNumeroTelefono(),
                        tutorSeleccionado.getDireccion()
                );
                tutoresService.modificarTutor(this.tutorSeleccionado.getIdTutor().intValue(), modDto);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tutor Actualizado", "Los datos del tutor han sido actualizados."));
            }
            cargarTutores();
            this.tutorSeleccionado = null;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un error al guardar al tutor."));
        }
    }

    public void eliminarTutor() {
        if (this.tutorSeleccionado != null && this.tutorSeleccionado.getIdTutor() != null) {
            try {
                tutoresService.eliminarTutor(this.tutorSeleccionado.getIdTutor().intValue());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tutor Eliminado", "El tutor ha sido eliminado correctamente."));
                cargarTutores();
                this.tutorSeleccionado = null;
            } catch (DataIntegrityViolationException e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Acción Denegada", "No se puede eliminar al tutor porque está asignado a uno o más alumnos."));
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un error inesperado al eliminar al tutor."));
            }
        }
    }
}