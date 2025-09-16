package org.kinscript.Academy.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
@Table(name = "Jornadas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jornadas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idJornada")
    private Integer idJornada;

    @Column(name = "nombreJornada", nullable = false, unique = true)
    private String nombreJornada;
}

