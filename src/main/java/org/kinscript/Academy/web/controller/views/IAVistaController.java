package org.kinscript.Academy.web.controller.views;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.kinscript.Academy.dominio.service.AIServiceColegio;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;

@Named("aIActividadVistaController")
@ViewScoped
public class IAVistaController implements Serializable {

    @Autowired
    private AIServiceColegio aiService;

    @Getter @Setter
    private String materia;

    @Getter @Setter
    private String nivelEducativo;

    @Getter @Setter
    private String temaEspecifico;

    @Getter @Setter
    private String resultadoActividad;

    @PostConstruct
    public void init() {
        // Inicialización del bean, si es necesaria.
    }

    public void generarActividad() {
        if (materia == null || nivelEducativo == null || temaEspecifico == null ||
                materia.isBlank() || nivelEducativo.isBlank() || temaEspecifico.isBlank()) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", "Por favor, complete todos los campos para generar la actividad."));
            return;
        }

        try {
            String preferencias = String.format(
                    "Materia/Tema: %s, Nivel educativo: %s, Tema específico: %s",
                    this.materia, this.nivelEducativo, this.temaEspecifico
            );
            this.resultadoActividad = this.aiService.generarActivadad(preferencias);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Actividad generada correctamente."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un error al generar la actividad: " + e.getMessage()));
            this.resultadoActividad = null;
        }
    }
}