package org.kinscript.Academy.dominio.service;

import org.kinscript.Academy.dominio.dto.ModProfesoresDto;
import org.kinscript.Academy.dominio.dto.ProfesoresDto;
import org.kinscript.Academy.dominio.repository.ProfesoresRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<ProfesoresDto> findByEmail(String email) {
        return this.profesoresRepository.findByEmail(email);
    }

    public List<ProfesoresDto> buscarPorFiltros(String nombre, String apellido, String telefono, String email) {
        return profesoresRepository.buscarPorFiltros(nombre, apellido, telefono, email);
    }

    public long contarTotal() {
        return profesoresRepository.contarTotal();
    }
}