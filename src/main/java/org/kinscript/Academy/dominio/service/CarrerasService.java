package org.kinscript.Academy.dominio.service;

import org.kinscript.Academy.dominio.dto.CarrerasDto;
import org.kinscript.Academy.dominio.dto.ModCarrerasDto;
import org.kinscript.Academy.dominio.repository.CarrerasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrerasService {
    private final CarrerasRepository CarrerasRepository;

    public CarrerasService(CarrerasRepository carrerasRepository) {
        this.CarrerasRepository = carrerasRepository;
    }

    public List<CarrerasDto> obtenerTodo() {
        return this.CarrerasRepository.obtenerCarrera();
    }

    public CarrerasDto buscarPorCodigo(Long codigo) {
        return this.CarrerasRepository.buscarCarrera(codigo);
    }

    public CarrerasDto guardarGrados(CarrerasDto carrerasDto) {
        return this.CarrerasRepository.guardarCarrera(carrerasDto);
    }

    public CarrerasDto modificarGrados(Long codigo, ModCarrerasDto modcarrerasDto) {
        return this.CarrerasRepository.modificarCarrera(codigo, modcarrerasDto);
    }

    public void eliminarGrados(Long codigo) {
        this.CarrerasRepository.eliminarCarrera(codigo);
    }

}