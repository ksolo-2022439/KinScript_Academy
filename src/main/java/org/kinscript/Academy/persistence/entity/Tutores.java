package org.kinscript.Academy.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name = "id_tutor")
    private Integer idTutor;

    @Column(name = "nombreCompleto")
    private String nombreCompleto;

    @Column(name = "apellidoCompleto")
    private String apellidoCompleto;

    @Column(name = "numeroTelefono")
    private String numeroTelefono;

    @Column(name = "direccion")
    private String direccion;
}