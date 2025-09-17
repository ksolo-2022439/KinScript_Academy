package org.kinscript.Academy.dominio.service;

import org.kinscript.Academy.dominio.dto.ModProfesoresDto;
import org.kinscript.Academy.dominio.dto.ProfesoresDto;
import org.kinscript.Academy.dominio.repository.ProfesoresRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesoresService {

    private final ProfesoresRepository profesoresRepository;

    public ProfesoresService(ProfesoresRepository profesoresRepository){
        this.profesoresRepository = profesoresRepository;
    }

    public List<ProfesoresDto> obtenerTodo(){
        return this.profesoresRepository.obtenerProfesores();
    }

    public ProfesoresDto buscarPorId(Long idProfesor){
        return this.profesoresRepository.buscarProfesorPorId(idProfesor);
    }

    public ProfesoresDto guardarProfesor(ProfesoresDto profesoresDto){
        return this.profesoresRepository.guardarProfesor(profesoresDto);
    }

    public ProfesoresDto modificarProfesor(Long idProfesor, ModProfesoresDto modProfesoresDto){
        return this.profesoresRepository.modificarProfesor(idProfesor, modProfesoresDto);
    }

    public void eliminarProfesor(Long idProfesor) {
        this.profesoresRepository.eliminarProfesor(idProfesor);
    }
}