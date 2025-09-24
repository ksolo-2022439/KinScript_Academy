package org.kinscript.Academy.dominio.repository;

import org.kinscript.Academy.dominio.dto.CoordinadoresDto;
import org.kinscript.Academy.dominio.dto.ModCoordinadoresDto;

import java.util.List;
import java.util.Optional;

public interface CoordinadoresRepository {
    List<CoordinadoresDto> obtenerTodos();
    Optional<CoordinadoresDto> buscarPorId(Long idCoordinador);
    CoordinadoresDto guardar(CoordinadoresDto coordinadoresDto);
    Optional<CoordinadoresDto> modificar(Long idCoordinador, ModCoordinadoresDto modCoordinadoresDto);
    void eliminar(Long idCoordinador);
    Optional<CoordinadoresDto> findByEmail(String email);
}