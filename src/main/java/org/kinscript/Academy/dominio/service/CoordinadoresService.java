package org.kinscript.Academy.dominio.service;

import org.kinscript.Academy.dominio.dto.CoordinadoresDto;
import org.kinscript.Academy.dominio.dto.ModCoordinadoresDto;
import org.kinscript.Academy.dominio.exception.CoordinadorNotExistsException;
import org.kinscript.Academy.dominio.repository.CoordinadoresRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoordinadoresService {

    private final CoordinadoresRepository coordinadoresRepository;

    public CoordinadoresService(CoordinadoresRepository coordinadoresRepository) {
        this.coordinadoresRepository = coordinadoresRepository;
    }

    public List<CoordinadoresDto> obtenerTodo() {
        return coordinadoresRepository.obtenerTodos();
    }

    public CoordinadoresDto buscarPorCodigo(Long idCoordinador) {
        return coordinadoresRepository.buscarPorId(idCoordinador)
                .orElseThrow(() -> new CoordinadorNotExistsException(idCoordinador));
    }

    public CoordinadoresDto guardarCoordinador(CoordinadoresDto coordinadoresDto) {
        return coordinadoresRepository.guardar(coordinadoresDto);
    }

    public CoordinadoresDto modificarCoordinador(Long idCoordinador, ModCoordinadoresDto modCoordinadoresDto) {
        return coordinadoresRepository.modificar(idCoordinador, modCoordinadoresDto)
                .orElseThrow(() -> new CoordinadorNotExistsException(idCoordinador));
    }

    public void eliminarCoordinador(Long idCoordinador) {
        coordinadoresRepository.eliminar(idCoordinador);
    }

    public Optional<CoordinadoresDto> findByEmail(String email) {
        return this.coordinadoresRepository.findByEmail(email);
    }

    public List<CoordinadoresDto> buscarPorFiltros(String nombre, String apellido, String email, Long idGrado) {
        return coordinadoresRepository.buscarPorFiltros(nombre, apellido, email, idGrado);
    }

    public long contarTotal() {
        return coordinadoresRepository.contarTotal();
    }
}