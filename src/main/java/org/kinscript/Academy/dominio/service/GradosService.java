package org.kinscript.Academy.dominio.service;


import org.kinscript.Academy.dominio.repository.GradosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradosService {

    private final GradosRepository GradosRepository;

    public GradosService(GradosRepository gradosRepository){
        this.GradosRepository = gradosRepository;
    }

    public List<GradosDto> obtenerTodo(){
        return this.GradosRepository.obtenerGrados();
    }

    public GradosDto buscarPorCodigo(Long codigo){
        return this.GradosRepository.buscarGrados(codigo);
    }

    public GradosDto guardarPelicula(GradosesDto GradosesDto){
        return this.GradosRepository.guardarGrados(GradosesDto);
    }

    public GradosDto modificarPelicula(Long codigo, ModGradosesDto modGradosesDto){
        return this.GradosRepository.modificarGrados(codigo, modGradosesDto);
    }

    public void eliminarPelicula (Long codigo) {
        this.GradosRepository.eliminarGrados(codigo);
    }

}