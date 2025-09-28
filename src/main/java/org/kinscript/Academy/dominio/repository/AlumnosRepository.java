package org.kinscript.Academy.dominio.repository;

import org.kinscript.Academy.dominio.dto.AlumnosDto;
import org.kinscript.Academy.dominio.dto.ModAlumnosDto;

import java.util.List;

public interface AlumnosRepository {
    List<AlumnosDto> obtenerTodos();

    AlumnosDto buscarPorId(Long idAlumno);

    AlumnosDto guardar(AlumnosDto alumnosDto);

    AlumnosDto modificar(Long idAlumno, ModAlumnosDto modAlumnosDto);

    void eliminar(Long idAlumno);

    List<AlumnosDto> buscarPorFiltros(String carnet, String nombre, String email);

    long contarTotal();
}