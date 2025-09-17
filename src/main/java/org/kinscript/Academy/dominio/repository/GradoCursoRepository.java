package org.kinscript.Academy.dominio.repository;

import org.kinscript.Academy.dominio.dto.GradoCursoDto;
import java.util.List;

public interface GradoCursoRepository {
    List<GradoCursoDto> obtenerTodos();
    List<GradoCursoDto> obtenerPorGrado(Integer idGrado);
    GradoCursoDto guardar(GradoCursoDto gradoCursoDto);
    void eliminar(Integer idGrado, Integer idCurso);
}