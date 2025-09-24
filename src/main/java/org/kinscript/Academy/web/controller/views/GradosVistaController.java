package org.kinscript.Academy.web.controller.views;

import lombok.Getter;
import lombok.Setter;
import org.kinscript.Academy.dominio.dto.GradosDto;
import org.kinscript.Academy.dominio.dto.ModGradosDto;
import org.kinscript.Academy.dominio.service.GradosService;
import org.kinscript.Academy.persistence.entity.Grados;
import org.kinscript.Academy.persistence.mapper.GradosMapper;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named("gradosVistaController")
@ViewScoped
public class GradosVistaController implements Serializable {

    @Autowired
    private GradosService gradosService;

    @Autowired
    private GradosMapper gradosMapper;

    @Setter
    @Getter
    private List<Grados> grados;

    @Setter
    @Getter
    private Grados gradoSeleccionado;

    @PostConstruct
    public void init() {
        cargarGrados();
    }

    private void cargarGrados() {
        List<GradosDto> gradosDto = gradosService.obtenerTodo();
        this.grados = gradosDto.stream()
                .map(gradosMapper::toEntity)
                .collect(Collectors.toList());
    }

    public void prepararNuevoGrado() {
        this.gradoSeleccionado = new Grados();
    }

    public void guardarGrado() {
        try {
            if (this.gradoSeleccionado.getIdGrado() == null) {
                GradosDto nuevoGradoDto = gradosMapper.toDto(this.gradoSeleccionado);
                GradosDto gradoGuardado = gradosService.guardarGrados(nuevoGradoDto);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Grado Creado", "Se ha creado el grado: " + gradoGuardado.nombreGrado()));
            } else {
                ModGradosDto modGradosDto = new ModGradosDto(this.gradoSeleccionado.getNombreGrado());
                GradosDto gradoActualizado = gradosService.modificarGrados(this.gradoSeleccionado.getIdGrado(), modGradosDto);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Grado Actualizado", "Se ha actualizado el grado: " + gradoActualizado.nombreGrado()));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un error al guardar el grado: " + e.getMessage()));
        }

        cargarGrados();
        this.gradoSeleccionado = null;
    }

    public void eliminarGrado() {
        if (this.gradoSeleccionado != null && this.gradoSeleccionado.getIdGrado() != null) {
            try {
                gradosService.eliminarGrados(this.gradoSeleccionado.getIdGrado());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Grado Eliminado", "Se ha eliminado el grado correctamente."));
                cargarGrados();
                this.gradoSeleccionado = null;
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un error al eliminar el grado."));
            }
        }
    }
}