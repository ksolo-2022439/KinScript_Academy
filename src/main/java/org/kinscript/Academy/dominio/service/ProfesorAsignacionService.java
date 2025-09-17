package org.kinscript.Academy.dominio.service;

import org.kinscript.Academy.dominio.dto.ProfesorAsignacionDto;
import org.kinscript.Academy.dominio.repository.ProfesorAsignacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorAsignacionService {

    private final ProfesorAsignacionRepository profesorAsignacionRepository;

    public ProfesorAsignacionService(ProfesorAsignacionRepository profesorAsignacionRepository) {
        this.profesorAsignacionRepository = profesorAsignacionRepository;
    }

    public List<ProfesorAsignacionDto> obtenerTodo() {
        return profesorAsignacionRepository.obtenerTodas();
    }

    public List<ProfesorAsignacionDto> obtenerAsignacionesPorProfesor(Long idProfesor) {
        return profesorAsignacionRepository.obtenerPorProfesor(idProfesor);
    }

    public ProfesorAsignacionDto guardarAsignacion(ProfesorAsignacionDto asignacionDto) {
        return profesorAsignacionRepository.guardar(asignacionDto);
    }

    public void eliminarAsignacion(ProfesorAsignacionDto asignacionDto) {
        profesorAsignacionRepository.eliminar(asignacionDto);
    }
}