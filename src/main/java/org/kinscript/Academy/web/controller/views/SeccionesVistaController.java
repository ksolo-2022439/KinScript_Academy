package org.kinscript.Academy.web.controller.views;

import lombok.Getter;
import lombok.Setter;
import org.kinscript.Academy.dominio.dto.ModSeccionesDto;
import org.kinscript.Academy.dominio.dto.SeccionesDto;
import org.kinscript.Academy.dominio.service.SeccionesService;
import org.kinscript.Academy.persistence.entity.Secciones;
import org.kinscript.Academy.persistence.mapper.SeccionesMapper;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named("seccionesVistaController")
@ViewScoped
public class SeccionesVistaController implements Serializable {

    @Autowired
    private SeccionesService seccionesService;

    @Autowired
    private SeccionesMapper seccionesMapper;

    @Setter
    @Getter
    private List<Secciones> secciones;

    @Setter
    @Getter
    private Secciones seccionSeleccionada;

    @PostConstruct
    public void init() {
        cargarSecciones();
    }

    private void cargarSecciones() {
        List<SeccionesDto> seccionesDto = seccionesService.obtenerSeccion();
        this.secciones = seccionesDto.stream()
                .map(seccionesMapper::toEntity)
                .collect(Collectors.toList());
    }

    public void prepararNuevaSeccion() {
        this.seccionSeleccionada = new Secciones();
    }

    public void guardarSeccion() {
        try {
            if (this.seccionSeleccionada.getIdSeccion() == null) {
                SeccionesDto nuevaSeccionDto = seccionesMapper.toDto(this.seccionSeleccionada);
                SeccionesDto seccionGuardada = seccionesService.guardarSeccion(nuevaSeccionDto);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sección Creada", "Se ha creado la sección: " + seccionGuardada.nombreSeccion()));
            } else {
                ModSeccionesDto modSeccionesDto = new ModSeccionesDto(this.seccionSeleccionada.getNombreSeccion());
                SeccionesDto seccionActualizada = seccionesService.modificarSeccion(this.seccionSeleccionada.getIdSeccion(), modSeccionesDto);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sección Actualizada", "Se ha actualizado la sección: " + seccionActualizada.nombreSeccion()));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un error al guardar la sección: " + e.getMessage()));
        }

        cargarSecciones();
        this.seccionSeleccionada = null;
    }

    public void eliminarSeccion() {
        if (this.seccionSeleccionada != null && this.seccionSeleccionada.getIdSeccion() != null) {
            try {
                seccionesService.eliminarSeccion(this.seccionSeleccionada.getIdSeccion());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sección Eliminada", "Se ha eliminado la sección correctamente."));
                cargarSecciones();
                this.seccionSeleccionada = null;
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un error al eliminar la sección."));
            }
        }
    }
}