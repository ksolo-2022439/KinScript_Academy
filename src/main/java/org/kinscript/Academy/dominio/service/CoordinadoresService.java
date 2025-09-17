package org.kinscript.Academy.dominio.service;

import org.kinscript.Academy.repository.CoordinadoresRepository;
import org.kinscript.Academy.dominio.dto.ModCoordinadoresDto;
import org.kinscript.Academy.dominio.dto.CoordinadoresDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CoordinadoresService {

    private final CoordinadoresRepository CoordinadoresRepository;

    public CoordinadoresService (CoordinadoresRepository coordinadoresRepository){
        this.CoordinadoresRepository = coordinadoresRepository;
    }

    public List<CoordinadoresDto> obtenerCoordinador(){
        return this.CoordinadoresRepository.obtenerCoordinador();
    }

    public CoordinadoresDto buscarCoordinador (Long codigo) {
        return this.CoordinadoresRepository.buscarCoordinador(codigo);
    }

    public CoordinadoresDto guardarCoordinador (CoordinadoresDto coordinadoresDto) {
        return this.CoordinadoresRepository.guardarCoordinador(coordinadoresDto);
    }

    public CoordinadoresDto modificarCoordinador(Long codigo, ModCoordinadoresDto modCoordinador) {
        return this.CoordinadoresRepository.modificarCoordinador(codigo, modCoordinador);
    }

    public void eliminarCoordinador (Long codigo) {
        this.CoordinadoresRepository.eliminarCoordinador(codigo);
    }

}
