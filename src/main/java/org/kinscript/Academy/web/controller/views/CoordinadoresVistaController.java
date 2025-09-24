package org.kinscript.Academy.web.controller.views;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.kinscript.Academy.dominio.dto.CoordinadoresDto;
import org.kinscript.Academy.dominio.dto.ModCoordinadoresDto;
import org.kinscript.Academy.dominio.service.CoordinadoresService;
import org.kinscript.Academy.dominio.service.GradosService;
import org.kinscript.Academy.persistence.entity.Coordinadores;
import org.kinscript.Academy.persistence.entity.Grados;
import org.kinscript.Academy.persistence.mapper.CoordinadoresMapper;
import org.kinscript.Academy.persistence.mapper.GradosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Named("coordinadoresVistaController")
@ViewScoped
@Getter
@Setter
public class CoordinadoresVistaController implements Serializable {

    @Autowired
    private CoordinadoresService coordinadoresService;
    @Autowired
    private GradosService gradosService;
    @Autowired
    private CoordinadoresMapper coordinadoresMapper;
    @Autowired
    private GradosMapper gradosMapper;

    private List<Coordinadores> coordinadores;
    private Coordinadores coordinadorSeleccionado;
    private List<Grados> listaGrados;

    @PostConstruct
    public void init() {
        cargarListasSoporte();
        cargarCoordinadores();
    }

    private void cargarListasSoporte() {
        this.listaGrados = gradosService.obtenerTodo().stream()
                .map(gradosMapper::toEntity)
                .collect(Collectors.toList());
    }

    private void cargarCoordinadores() {
        List<CoordinadoresDto> dtos = coordinadoresService.obtenerTodo();

        List<Coordinadores> coordinadoresNoOptimizado = dtos.stream()
                .map(coordinadoresMapper::toEntity)
                .collect(Collectors.toList());

        Map<Long, Grados> gradosMap = listaGrados.stream()
                .collect(Collectors.toMap(Grados::getIdGrado, Function.identity()));

        coordinadoresNoOptimizado.forEach(coordinador -> {
            if (coordinador.getIdGrado() != null) {
                coordinador.setGrado(gradosMap.get(coordinador.getIdGrado()));
            }
        });

        this.coordinadores = coordinadoresNoOptimizado;
    }

    public void prepararNuevoCoordinador() {
        this.coordinadorSeleccionado = new Coordinadores();
    }

    public void guardarCoordinador() {
        try {
            if (coordinadorSeleccionado.getGrado() != null) {
                coordinadorSeleccionado.setIdGrado(coordinadorSeleccionado.getGrado().getIdGrado());
            }

            if (this.coordinadorSeleccionado.getIdCoordinador() == null) {
                CoordinadoresDto nuevoDto = coordinadoresMapper.toDto(this.coordinadorSeleccionado);
                coordinadoresService.guardarCoordinador(nuevoDto);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Coordinador Creado", "Se ha registrado al nuevo coordinador."));
            } else {
                ModCoordinadoresDto modDto = new ModCoordinadoresDto(
                        coordinadorSeleccionado.getNombreCompleto(),
                        coordinadorSeleccionado.getApellidoCompleto(),
                        coordinadorSeleccionado.getEmail(),
                        coordinadorSeleccionado.getContrasena(),
                        coordinadorSeleccionado.getIdGrado()
                );
                coordinadoresService.modificarCoordinador(this.coordinadorSeleccionado.getIdCoordinador(), modDto);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Coordinador Actualizado", "Los datos han sido actualizados."));
            }
            cargarCoordinadores();
            this.coordinadorSeleccionado = null;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un error al guardar al coordinador."));
        }
    }

    public void eliminarCoordinador() {
        if (this.coordinadorSeleccionado != null && this.coordinadorSeleccionado.getIdCoordinador() != null) {
            try {
                coordinadoresService.eliminarCoordinador(this.coordinadorSeleccionado.getIdCoordinador());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Coordinador Eliminado", "El registro ha sido eliminado."));
                cargarCoordinadores();
                this.coordinadorSeleccionado = null;
            } catch (DataIntegrityViolationException e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Acción Denegada", "No se puede eliminar al coordinador porque está en uso."));
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un error inesperado al eliminar."));
            }
        }
    }
}