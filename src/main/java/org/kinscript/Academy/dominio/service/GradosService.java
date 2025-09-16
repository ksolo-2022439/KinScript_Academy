package org.kinscript.Academy.dominio.service;

import org.kinscript.Academy.dominio.dto.GradosDto;
import org.kinscript.Academy.dominio.dto.ModGradosDto;
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

    public GradosDto guardarGrados(GradosDto GradosesDto){
        return this.GradosRepository.guardarGrados(GradosesDto);
    }

    public GradosDto modificarGrados(Long codigo, ModGradosDto modGradosesDto){
        return this.GradosRepository.modificarGrados(codigo, modGradosesDto);
    }

    public void eliminarGrados(Long codigo) {
        this.GradosRepository.eliminarGrados(codigo);
    }

}