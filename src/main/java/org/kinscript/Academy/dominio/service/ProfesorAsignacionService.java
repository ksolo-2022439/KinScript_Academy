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

    public List<ProfesorAsignacionDto> buscarPorFiltros(Long idProfesor, Long idCurso, Long idGrado, Long idSeccion, Long idJornada) {
        return profesorAsignacionRepository.buscarPorFiltros(idProfesor, idCurso, idGrado, idSeccion, idJornada);
    }

    public long contarTotal() {
        return profesorAsignacionRepository.contarTotal();
    }
}