package org.kinscript.Academy.dominio.repository;

import org.kinscript.Academy.dominio.dto.NotasDto;
import org.kinscript.Academy.dominio.dto.ModNotasDto;

import java.util.List;

public interface NotasRepository {
    List<NotasDto> obtenerTodas();

    NotasDto buscarPorId(Long idNota);

    List<NotasDto> buscarPorAlumno(Long idAlumno);

    NotasDto guardar(NotasDto notasDto);

    NotasDto modificar(Long idNota, ModNotasDto modNotasDto);

    void eliminar(Long idNota);

    List<NotasDto> buscarPorFiltros(Long idAlumno, Long idCurso);

    long contarTotal();
}