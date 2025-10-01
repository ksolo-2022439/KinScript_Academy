package org.kinscript.Academy.dominio.repository;

import org.kinscript.Academy.dominio.dto.GradoCursoDto;
import java.util.List;

public interface GradoCursoRepository {
    List<GradoCursoDto> obtenerTodos();

    List<GradoCursoDto> obtenerPorGrado(Long idGrado);

    GradoCursoDto guardar(GradoCursoDto gradoCursoDto);

    void eliminar(Long idGrado, Long idCurso);

    List<GradoCursoDto> buscarPorFiltro(Long idGrado);

    long contarTotal();
}