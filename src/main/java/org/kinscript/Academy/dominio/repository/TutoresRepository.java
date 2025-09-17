package org.kinscript.Academy.dominio.repository;

import org.kinscript.Academy.dominio.dto.ModTutoresDto;
import org.kinscript.Academy.dominio.dto.TutoresDto;

import java.util.List;
import java.util.Optional;

public interface TutoresRepository {
    List<TutoresDto> obtenerTodo();
    Optional<TutoresDto> buscarPorCodigo(Integer codigo);
    TutoresDto guardarTutor(TutoresDto tutorDto);
    TutoresDto modificarTutor(Integer codigo, ModTutoresDto modTutor);
    void eliminarTutor(Integer codigo);
}