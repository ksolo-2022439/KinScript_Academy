package org.kinscript.Academy.persistence;

import org.kinscript.Academy.persistence.entity.Cursos;
import org.kinscript.Academy.persistence.crud.CrudCursosEntity;
import org.kinscript.Academy.dominio.dto.CursosDto;
import org.kinscript.Academy.dominio.dto.ModCursosDto;
import org.kinscript.Academy.dominio.repository.CursosRepository;
import org.kinscript.Academy.dominio.service.CursosService;
import org.kinscript.Academy.persistence.mapper.CursosMapper;
import org.kinscript.Academy.dominio.exception.CursosExistsException;
import org.kinscript.Academy.dominio.exception.CursosNotExistsException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CursosEntityRepository implements CursosRepository{
    private final CrudCursosEntity crudCursosEntity;
    private final CursosMapper cursosMapper;

    public CursosEntityRepository(CrudCursosEntity crudCursosEntity, CursosMapper cursosMapper) {
        this.crudCursosEntity = crudCursosEntity;
        this.cursosMapper = cursosMapper;
    }

    @Override
    public List<CursosDto> obtenerCursos() {
        return cursosMapper.toDto(crudCursosEntity.findAll());
    }

    @Override
    public CursosDto buscarCursos(Long codigo) {
        Cursos curso = crudCursosEntity.findById(codigo).orElse(null);
        if (curso == null) {
            throw new CursosNotExistsException(codigo);
        }
        return cursosMapper.toDto(curso);
    }

    @Override
    public CursosDto guardarCursos(CursosDto cursosDto) {
        if (crudCursosEntity.findFirstByNombreCurso(cursosDto.nombreCurso()) != null) {
            throw new CursosExistsException(cursosDto.nombreCurso());
        }
        Cursos curso = cursosMapper.toEntity(cursosDto);
        crudCursosEntity.save(curso);
        return cursosMapper.toDto(curso);
    }

    @Override
    public CursosDto modificarCursos(Long codigo, ModCursosDto modCursosDto) {
        Cursos curso = crudCursosEntity.findById(codigo).orElse(null);
        if (curso == null) {
            throw new CursosNotExistsException(codigo);
        }
        curso.setNombreCurso(modCursosDto.nombreCurso());
        return cursosMapper.toDto(crudCursosEntity.save(curso));
    }

    @Override
    public void eliminarCursos(Long codigo) {
        Cursos cursos = crudCursosEntity.findById(codigo).orElse(null);
        if (cursos == null) {
            throw new CursosNotExistsException(codigo);
        }
        crudCursosEntity.deleteById(codigo);
    }
}
