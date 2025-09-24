package org.kinscript.Academy.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Coordinadores")
@Data
public class Coordinadores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCoordinador")
    private Long idCoordinador;

    @Column(nullable = false, length = 100)
    private String nombreCompleto;

    @Column(nullable = false, length = 100)
    private String apellidoCompleto;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private String contrasena;

    @Column(name = "idGrado", nullable = false)
    private Long idGrado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idGrado", insertable = false, updatable = false)
    private Grados grado;
}