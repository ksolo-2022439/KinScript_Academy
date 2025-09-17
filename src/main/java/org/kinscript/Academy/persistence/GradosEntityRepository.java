package org.kinscript.Academy.persistence;

import org.kinscript.Academy.dominio.dto.GradosDto;
import org.kinscript.Academy.dominio.dto.ModGradosDto;
import org.kinscript.Academy.dominio.exception.GradoExistsException;
import org.kinscript.Academy.dominio.exception.GradoNotExistsException;
import org.kinscript.Academy.dominio.repository.GradosRepository;
import org.kinscript.Academy.persistence.crud.CrudGradosEntity;
import org.kinscript.Academy.persistence.entity.Grados;
import org.kinscript.Academy.persistence.mapper.GradosMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GradosEntityRepository implements GradosRepository {

    private final CrudGradosEntity crudGradosEntity;
    private final GradosMapper gradosMapper;

    public GradosEntityRepository(CrudGradosEntity crudGradosEntity, GradosMapper gradosMapper) {
        this.crudGradosEntity = crudGradosEntity;
        this.gradosMapper = gradosMapper;
    }

    @Override
    public List<GradosDto> obtenerGrados() {
        return gradosMapper.toDto(crudGradosEntity.findAll());
    }

    @Override
    public GradosDto buscarGrados(Long codigo) {
        Grados grado = crudGradosEntity.findById(codigo).orElse(null);
        if (grado == null) {
            throw new GradoNotExistsException(codigo);
        }
        return gradosMapper.toDto(grado);
    }

    @Override
    public GradosDto guardarGrados(GradosDto gradosDto) {
        if (crudGradosEntity.findFirstByNombreGrado(gradosDto.nombreGrado()) != null) {
            throw new GradoExistsException(gradosDto.nombreGrado());
        }
        Grados grado = gradosMapper.toEntity(gradosDto);
        crudGradosEntity.save(grado);
        return gradosMapper.toDto(grado);
    }

    @Override
    public GradosDto modificarGrados(Long codigo, ModGradosDto modGradosDto) {
        Grados grado = crudGradosEntity.findById(codigo).orElse(null);
        if (grado == null) {
            throw new GradoNotExistsException(codigo);
        }
        grado.setNombreGrado(modGradosDto.nombreGrado());
        return gradosMapper.toDto(crudGradosEntity.save(grado));
    }

    @Override
    public void eliminarGrados(Long codigo) {
        Grados grado = crudGradosEntity.findById(codigo).orElse(null);
        if (grado == null) {
            throw new GradoNotExistsException(codigo);
        }
        crudGradosEntity.deleteById(codigo);
    }
}
