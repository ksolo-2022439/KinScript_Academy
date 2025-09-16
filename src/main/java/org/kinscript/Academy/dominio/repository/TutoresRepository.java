package org.kinscript.Academy.dominio.repository;

import org.kinscript.Academy.dominio.dto.ModTutoresDto;
import org.kinscript.Academy.dominio.dto.TutoresDto;

import java.util.List;

public interface TutoresRepository {
    List<TutoresDto> obtenerTutor();
    public TutoresDto buscarTutor(Long codigo);
    TutoresDto guardarTutor(TutoresDto tutoresDto);
    TutoresDto modificarTutor(Long codigo, ModTutoresDto  modTutoresDto);
    void eliminarTutor(Long codigo);
}