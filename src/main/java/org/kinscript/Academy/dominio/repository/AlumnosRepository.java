package org.kinscript.Academy.dominio.repository;

import org.kinscript.Academy.dominio.dto.AlumnosDto;
import org.kinscript.Academy.dominio.dto.ModAlumnosDto;

import java.util.List;

public interface AlumnosRepository {
    List<AlumnosDto> obtenerTodos();
    AlumnosDto buscarPorId(Integer idAlumno);
    AlumnosDto guardar(AlumnosDto alumnosDto);
    AlumnosDto modificar(Integer idAlumno, ModAlumnosDto modAlumnosDto);
    void eliminar(Integer idAlumno);
}