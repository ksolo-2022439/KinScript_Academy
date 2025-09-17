package org.kinscript.Academy.dominio.service;

import org.kinscript.Academy.dominio.dto.CursosDto;
import org.kinscript.Academy.dominio.dto.ModCursosDto;
import org.kinscript.Academy.dominio.repository.CursosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursosService {
    private final CursosRepository cursosRepository;

    public CursosService(CursosRepository cursosRepository) {
        this.cursosRepository = cursosRepository;
    }

    public List<CursosDto> obtenerTodo(){
        return this.cursosRepository.obtenerCursos();
    }
    public CursosDto buscarPorCodigo(Long codigo){
        return this.cursosRepository.buscarCursos(codigo);
    }
    public CursosDto guardarCursos(CursosDto cursosDto){

        return this.cursosRepository.guardarCursos(cursosDto);
    }

    public CursosDto modificarCursos(Long codigo, ModCursosDto modCursosDto){
        return this.cursosRepository.modificarCursos(codigo, modCursosDto);
    }

    public void eliminarCursos(Long codigo) {
        this.cursosRepository.eliminarCursos(codigo);
    }
}
