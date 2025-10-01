package org.kinscript.Academy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/recovery")
    public String showForgotPasswordForm() {
        return "recuperar-contrasena";
    }
}