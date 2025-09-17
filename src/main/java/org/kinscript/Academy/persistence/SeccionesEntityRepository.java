package org.kinscript.Academy.persistence;

import org.kinscript.Academy.dominio.dto.SeccionesDto;
import org.kinscript.Academy.dominio.dto.ModSeccionesDto;
import org.kinscript.Academy.dominio.exception.SeccionExistsException;
import org.kinscript.Academy.dominio.exception.SeccionNotExistsException;
import org.kinscript.Academy.dominio.repository.SeccionesRepository;
import org.kinscript.Academy.persistence.crud.CrudSeccionesEntity;
import org.kinscript.Academy.persistence.entity.Secciones;
import org.kinscript.Academy.persistence.mapper.SeccionesMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeccionesEntityRepository implements SeccionesRepository {

    private final CrudSeccionesEntity crudSeccionesEntity;
    private final SeccionesMapper seccionesMapper;

    public SeccionesEntityRepository(CrudSeccionesEntity crudSeccionesEntity, SeccionesMapper seccionesMapper) {
        this.crudSeccionesEntity = crudSeccionesEntity;
        this.seccionesMapper = seccionesMapper;
    }

    @Override
    public List<SeccionesDto> obtenerSeccion() {
        return seccionesMapper.toDto(crudSeccionesEntity.findAll());
    }

    @Override
    public SeccionesDto buscarSeccion(Long codigo) {
        Secciones seccion = crudSeccionesEntity.findById(codigo).orElse(null);
        if (seccion == null) {
            throw new SeccionNotExistsException(codigo);
        }
        return seccionesMapper.toDto(seccion);
    }

    @Override
    public SeccionesDto guardarSeccion(SeccionesDto seccionesDto) {
        if (crudSeccionesEntity.findFirstByNombreSeccion(seccionesDto.nombreSeccion()) != null) {
            throw new SeccionExistsException(seccionesDto.nombreSeccion());
        }
        Secciones seccion = seccionesMapper.toEntity(seccionesDto);
        crudSeccionesEntity.save(seccion);
        return seccionesMapper.toDto(seccion);
    }

    @Override
    public SeccionesDto modificarSeccion(Long codigo, ModSeccionesDto modSeccionesDto) {
        Secciones seccion = crudSeccionesEntity.findById(codigo).orElse(null);
        if (seccion == null) {
            throw new SeccionNotExistsException(codigo);
        }
        seccion.setNombreSeccion(modSeccionesDto.nombreSeccion());
        return seccionesMapper.toDto(crudSeccionesEntity.save(seccion));
    }

    @Override
    public void eliminarSeccion(Long codigo) {
        Secciones seccion = crudSeccionesEntity.findById(codigo).orElse(null);
        if (seccion == null) {
            throw new SeccionNotExistsException(codigo);
        }
        crudSeccionesEntity.deleteById(codigo);
    }
}