package org.kinscript.Academy.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "Tutores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tutores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTutor")
    private Integer idTutor;

    @Column(name = "nombreCompleto", nullable = false)
    private String nombreCompleto;

    @Column(name = "apellidoCompleto", nullable = false)
    private String apellidoCompleto;

    @Column(name = "numeroTelefono", nullable = false)
    private String numeroTelefono;

    @Column(name = "direccion", nullable = false)
    private String direccion;
}