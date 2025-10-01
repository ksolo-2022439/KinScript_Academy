package org.kinscript.Academy.web.controller.views;

import org.kinscript.Academy.dominio.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired private AlumnosService alumnosService;
    @Autowired private ProfesoresService profesoresService;
    @Autowired private CursosService cursosService;
    @Autowired private NotasService notasService;
    @Autowired private GradoCursoService gradoCursoService;
    @Autowired private GradosService gradosService;
    @Autowired private ProfesorAsignacionService profesorAsignacionService;

    @GetMapping
    public String showDashboard(Model model) {
        model.addAttribute("totalAlumnos", alumnosService.contarTotal());
        model.addAttribute("totalProfesores", profesoresService.contarTotal());
        model.addAttribute("totalNotas", notasService.contarTotal());
        model.addAttribute("totalAsignaciones", gradoCursoService.contarTotal());
        model.addAttribute("totalProfAsignaciones", profesorAsignacionService.contarTotal());

        model.addAttribute("listaCursos", cursosService.obtenerTodo());
        model.addAttribute("listaGrados", gradosService.obtenerTodo());

        model.addAttribute("paginaActiva", "dashboard");

        return "dashboard";
    }
}