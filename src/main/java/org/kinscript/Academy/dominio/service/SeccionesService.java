package org.kinscript.Academy.dominio.service;

import org.kinscript.Academy.dominio.dto.SeccionesDto;
import org.kinscript.Academy.dominio.dto.ModSeccionesDto;
import org.kinscript.Academy.dominio.repository.SeccionesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeccionesService {

    private final SeccionesRepository SeccionesRepository;

    public SeccionesService(SeccionesRepository seccionesRepository){
        this.SeccionesRepository = seccionesRepository;
    }

    public List<SeccionesDto> obtenerSeccion(){
        return this.SeccionesRepository.obtenerSeccion();
    }

    public SeccionesDto buscarSeccion(Long codigo){
        return this.SeccionesRepository.buscarSeccion(codigo);
    }

    public SeccionesDto guardarSeccion(SeccionesDto SeccionesDto){
        return this.SeccionesRepository.guardarSeccion(SeccionesDto);
    }

    public SeccionesDto modificarSeccion(Long codigo, ModSeccionesDto modSeccionesDto){
        return this.SeccionesRepository.modificarSeccion(codigo, modSeccionesDto);
    }

    public void eliminarSeccion (Long codigo) {
        this.SeccionesRepository.eliminarSeccion(codigo);
    }

}