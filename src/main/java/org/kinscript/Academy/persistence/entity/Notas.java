package org.kinscript.Academy.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "Notas")
@Data
public class Notas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNota")
    private Integer idNota;

    @Column(name = "idAlumno", nullable = false)
    private Integer idAlumno;

    @Column(name = "idCurso", nullable = false)
    private Integer idCurso;

    @Column(precision = 5, scale = 2)
    private BigDecimal bimestre1;

    @Column(precision = 5, scale = 2)
    private BigDecimal bimestre2;

    @Column(precision = 5, scale = 2)
    private BigDecimal bimestre3;

    @Column(precision = 5, scale = 2)
    private BigDecimal bimestre4;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAlumno", insertable = false, updatable = false)
    private Alumnos alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCurso", insertable = false, updatable = false)
    private Cursos curso;
}