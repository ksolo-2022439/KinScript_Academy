package org.kinscript.Academy.dominio.repository;

import org.kinscript.Academy.dominio.dto.ProfesorAsignacionDto;
import java.util.List;

public interface ProfesorAsignacionRepository {
    List<ProfesorAsignacionDto> obtenerTodas();

    List<ProfesorAsignacionDto> obtenerPorProfesor(Long idProfesor);

    ProfesorAsignacionDto guardar(ProfesorAsignacionDto asignacionDto);

    void eliminar(ProfesorAsignacionDto asignacionDto);

    List<ProfesorAsignacionDto> buscarPorFiltros(Long idProfesor, Long idCurso, Long idGrado, Long idSeccion, Long idJornada);

    long contarTotal();
}