package org.kinscript.Academy.dominio.repository;

import org.kinscript.Academy.dominio.dto.CoordinadoresDto;
import org.kinscript.Academy.dominio.dto.ModCoordinadoresDto;

import java.util.List;
import java.util.Optional;

public interface CoordinadoresRepository {
    List<CoordinadoresDto> obtenerTodos();
    Optional<CoordinadoresDto> buscarPorId(Integer idCoordinador);
    CoordinadoresDto guardar(CoordinadoresDto coordinadoresDto);
    Optional<CoordinadoresDto> modificar(Integer idCoordinador, ModCoordinadoresDto modCoordinadoresDto);
    void eliminar(Integer idCoordinador);
}