package org.kinscript.Academy.config;

import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.kinscript.Academy.web.controller.views.UsuarioSesion;

import java.io.IOException;

@WebFilter("/*") // intercepta todo
public class AuthenticationFilter implements Filter {

    @Inject
    private UsuarioSesion usuarioSesion;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String requestURI = req.getRequestURI();

        boolean isLoggedIn = (usuarioSesion != null && usuarioSesion.isLoggedIn());
        boolean isLoginPage = requestURI.contains("/inicioDeSesion.xhtml");
        boolean isResource = requestURI.startsWith(req.getContextPath() + "/jakarta.faces.resource/");

        if (isLoggedIn) {
            if (isLoginPage) {
                res.sendRedirect(req.getContextPath() + "/menu.xhtml");
            } else {
                chain.doFilter(request, response);
            }
        } else {
            if (isLoginPage || isResource) {
                chain.doFilter(request, response);
            } else {
                res.sendRedirect(req.getContextPath() + "/inicioDeSesion.xhtml");
            }
        }
    }
}