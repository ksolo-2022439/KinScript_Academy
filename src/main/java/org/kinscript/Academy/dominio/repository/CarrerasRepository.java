package org.kinscript.Academy.dominio.repository;
import org.kinscript.Academy.dominio.dto.CarrerasDto;
import org.kinscript.Academy.dominio.dto.ModCarrerasDto;

import java.util.List;

    public interface CarrerasRepository {
    List<CarrerasDto> obtenerCarrera();
    public CarrerasDto buscarCarrera(Long codigo);
    CarrerasDto guardarCarrera(CarrerasDto carrerasDto);
    CarrerasDto modificarCarrera(Long codigo, ModCarrerasDto modcarrerasDto);
    void eliminarCarrera(Long codigo);
}