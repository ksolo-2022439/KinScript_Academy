package org.kinscript.Academy.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "GradoCurso")
@Data
@IdClass(GradoCursoId.class) // se necesita esa clase de clave compuesta
public class GradoCurso {

    @Id
    @Column(name = "idGrado")
    private Long idGrado;

    @Id
    @Column(name = "idCurso")
    private Long idCurso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idGrado", insertable = false, updatable = false)
    private Grados grado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCurso", insertable = false, updatable = false)
    private Cursos curso;
}