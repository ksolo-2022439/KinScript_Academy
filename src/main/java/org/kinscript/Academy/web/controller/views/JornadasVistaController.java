package org.kinscript.Academy.web.controller.views;

import lombok.Getter;
import lombok.Setter;
import org.kinscript.Academy.dominio.dto.JornadasDto;
import org.kinscript.Academy.dominio.dto.ModJornadasDto;
import org.kinscript.Academy.dominio.service.JornadasService;
import org.kinscript.Academy.persistence.entity.Jornadas;
import org.kinscript.Academy.persistence.mapper.JornadasMapper;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named("jornadasVistaController")
@ViewScoped
public class JornadasVistaController implements Serializable {

    @Autowired
    private JornadasService jornadasService;

    @Autowired
    private JornadasMapper jornadasMapper;

    @Setter
    @Getter
    private List<Jornadas> jornadas;

    @Setter
    @Getter
    private Jornadas jornadaSeleccionada;

    @PostConstruct
    public void init() {
        cargarJornadas();
    }

    private void cargarJornadas() {
        List<JornadasDto> jornadasDto = jornadasService.obtenerTodo();
        this.jornadas = jornadasDto.stream()
                .map(jornadasMapper::toEntity)
                .collect(Collectors.toList());
    }

    public void prepararNuevaJornada() {
        this.jornadaSeleccionada = new Jornadas();
    }

    public void guardarJornada() {
        try {
            if (this.jornadaSeleccionada.getIdJornada() == null) {
                JornadasDto nuevaJornadaDto = jornadasMapper.toDto(this.jornadaSeleccionada);
                JornadasDto jornadaGuardada = jornadasService.guardarJornadas(nuevaJornadaDto);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Jornada Creada", "Se ha creado la jornada: " + jornadaGuardada.nombreJornada()));
            } else {
                ModJornadasDto modJornadasDto = new ModJornadasDto(this.jornadaSeleccionada.getNombreJornada());
                JornadasDto jornadaActualizada = jornadasService.modificarJornadas(this.jornadaSeleccionada.getIdJornada(), modJornadasDto);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Jornada Actualizada", "Se ha actualizado la jornada: " + jornadaActualizada.nombreJornada()));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un error al guardar la jornada: " + e.getMessage()));
        }

        cargarJornadas();
        this.jornadaSeleccionada = null;
    }

    public void eliminarJornada() {
        if (this.jornadaSeleccionada != null && this.jornadaSeleccionada.getIdJornada() != null) {
            try {
                jornadasService.eliminarJornadas(this.jornadaSeleccionada.getIdJornada());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Jornada Eliminada", "Se ha eliminado la jornada correctamente."));
                cargarJornadas();
                this.jornadaSeleccionada = null;
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un error al eliminar la jornada."));
            }
        }
    }
}