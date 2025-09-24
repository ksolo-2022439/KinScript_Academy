package org.kinscript.Academy.web.controller.views;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Named("usuarioSesion")
@SessionScoped
@Getter
@Setter
public class UsuarioSesion implements Serializable {

    private boolean loggedIn = false;
    private String nombreCompleto;
    private String email;
    private String rol;

    public void logout() {
        this.loggedIn = false;
        this.nombreCompleto = null;
        this.email = null;
        this.rol = null;
    }
}