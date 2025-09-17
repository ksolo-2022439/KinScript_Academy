package org.kinscript.Academy.dominio.service;

import org.kinscript.Academy.dominio.dto.JornadasDto;
import org.kinscript.Academy.dominio.dto.ModJornadasDto;
import org.kinscript.Academy.dominio.repository.JornadasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JornadasService {

    private final JornadasRepository JornadasRepository;

    public JornadasService(JornadasRepository jornadasRepository) { this.JornadasRepository = jornadasRepository; }

    public List<JornadasDto> obtenerTodo() { return this.JornadasRepository.obtenerJornadas(); }

    public JornadasDto buscarPorCodigo(Long codigo) { return this.JornadasRepository.buscarJornadas(codigo); }

    public JornadasDto guardarJornadas(JornadasDto  JornadasDto) { return this.JornadasRepository.guardarJornadas(JornadasDto); }

    public JornadasDto modificarJornadas(Long codigo, ModJornadasDto modJornadasDto) {
        return this.JornadasRepository.modificarJornadas(codigo, modJornadasDto);
    }

    public void eliminarJornadas(Long codigo) { this.JornadasRepository.eliminarJornadas(codigo); }
}
