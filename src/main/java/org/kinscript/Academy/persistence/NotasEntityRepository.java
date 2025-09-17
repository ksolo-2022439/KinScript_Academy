package org.kinscript.Academy.persistence;

import org.kinscript.Academy.dominio.dto.NotasDto;
import org.kinscript.Academy.dominio.dto.ModNotasDto;
import org.kinscript.Academy.dominio.exception.NotaExistsException;
import org.kinscript.Academy.dominio.exception.NotaNotExistsException;
import org.kinscript.Academy.dominio.repository.NotasRepository;
import org.kinscript.Academy.persistence.crud.CrudNotasEntity;
import org.kinscript.Academy.persistence.entity.Notas;
import org.kinscript.Academy.persistence.mapper.NotasMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NotasEntityRepository implements NotasRepository {

    private final CrudNotasEntity crudNotasEntity;
    private final NotasMapper notasMapper;

    public NotasEntityRepository(CrudNotasEntity crudNotasEntity, NotasMapper notasMapper) {
        this.crudNotasEntity = crudNotasEntity;
        this.notasMapper = notasMapper;
    }

    @Override
    public List<NotasDto> obtenerTodas() {
        return notasMapper.toDto((List<Notas>) crudNotasEntity.findAll());
    }

    @Override
    public NotasDto buscarPorId(Integer idNota) {
        return crudNotasEntity.findById(idNota)
                .map(notasMapper::toDto)
                .orElseThrow(() -> new NotaNotExistsException(idNota));
    }

    @Override
    public List<NotasDto> buscarPorAlumno(Integer idAlumno) {
        List<Notas> notas = crudNotasEntity.findByIdAlumno(idAlumno);
        return notasMapper.toDto(notas);
    }

    @Override
    public NotasDto guardar(NotasDto notasDto) {
        crudNotasEntity.findByIdAlumnoAndIdCurso(notasDto.idAlumno(), notasDto.idCurso())
                .ifPresent(nota -> {
                    throw new NotaExistsException(notasDto.idAlumno(), notasDto.idCurso());
                });

        Notas nota = notasMapper.toEntity(notasDto);
        return notasMapper.toDto(crudNotasEntity.save(nota));
    }

    @Override
    public NotasDto modificar(Integer idNota, ModNotasDto modNotasDto) {
        Notas nota = crudNotasEntity.findById(idNota)
                .orElseThrow(() -> new NotaNotExistsException(idNota));

        nota.setIdAlumno(modNotasDto.idAlumno());
        nota.setIdCurso(modNotasDto.idCurso());
        nota.setBimestre1(modNotasDto.bimestre1());
        nota.setBimestre2(modNotasDto.bimestre2());
        nota.setBimestre3(modNotasDto.bimestre3());
        nota.setBimestre4(modNotasDto.bimestre4());

        return notasMapper.toDto(crudNotasEntity.save(nota));
    }

    @Override
    public void eliminar(Integer idNota) {
        if (!crudNotasEntity.existsById(idNota)) {
            throw new NotaNotExistsException(idNota);
        }
        crudNotasEntity.deleteById(idNota);
    }
}