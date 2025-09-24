package org.kinscript.Academy.web.controller.views;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.kinscript.Academy.dominio.dto.AlumnosDto;
import org.kinscript.Academy.dominio.dto.ModAlumnosDto;
import org.kinscript.Academy.dominio.service.*;
import org.kinscript.Academy.persistence.entity.*;
import org.kinscript.Academy.persistence.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Named("alumnosVistaController")
@ViewScoped
@Getter
@Setter
public class AlumnosVistaController implements Serializable {

    @Autowired private AlumnosService alumnosService;
    @Autowired private GradosService gradosService;
    @Autowired private SeccionesService seccionesService;
    @Autowired private JornadasService jornadasService;
    @Autowired private CarrerasService carrerasService;
    @Autowired private TutoresService tutoresService;
    @Autowired private AlumnosMapper alumnosMapper;
    @Autowired private GradosMapper gradosMapper;
    @Autowired private SeccionesMapper seccionesMapper;
    @Autowired private JornadasMapper jornadasMapper;
    @Autowired private CarrerasMapper carrerasMapper;
    @Autowired private TutoresMapper tutoresMapper;

    private List<Alumnos> alumnos;
    private Alumnos alumnoSeleccionado;
    private List<Grados> listaGrados;
    private List<Secciones> listaSecciones;
    private List<Jornadas> listaJornadas;
    private List<Carreras> listaCarreras;
    private List<Tutores> listaTutores;

    @PostConstruct
    public void init() {
        cargarListasDesplegables();
        cargarAlumnos();
    }

    private void cargarListasDesplegables() {
        listaGrados = gradosService.obtenerTodo().stream().map(gradosMapper::toEntity).collect(Collectors.toList());
        listaSecciones = seccionesService.obtenerSeccion().stream().map(seccionesMapper::toEntity).collect(Collectors.toList());
        listaJornadas = jornadasService.obtenerTodo().stream().map(jornadasMapper::toEntity).collect(Collectors.toList());
        listaCarreras = carrerasService.obtenerTodo().stream().map(carrerasMapper::toEntity).collect(Collectors.toList());
        listaTutores = tutoresService.obtenerTodo().stream().map(tutoresMapper::toEntity).collect(Collectors.toList());
    }

    private void cargarAlumnos() {
        List<Alumnos> alumnosNoOptimizado = alumnosService.obtenerTodo().stream()
                .map(alumnosMapper::toEntity)
                .collect(Collectors.toList());

        Map<Long, Grados> gradosMap = listaGrados.stream().collect(Collectors.toMap(Grados::getIdGrado, Function.identity()));
        Map<Long, Secciones> seccionesMap = listaSecciones.stream().collect(Collectors.toMap(Secciones::getIdSeccion, Function.identity()));
        Map<Long, Jornadas> jornadasMap = listaJornadas.stream().collect(Collectors.toMap(Jornadas::getIdJornada, Function.identity()));
        Map<Long, Carreras> carrerasMap = listaCarreras.stream().collect(Collectors.toMap(Carreras::getIdCarrera, Function.identity()));
        Map<Long, Tutores> tutoresMap = listaTutores.stream().collect(Collectors.toMap(Tutores::getIdTutor, Function.identity()));

        alumnosNoOptimizado.forEach(alumno -> {
            if (alumno.getIdGrado() != null) {
                alumno.setGrado(gradosMap.get(alumno.getIdGrado()));
            }
            if (alumno.getIdSeccion() != null) {
                alumno.setSeccion(seccionesMap.get(alumno.getIdSeccion()));
            }
            if (alumno.getIdJornada() != null) {
                alumno.setJornada(jornadasMap.get(alumno.getIdJornada()));
            }
            if (alumno.getIdCarrera() != null) {
                alumno.setCarrera(carrerasMap.get(alumno.getIdCarrera()));
            }
            if (alumno.getIdTutor() != null) {
                alumno.setTutor(tutoresMap.get(alumno.getIdTutor()));
            }
        });

        this.alumnos = alumnosNoOptimizado;
    }

    public void prepararNuevoAlumno() {
        this.alumnoSeleccionado = new Alumnos();
    }

    public void guardarAlumno() {
        try {
            if (alumnoSeleccionado.getGrado() != null) alumnoSeleccionado.setIdGrado(alumnoSeleccionado.getGrado().getIdGrado());
            if (alumnoSeleccionado.getSeccion() != null) alumnoSeleccionado.setIdSeccion(alumnoSeleccionado.getSeccion().getIdSeccion());
            if (alumnoSeleccionado.getJornada() != null) alumnoSeleccionado.setIdJornada(alumnoSeleccionado.getJornada().getIdJornada());
            if (alumnoSeleccionado.getCarrera() != null) alumnoSeleccionado.setIdCarrera(alumnoSeleccionado.getCarrera().getIdCarrera());
            if (alumnoSeleccionado.getTutor() != null) alumnoSeleccionado.setIdTutor(alumnoSeleccionado.getTutor().getIdTutor());

            AlumnosDto dto = alumnosMapper.toDto(this.alumnoSeleccionado);
            ModAlumnosDto modDto = new ModAlumnosDto(
                    dto.carnetAlumno(), dto.nombreCompleto(), dto.apellidoCompleto(), dto.emailAcademico(),
                    dto.contrasena(), dto.direccion(), dto.idGrado(), dto.idSeccion(), dto.idJornada(),
                    dto.idCarrera(), dto.idTutor()
            );

            if (this.alumnoSeleccionado.getIdAlumno() == null) {
                alumnosService.guardarAlumno(dto);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alumno Creado", "Se ha creado el alumno correctamente."));
            } else {
                alumnosService.modificarAlumno(alumnoSeleccionado.getIdAlumno(), modDto);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alumno Actualizado", "Se ha actualizado el alumno correctamente."));
            }
            cargarAlumnos();
            this.alumnoSeleccionado = null;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un error al guardar el alumno: " + e.getMessage()));
        }
    }

    public void eliminarAlumno() {
        if (this.alumnoSeleccionado != null && this.alumnoSeleccionado.getIdAlumno() != null) {
            try {
                alumnosService.eliminarAlumno(this.alumnoSeleccionado.getIdAlumno());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alumno Eliminado", "El alumno ha sido eliminado."));
                cargarAlumnos();
                this.alumnoSeleccionado = null;
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un error al eliminar el alumno."));
            }
        }
    }
}