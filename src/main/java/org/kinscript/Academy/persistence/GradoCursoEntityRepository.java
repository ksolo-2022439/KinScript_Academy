package org.kinscript.Academy.persistence;

import org.kinscript.Academy.dominio.dto.GradoCursoDto;
import org.kinscript.Academy.dominio.exception.GradoCursoExistsException;
import org.kinscript.Academy.dominio.exception.GradoCursoNotExistsException;
import org.kinscript.Academy.dominio.repository.GradoCursoRepository;
import org.kinscript.Academy.persistence.crud.CrudGradoCursoEntity;
import org.kinscript.Academy.persistence.entity.GradoCurso;
import org.kinscript.Academy.persistence.entity.GradoCursoId;
import org.kinscript.Academy.persistence.mapper.GradoCursoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GradoCursoEntityRepository implements GradoCursoRepository {

    private final CrudGradoCursoEntity crudGradoCursoEntity;
    private final GradoCursoMapper gradoCursoMapper;

    public GradoCursoEntityRepository(CrudGradoCursoEntity crudGradoCursoEntity, GradoCursoMapper gradoCursoMapper) {
        this.crudGradoCursoEntity = crudGradoCursoEntity;
        this.gradoCursoMapper = gradoCursoMapper;
    }

    @Override
    public List<GradoCursoDto> obtenerTodos() {
        return gradoCursoMapper.toDto((List<GradoCurso>) crudGradoCursoEntity.findAll());
    }

    @Override
    public List<GradoCursoDto> obtenerPorGrado(Integer idGrado) {
        return gradoCursoMapper.toDto(crudGradoCursoEntity.findByIdGrado(idGrado));
    }

    @Override
    public GradoCursoDto guardar(GradoCursoDto gradoCursoDto) {
        GradoCursoId id = new GradoCursoId(gradoCursoDto.idGrado(), gradoCursoDto.idCurso());
        if (crudGradoCursoEntity.existsById(id)) {
            throw new GradoCursoExistsException(id.getIdGrado(), id.getIdCurso());
        }
        GradoCurso gradoCurso = gradoCursoMapper.toEntity(gradoCursoDto);
        return gradoCursoMapper.toDto(crudGradoCursoEntity.save(gradoCurso));
    }

    @Override
    public void eliminar(Integer idGrado, Integer idCurso) {
        GradoCursoId id = new GradoCursoId(idGrado, idCurso);
        if (!crudGradoCursoEntity.existsById(id)) {
            throw new GradoCursoNotExistsException(id.getIdGrado(), id.getIdCurso());
        }
        crudGradoCursoEntity.deleteById(id);
    }
}