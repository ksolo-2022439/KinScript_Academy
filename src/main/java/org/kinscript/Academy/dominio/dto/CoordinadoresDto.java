package org.kinscript.Academy.dominio.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CoordinadoresDto {
    private Long id;
    @NotBlank(message = "El nombre es obligatorio")
    private String nombreCompleto;
    @NotBlank(message = "El apellido es obligatorio")
    private String apellidoCompleto;
    @NotBlank(message = "El email es obligatorio")
    private String email;
    @NotBlank(message = "La contrasena es obligatoria")
    private String contrasena;

}