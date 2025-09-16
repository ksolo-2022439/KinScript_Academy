package org.kinscript.Academy.dominio.repository;

public class GradosRepository {
    List<GradosDto> obtenerGrados();
    public GradosDto buscarGrados(Long codigo);
    GradosDto guardarGrados(GradosDto gradosDto);
    GradosDto modificarGrados(Long codigo, ModGradosDto  modGradosDto);
    void eliminarGrados(Long codigo);
}