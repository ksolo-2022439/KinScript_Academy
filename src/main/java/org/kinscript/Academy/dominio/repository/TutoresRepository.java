package org.kinscript.Academy.dominio.repository;

public class TutoresRepository {
    List<TutoresDto> obtenerTutor();
    public TutoresDto buscarTutor(Long codigo);
    TutoresDto guardarTutor(TutoresDto tutoresDto);
    TutoresDto modificarTutor(Long codigo, ModTutoresDto  modTutoresDto);
    void eliminarTutor(Long codigo);
}