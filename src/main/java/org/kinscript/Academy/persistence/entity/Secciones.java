package org.kinscript.Academy.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "Secciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Secciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSeccion")
    private Integer idSeccion;

    @Column(name = "nombreSeccion", nullable = false, unique = true)
    private String nombreSeccion;
}