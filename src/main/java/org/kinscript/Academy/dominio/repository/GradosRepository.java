package org.kinscript.Academy.dominio.repository;
import org.kinscript.Academy.dominio.dto.GradosDto;
import org.kinscript.Academy.dominio.dto.ModGradosDto;
import java.util.List;

public interface GradosRepository {
    List<GradosDto> obtenerGrados();
    public GradosDto buscarGrados(Long codigo);
    GradosDto guardarGrados(GradosDto gradosDto);
    GradosDto modificarGrados(Long codigo, ModGradosDto  modGradosDto);
    void eliminarGrados(Long codigo);
}