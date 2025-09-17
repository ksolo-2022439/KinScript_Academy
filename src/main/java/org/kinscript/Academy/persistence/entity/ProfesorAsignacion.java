package org.kinscript.Academy.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ProfesorAsignacion")
@Data
@IdClass(ProfesorAsignacionId.class) // se necesita la clase de clave compuesta
public class ProfesorAsignacion {

    @Id
    @Column(name = "idProfesor")
    private Long idProfesor;

    @Id
    @Column(name = "idCurso")
    private Long idCurso;

    @Id
    @Column(name = "idGrado")
    private Long idGrado;

    @Id
    @Column(name = "idSeccion")
    private Long idSeccion;

    @Column(name = "idJornada")
    private Long idJornada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProfesor", insertable = false, updatable = false)
    private Profesores profesor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCurso", insertable = false, updatable = false)
    private Cursos curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idGrado", insertable = false, updatable = false)
    private Grados grado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSeccion", insertable = false, updatable = false)
    private Secciones seccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idJornada", insertable = false, updatable = false)
    private Jornadas jornada;
}