package org.kinscript.Academy.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

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
    private Double bimestre1;

    @Column(name = "bimestre2", precision = 5, scale = 2)
    private Double bimestre2;

    @Column(name = "bimestre3", precision = 5, scale = 2)
    private Double bimestre3;

    @Column(name = "bimestre4", precision = 5, scale = 2)
    private Double bimestre4;
}