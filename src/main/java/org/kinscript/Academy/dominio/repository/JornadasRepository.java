package org.kinscript.Academy.dominio.repository;

import org.kinscript.Academy.dominio.dto.JornadasDto;
import org.kinscript.Academy.dominio.dto.ModJornadasDto;

import java.util.List;

public interface JornadasRepository {
    List<JornadasDto> obtenerJornadas();
    public JornadasDto buscarJornadas(Long codigo);
    JornadasDto guardarJornadas(JornadasDto jornadasDto);
    JornadasDto modificarJornadas(Long codigo, ModJornadasDto modJornadasDto);
    void eliminarJornadas(Long codigo);
}
