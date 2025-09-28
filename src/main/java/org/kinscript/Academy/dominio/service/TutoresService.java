package org.kinscript.Academy.dominio.service;

import org.kinscript.Academy.dominio.dto.ModTutoresDto;
import org.kinscript.Academy.dominio.dto.TutoresDto;
import org.kinscript.Academy.dominio.repository.TutoresRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutoresService {
    private final TutoresRepository tutoresRepository;

    public TutoresService(TutoresRepository tutoresRepository) {
        this.tutoresRepository = tutoresRepository;
    }

    public List<TutoresDto> obtenerTodo() {
        return tutoresRepository.obtenerTodo();
    }

    public Optional<TutoresDto> buscarPorCodigo(Integer idTutor) {
        return tutoresRepository.buscarPorCodigo(idTutor);
    }

    public TutoresDto guardarTutor(TutoresDto tutorDto) {
        return tutoresRepository.guardarTutor(tutorDto);
    }

    public TutoresDto modificarTutor(Integer idTutor, ModTutoresDto modTutoresDto) {
        return tutoresRepository.modificarTutor(idTutor, modTutoresDto);
    }

    public boolean eliminarTutor(Integer idTutor) {
        if (tutoresRepository.buscarPorCodigo(idTutor).isPresent()) {
            tutoresRepository.eliminarTutor(idTutor);
            return true;
        }
        return false;
    }

    public List<TutoresDto> buscarPorFiltros(String nombre, String telefono) {
        return tutoresRepository.buscarPorFiltros(nombre, telefono);
    }

    public long contarTotal() {
        return tutoresRepository.contarTotal();
    }
}