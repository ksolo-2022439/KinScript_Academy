package org.kinscript.Academy.dominio.repository;

import org.kinscript.Academy.dominio.dto.CursosDto;
import org.kinscript.Academy.dominio.dto.ModCursosDto;


import java.util.List;

public interface CursosRepository {
    List<CursosDto> obtenerCursos();
    public CursosDto buscarCursos(Long codigo);
    CursosDto guardarCursos(CursosDto cursosDto);
    CursosDto modificarCursos(Long codigo, ModCursosDto modCursosDto);
    void eliminarCursos(Long codigo);
}
