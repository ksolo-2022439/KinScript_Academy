package org.kinscript.Academy.dominio.service;

import org.kinscript.Academy.dominio.dto.NotasDto;
import org.kinscript.Academy.dominio.dto.ModNotasDto;
import org.kinscript.Academy.dominio.repository.NotasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotasService {
    private final NotasRepository notasRepository;

    public NotasService(NotasRepository notasRepository) {
        this.notasRepository = notasRepository;
    }

    public List<NotasDto> obtenerTodo() {
        return this.notasRepository.obtenerTodas();
    }

    public NotasDto buscarPorCodigo(Integer idNota) {
        return this.notasRepository.buscarPorId(idNota);
    }

    public List<NotasDto> buscarNotasPorAlumno(Integer idAlumno) {
        return this.notasRepository.buscarPorAlumno(idAlumno);
    }

    public NotasDto guardarNota(NotasDto notasDto) {
        return this.notasRepository.guardar(notasDto);
    }

    public NotasDto modificarNota(Integer idNota, ModNotasDto modNotasDto) {
        return this.notasRepository.modificar(idNota, modNotasDto);
    }

    public void eliminarNota(Integer idNota) {
        this.notasRepository.eliminar(idNota);
    }
}