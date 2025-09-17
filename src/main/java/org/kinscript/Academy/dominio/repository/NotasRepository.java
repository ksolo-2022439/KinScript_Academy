package org.kinscript.Academy.dominio.repository;

import org.kinscript.Academy.dominio.dto.NotasDto;
import org.kinscript.Academy.dominio.dto.ModNotasDto;

import java.util.List;

public interface NotasRepository {
    List<NotasDto> obtenerTodas();
    NotasDto buscarPorId(Integer idNota);
    List<NotasDto> buscarPorAlumno(Integer idAlumno);
    NotasDto guardar(NotasDto notasDto);
    NotasDto modificar(Integer idNota, ModNotasDto modNotasDto);
    void eliminar(Integer idNota);
}