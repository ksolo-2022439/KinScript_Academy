package org.kinscript.Academy.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "Coordinadores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coordinadores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCoordinador")
    private Integer idCoordinador;

    @Column(name = "nombreCompleto", nullable = false)
    private String nombreCompleto;

    @Column(name = "apellidoCompleto", nullable = false)
    private String apellidoCompleto;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "idGrado", nullable = false)
    private Grados grado;
}
