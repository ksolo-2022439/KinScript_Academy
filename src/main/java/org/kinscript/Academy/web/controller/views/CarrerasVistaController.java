package org.kinscript.Academy.web.controller.views;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.kinscript.Academy.dominio.dto.CarrerasDto;
import org.kinscript.Academy.dominio.dto.ModCarrerasDto;
import org.kinscript.Academy.dominio.service.CarrerasService;
import org.kinscript.Academy.persistence.entity.Carreras;
import org.kinscript.Academy.persistence.mapper.CarrerasMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named("carrerasVistaController")
@ViewScoped
@Getter
@Setter
public class CarrerasVistaController implements Serializable {

    @Autowired
    private CarrerasService carrerasService;
    @Autowired
    private CarrerasMapper carrerasMapper;

    private List<Carreras> carreras;
    private Carreras carreraSeleccionada;

    @PostConstruct
    public void init() {
        cargarCarreras();
    }

    private void cargarCarreras() {
        this.carreras = carrerasService.obtenerTodo().stream()
                .map(carrerasMapper::toEntity)
                .collect(Collectors.toList());
    }

    public void prepararNuevaCarrera() {
        this.carreraSeleccionada = new Carreras();
    }

    public void guardarCarrera() {
        try {
            if (this.carreraSeleccionada.getIdCarrera() == null) {
                CarrerasDto nuevoDto = carrerasMapper.toDto(this.carreraSeleccionada);
                carrerasService.guardarGrados(nuevoDto);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Carrera Creada", "Se ha registrado la nueva carrera."));
            } else {
                ModCarrerasDto modDto = new ModCarrerasDto(
                        carreraSeleccionada.getNombreCarrera()
                );
                carrerasService.modificarGrados(this.carreraSeleccionada.getIdCarrera(), modDto);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Carrera Actualizada", "Los datos han sido actualizados."));
            }
            cargarCarreras();
            this.carreraSeleccionada = null;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un error al guardar la carrera."));
        }
    }

    public void eliminarCarrera() {
        if (this.carreraSeleccionada != null && this.carreraSeleccionada.getIdCarrera() != null) {
            try {
                carrerasService.eliminarGrados(this.carreraSeleccionada.getIdCarrera());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Carrera Eliminada", "El registro ha sido eliminado."));
                cargarCarreras();
                this.carreraSeleccionada = null;
            } catch (DataIntegrityViolationException e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Acción Denegada", "No se puede eliminar la carrera porque está en uso."));
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un error inesperado al eliminar."));
            }
        }
    }
}