package org.kinscript.Academy.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "Carreras")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carreras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCarrera")
    private Long idCarrera;

    @Column(name = "nombreCarrera", nullable = false, unique = true, length = 100)
    private String nombreCarrera;
}