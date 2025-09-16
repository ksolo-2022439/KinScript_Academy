package org.kinscript.Academy.dominio.repository;

public class SeccionesRepository {
    List<SeccionesDto> obtenerSeccion();
    public SeccionesDto buscarSeccion(Long codigo);
    SeccionesDto guardarSeccion(SeccionesDto seccionesDto);
    SeccionesDto modificarSeccion(Long codigo, ModSeccionesDto  modSeccionesDto);
    void eliminarSeccion(Long codigo);
}