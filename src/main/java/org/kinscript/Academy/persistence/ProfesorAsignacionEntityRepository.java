package org.kinscript.Academy.persistence;

import org.kinscript.Academy.dominio.dto.ProfesorAsignacionDto;
import org.kinscript.Academy.dominio.exception.ProfesorAsignacionExistsException;
import org.kinscript.Academy.dominio.exception.ProfesorAsignacionNotExistsException;
import org.kinscript.Academy.dominio.repository.ProfesorAsignacionRepository;
import org.kinscript.Academy.persistence.crud.CrudProfesorAsignacionEntity;
import org.kinscript.Academy.persistence.entity.ProfesorAsignacion;
import org.kinscript.Academy.persistence.entity.ProfesorAsignacionId;
import org.kinscript.Academy.persistence.mapper.ProfesorAsignacionMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfesorAsignacionEntityRepository implements ProfesorAsignacionRepository {

    private final CrudProfesorAsignacionEntity crudAsignacionEntity;
    private final ProfesorAsignacionMapper asignacionMapper;

    public ProfesorAsignacionEntityRepository(CrudProfesorAsignacionEntity crudAsignacionEntity, ProfesorAsignacionMapper asignacionMapper) {
        this.crudAsignacionEntity = crudAsignacionEntity;
        this.asignacionMapper = asignacionMapper;
    }

    @Override
    public List<ProfesorAsignacionDto> obtenerTodas() {
        return asignacionMapper.toDto((List<ProfesorAsignacion>) crudAsignacionEntity.findAll());
    }

    @Override
    public List<ProfesorAsignacionDto> obtenerPorProfesor(Long idProfesor) {
        return asignacionMapper.toDto(crudAsignacionEntity.findByIdProfesor(idProfesor));
    }

    @Override
    public ProfesorAsignacionDto guardar(ProfesorAsignacionDto asignacionDto) {
        ProfesorAsignacionId id = new ProfesorAsignacionId(asignacionDto.idProfesor(), asignacionDto.idCurso(), asignacionDto.idGrado(), asignacionDto.idSeccion());
        if (crudAsignacionEntity.existsById(id)) {
            throw new ProfesorAsignacionExistsException(id.getIdProfesor(), id.getIdCurso(), id.getIdGrado(), id.getIdSeccion());
        }
        ProfesorAsignacion asignacion = asignacionMapper.toEntity(asignacionDto);
        return asignacionMapper.toDto(crudAsignacionEntity.save(asignacion));
    }

    @Override
    public void eliminar(ProfesorAsignacionDto asignacionDto) {
        ProfesorAsignacionId id = new ProfesorAsignacionId(asignacionDto.idProfesor(), asignacionDto.idCurso(), asignacionDto.idGrado(), asignacionDto.idSeccion());
        if (!crudAsignacionEntity.existsById(id)) {
            throw new ProfesorAsignacionNotExistsException(id.getIdProfesor(), id.getIdCurso(), id.getIdGrado(), id.getIdSeccion());
        }
        crudAsignacionEntity.deleteById(id);
    }
}