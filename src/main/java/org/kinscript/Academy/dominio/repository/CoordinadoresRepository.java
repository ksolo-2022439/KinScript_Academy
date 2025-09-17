package org.kinscript.Academy.repository;

import org.kinscript.Academy.dominio.dto.CoordinadoresDto;
import org.kinscript.Academy.dominio.dto.ModCoordinadoresDto;
import org.kinscript.Academy.web.controller.CoordinadoresController;

import java.util.List;

public interface CoordinadoresRepository {
    //firmas de nuestros metodos a trabajar
    List<CoordinadoresDto> obtenerCoordinador();
    public CoordinadoresDto buscarCoordinador(Long codigo);
    CoordinadoresDto guardarCoordinador(CoordinadoresDto coordinadoresDto);
    CoordinadoresDto modificarCoordinador(Long codigo, ModCoordinadoresDto coordinadoresDto);
    void eliminarCoordinador(Long codigo);
}