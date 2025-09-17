package org.kinscript.Academy.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Alumnos")
@Data
public class Alumnos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAlumno")
    private Integer idAlumno;

    @Column(name = "carnetAlumno", nullable = false, unique = true, length = 20)
    private String carnetAlumno;

    @Column(name = "nombreCompleto", nullable = false, length = 100)
    private String nombreCompleto;

    @Column(name = "apellidoCompleto", nullable = false, length = 100)
    private String apellidoCompleto;

    @Column(name = "emailAcademico", nullable = false)
    private String emailAcademico;

    @Column(nullable = false)
    private String contrasena;

    @Column(nullable = false)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "idGrado", insertable = false, updatable = false)
    private Grados grado;

    @ManyToOne
    @JoinColumn(name = "idSeccion", insertable = false, updatable = false)
    private Secciones seccion;

    @ManyToOne
    @JoinColumn(name = "idJornada", insertable = false, updatable = false)
    private Jornadas jornada;

    @ManyToOne
    @JoinColumn(name = "idCarrera", insertable = false, updatable = false)
    private Carreras carrera;

    @ManyToOne
    @JoinColumn(name = "idTutor", insertable = false, updatable = false)
    private Tutores tutor;

    // llaves foraneas
    @Column(name = "idGrado", nullable = false)
    private Integer idGrado;

    @Column(name = "idSeccion", nullable = false)
    private Integer idSeccion;

    @Column(name = "idJornada")
    private Integer idJornada;

    @Column(name = "idCarrera")
    private Integer idCarrera;

    @Column(name = "idTutor", nullable = false)
    private Integer idTutor;
}