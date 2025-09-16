package org.kinscript.Academy.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "Notas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNota")
    private Integer idNota;

    @ManyToOne
    @JoinColumn(name = "idAlumno", nullable = false)
    private Alumnos alumno;

    @ManyToOne
    @JoinColumn(name = "idCurso", nullable = false)
    private Cursos curso;

    @Column(name = "bimestre1", precision = 5, scale = 2)
    private BigDecimal bimestre1;

    @Column(name = "bimestre2", precision = 5, scale = 2)
    private BigDecimal bimestre2;

    @Column(name = "bimestre3", precision = 5, scale = 2)
    private BigDecimal bimestre3;

    @Column(name = "bimestre4", precision = 5, scale = 2)
    private BigDecimal bimestre4;
}