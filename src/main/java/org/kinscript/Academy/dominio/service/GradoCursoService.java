package org.kinscript.Academy.dominio.service;

import org.kinscript.Academy.dominio.dto.GradoCursoDto;
import org.kinscript.Academy.dominio.repository.GradoCursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradoCursoService {
    private final GradoCursoRepository gradoCursoRepository;

    public GradoCursoService(GradoCursoRepository gradoCursoRepository) {
        this.gradoCursoRepository = gradoCursoRepository;
    }

    public List<GradoCursoDto> obtenerTodo() {
        return gradoCursoRepository.obtenerTodos();
    }

    public List<GradoCursoDto> obtenerCursosPorGrado(Integer idGrado) {
        return gradoCursoRepository.obtenerPorGrado(idGrado);
    }

    public GradoCursoDto guardarAsociacion(GradoCursoDto gradoCursoDto) {
        return gradoCursoRepository.guardar(gradoCursoDto);
    }

    public void eliminarAsociacion(Integer idGrado, Integer idCurso) {
        gradoCursoRepository.eliminar(idGrado, idCurso);
    }
}