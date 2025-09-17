package org.kinscript.Academy.persistence;

import org.kinscript.Academy.dominio.dto.CarrerasDto;
import org.kinscript.Academy.dominio.dto.ModCarrerasDto;
import org.kinscript.Academy.dominio.repository.CarrerasRepository;
import org.kinscript.Academy.persistence.crud.CrudCarrerasEntity;
import org.kinscript.Academy.persistence.entity.Carreras;
import org.kinscript.Academy.persistence.mapper.CarrerasMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarrerasEntityRepository implements CarrerasRepository {

    private final CrudCarrerasEntity crudCarrerasEntity;
    private final CarrerasMapper carrerasMapper;

    public CarrerasEntityRepository(CrudCarrerasEntity crudCarrerasEntity, CarrerasMapper carrerasMapper) {
        this.crudCarrerasEntity = crudCarrerasEntity;
        this.carrerasMapper = carrerasMapper;
    }

    @Override
    public List<CarrerasDto> obtenerCarrera() {
        return carrerasMapper.toDto((List<Carreras>) crudCarrerasEntity.findAll());
    }

    @Override
    public CarrerasDto buscarCarrera(Long codigo) {
        return crudCarrerasEntity.findById(codigo.intValue())
                .map(carrerasMapper::toDto)
                .orElse(null);
    }

    @Override
    public CarrerasDto guardarCarrera(CarrerasDto carrerasDto) {
        if (crudCarrerasEntity.findByNombreCarrera(carrerasDto.nombreCarrera()) != null) {
        }
        Carreras carrera = carrerasMapper.toEntity(carrerasDto);
        return carrerasMapper.toDto(crudCarrerasEntity.save(carrera));
    }

    @Override
    public CarrerasDto modificarCarrera(Long codigo, ModCarrerasDto modcarrerasDto) {
        Optional<Carreras> carreraOptional = crudCarrerasEntity.findById(codigo.intValue());
        if (carreraOptional.isPresent()) {
            Carreras carrera = carreraOptional.get();
            carrera.setNombreCarrera(modcarrerasDto.nombreCarrera());
            return carrerasMapper.toDto(crudCarrerasEntity.save(carrera));
        }
        return null;
    }

    @Override
    public void eliminarCarrera(Long codigo) {
        if (crudCarrerasEntity.existsById(codigo.intValue())) {
            crudCarrerasEntity.deleteById(codigo.intValue());
        } else {
        }
    }
}