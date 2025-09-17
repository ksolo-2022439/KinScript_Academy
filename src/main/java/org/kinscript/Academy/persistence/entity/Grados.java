package org.kinscript.Academy.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
@Table(name = "Grados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGrado")
    private Long idGrado;

    @Column(name = "nombreGrado", nullable = false, unique = true)
    private String nombreGrado;
}
