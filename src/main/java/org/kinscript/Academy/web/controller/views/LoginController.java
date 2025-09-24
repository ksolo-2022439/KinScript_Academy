package org.kinscript.Academy.web.controller.views;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.kinscript.Academy.dominio.dto.CoordinadoresDto;
import org.kinscript.Academy.dominio.dto.ProfesoresDto;
import org.kinscript.Academy.dominio.service.CoordinadoresService;
import org.kinscript.Academy.dominio.service.ProfesoresService;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
import java.util.Optional;

@Named("loginController")
@ViewScoped
@Getter
@Setter
public class LoginController implements Serializable {

    private String email;
    private String password;

    @Autowired
    private ProfesoresService profesoresService;
    @Autowired
    private CoordinadoresService coordinadoresService;

    @Inject
    private UsuarioSesion usuarioSesion;

    public String login() {
        Optional<ProfesoresDto> profesorOpt = profesoresService.findByEmail(email.trim());
        if (profesorOpt.isPresent()) {
            ProfesoresDto profesor = profesorOpt.get();
            if (profesor.contrasena().trim().equals(password.trim())) {
                iniciarSesionUsuario(profesor.nombreCompleto(), profesor.apellidoCompleto(), profesor.email(), "Profesor");
                return "/menu.xhtml?faces-redirect=true";
            }
        }

        Optional<CoordinadoresDto> coordinadorOpt = coordinadoresService.findByEmail(email.trim());
        if (coordinadorOpt.isPresent()) {
            CoordinadoresDto coordinador = coordinadorOpt.get();
            if (coordinador.contrasena().trim().equals(password.trim())) {
                iniciarSesionUsuario(coordinador.nombreCompleto(), coordinador.apellidoCompleto(), coordinador.email(), "Coordinador");
                return "/menu.xhtml?faces-redirect=true";
            }
        }

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de Acceso", "Email o contraseña incorrectos."));
        return null;
    }

    private void iniciarSesionUsuario(String nombre, String apellido, String userEmail, String rol) {
        usuarioSesion.setLoggedIn(true);
        usuarioSesion.setNombreCompleto(nombre + " " + apellido);
        usuarioSesion.setEmail(userEmail);
        usuarioSesion.setRol(rol);
    }
}