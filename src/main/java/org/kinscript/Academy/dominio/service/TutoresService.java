package org.kinscript.Academy.dominio.service;


import org.kinscript.Academy.dominio.repository.TutoresRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutoresService {

    private final TutoresRepository TutoresRepository;

    public TutoresService(TutoresRepository tutoresRepository){
        this.TutoresRepository = tutoresRepository;
    }

    public List<TutoresDto> obtenerTodo(){
        return this.TutoresRepository.obtenerTutor();
    }

    public TutoresDto buscarPorCodigo(Long codigo){
        return this.TutoresRepository.buscarTutor(codigo);
    }

    public TutoresDto guardarPelicula(TutoresDto tutoresDto){
        return this.TutoresRepository.guardarTutor(tutoresDto);
    }

    public TutoresDto modificarPelicula(Long codigo, ModTutoresDto modTutoresDto){
        return this.TutoresRepository.modificarTutor(codigo, modTutoresDto);
    }

    public void eliminarPelicula (Long codigo) {
        this.TutoresRepository.eliminarTutor(codigo);
    }

}