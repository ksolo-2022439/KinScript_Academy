package org.kinscript.Academy.persistence.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Coordinadores")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Coordinadores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCoordinador;
    @Column(name = "Nombre", length = 150, unique = true, nullable = false)
    private String nombreCompleto;
    @Column(name = "Apellido", length = 150, unique = true, nullable = false)
    private String apellidoCompleto;
    @Column(name = "Email", length = 150, unique = true, nullable = false)
    private String email;
    @Column(name = "Contrasena", length = 150, unique = true, nullable = false)
    private String contrasena;

}
