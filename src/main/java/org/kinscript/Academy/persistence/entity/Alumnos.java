package org.kinscript.Academy.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
@Table(name = "Alumnos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alumnos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAlumno")
    private Integer idAlumno;

    @Column(name = "carnetAlumno", nullable = false, unique = true)
    private String carnetAlumno;

    @Column(name = "nombreCompleto", nullable = false)
    private String nombreCompleto;

    @Column(name = "apellidoCompleto", nullable = false)
    private String apellidoCompleto;

    @Column(name = "emailAcademico", nullable = false)
    private String emailAcademico;

    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "idGrado", nullable = false)
    private Grados grado;

    @ManyToOne
    @JoinColumn(name = "idSeccion", nullable = false)
    private Secciones secciones;

    @ManyToOne
    @JoinColumn(name = "idJornada")
    private Jornadas jornadas;

    @ManyToOne
    @JoinColumn(name = "idCarrera")
    private Carreras carreras;

    @ManyToOne
    @JoinColumn(name = "idTutor", nullable = false)
    private Tutores tutores;
}
