package org.kinscript.Academy.dominio.service;

import org.kinscript.Academy.dominio.dto.AlumnosDto;
import org.kinscript.Academy.dominio.dto.ModAlumnosDto;
import org.kinscript.Academy.dominio.repository.AlumnosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnosService {
    private final AlumnosRepository alumnosRepository;

    public AlumnosService(AlumnosRepository alumnosRepository) {
        this.alumnosRepository = alumnosRepository;
    }

    public List<AlumnosDto> obtenerTodo() {
        return this.alumnosRepository.obtenerTodos();
    }

    public AlumnosDto buscarPorCodigo(Long idAlumno) {
        return this.alumnosRepository.buscarPorId(idAlumno);
    }

    public AlumnosDto guardarAlumno(AlumnosDto alumnosDto) {
        return this.alumnosRepository.guardar(alumnosDto);
    }

    public AlumnosDto modificarAlumno(Long idAlumno, ModAlumnosDto modAlumnosDto) {
        return this.alumnosRepository.modificar(idAlumno, modAlumnosDto);
    }

    public void eliminarAlumno(Long idAlumno) {
        this.alumnosRepository.eliminar(idAlumno);
    }
}