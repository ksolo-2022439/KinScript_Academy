package org.kinscript.Academy.dominio.service;


import org.kinscript.Academy.dominio.repository.SeccionesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeccionesService {

    private final SeccionesRepository SeccionesRepository;

    public SeccionesService(SeccionesRepository seccionesRepository){
        this.SeccionesRepository = seccionesRepository;
    }

    public List<SeccionesDto> obtenerTodo(){
        return this.SeccionesRepository.obtenerSeccion();
    }

    public SeccionesDto buscarPorCodigo(Long codigo){
        return this.SeccionesRepository.buscarSeccion(codigo);
    }

    public SeccionesDto guardarPelicula(SeccionesDto SeccionesDto){
        return this.SeccionesRepository.guardarSeccion(SeccionesDto);
    }

    public SeccionesDto modificarPelicula(Long codigo, ModSeccionesDto modSeccionesDto){
        return this.SeccionesRepository.modificarSeccion(codigo, modSeccionesDto);
    }

    public void eliminarPelicula (Long codigo) {
        this.SeccionesRepository.eliminarSeccion(codigo);
    }

}