package org.kinscript.Academy.dominio.repository;
import org.kinscript.Academy.dominio.dto.ModProfesoresDto;
import org.kinscript.Academy.dominio.dto.ProfesoresDto;
import java.util.List;
import java.util.Optional;

public interface ProfesoresRepository {
    List<ProfesoresDto> obtenerProfesores();
    ProfesoresDto buscarProfesorPorId(Long idProfesor);
    ProfesoresDto guardarProfesor(ProfesoresDto profesoresDto);
    ProfesoresDto modificarProfesor(Long idProfesor, ModProfesoresDto  modProfesoresDto);
    void eliminarProfesor(Long idProfesor);
    Optional<ProfesoresDto> findByEmail(String email);
}