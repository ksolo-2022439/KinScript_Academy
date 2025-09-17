package org.kinscript.Academy.dominio.repository;
import org.kinscript.Academy.dominio.dto.SeccionesDto;
import org.kinscript.Academy.dominio.dto.ModSeccionesDto;

import java.util.List;

public interface SeccionesRepository {
    List<SeccionesDto> obtenerSeccion();
    public SeccionesDto buscarSeccion(Long codigo);
    SeccionesDto guardarSeccion(SeccionesDto seccionesDto);
    SeccionesDto modificarSeccion(Long codigo, ModSeccionesDto  modSeccionesDto);
    void eliminarSeccion(Long codigo);
}