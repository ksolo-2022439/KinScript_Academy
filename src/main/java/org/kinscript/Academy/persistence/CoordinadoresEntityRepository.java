package org.kinscript.Academy.persistence;

import org.kinscript.Academy.dominio.dto.CoordinadoresDto;
import org.kinscript.Academy.dominio.dto.ModCoordinadoresDto;
import org.kinscript.Academy.dominio.exception.CoordinadorNoExisteException;
import org.kinscript.Academy.dominio.exception.CoordinadorYaExisteException;
import org.kinscript.Academy.persistence.crud.CrudCoordinadoresEntity;
import org.kinscript.Academy.persistence.entity.CoordinadoresEntity;
import org.kinscript.Academy.persistence.mapper.CoordinadoresMapper;
import org.kinscript.Academy.repository.CoordinadoresRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CoordinadoresEntityRepository implements CoordinadoresRepository {

    private final CrudCoordinadoresEntity crudCoordinadoresEntity;
    private final CoordinadoresMapper coordinadoresMapper;

    public CoordinadoresEntityRepository(CrudCoordinadoresEntity crudCoordinadoresEntity, CoordinadoresMapper coordinadoresMapper) {
        this.crudCoordinadoresEntity = crudCoordinadoresEntity;
        this.coordinadoresMapper = coordinadoresMapper;
    }

    @Override
    public List<CoordinadoresDto> obtenerCoordinador() {
        return this.coordinadoresMapper.toDto(this.crudCoordinadoresEntity.findAll());
    }

    @Override
    public CoordinadoresDto buscarCoordinador(Long codigo) {
        return this.coordinadoresMapper.toDto(this.crudCoordinadoresEntity.findById(codigo).orElse(null));
    }

    @Override
    public CoordinadoresDto guardarCoordinador(CoordinadoresDto coordinadoresDto) {
        if (this.crudCoordinadoresEntity.findByNombre(coordinadoresDto.getNombreCompleto()) != null) {
            throw new CoordinadorYaExisteException(coordinadoresDto.getNombreCompleto());
        } else {
            CoordinadoresEntity = this.coordinadoresMapper.toEntity(CoordinadoresDto);
            CoordinadoresEntity = this.coordinadoresMapper.save(CrudCoordinadoresEntity);
            return this.coordinadoresMapper.toDto(CoordinadoresEntity);
        }
    }

    @Override
    public CoordinadoresDto modificarCoordinador(Long codigo, ModCoordinadoresDto modCoordinadoresDto) {
        CoordinadoresEntity coordinadores = this.crudCoordinadoresEntity.findById(codigo).orElse(null);
        if (coordinadores != null) {
            this.coordinadoresMapper.modificarCoordinador(modPelicula, coordinadores);
            return coordinadoresMapper.toDto(this.crudCoordinadoresEntity.save(coordinadores));
        } else {
            throw new CoordinadorNoExisteException(codigo);
        }
    }

    @Override
    public void eliminarCoordinador(Long codigo) {
        CoordinadoresEntity coordinadore = this.crudCoordinadoresEntity.findById(codigo).orElse(null);
        //Exceptions
        if (coordinadore != null) {
            this.crudCoordinadoresEntity.delete(coordinadore);
        } else {
            throw new CoordinadorNoExisteException(codigo);
        }
    }
}
