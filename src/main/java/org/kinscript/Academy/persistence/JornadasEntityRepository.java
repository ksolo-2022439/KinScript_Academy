package org.kinscript.Academy.persistence;

import org.kinscript.Academy.dominio.dto.JornadasDto;
import org.kinscript.Academy.dominio.dto.ModJornadasDto;
import org.kinscript.Academy.dominio.exception.JornadaExistsException;
import org.kinscript.Academy.dominio.exception.JornadaNotExistsException;
import org.kinscript.Academy.dominio.repository.JornadasRepository;
import org.kinscript.Academy.persistence.crud.CrudJornadasEntity;
import org.kinscript.Academy.persistence.entity.Jornadas;
import org.kinscript.Academy.persistence.mapper.JornadasMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JornadasEntityRepository implements JornadasRepository {

    private final CrudJornadasEntity crudJornadasEntity;
    private final JornadasMapper jornadasMapper;

    public JornadasEntityRepository(CrudJornadasEntity crudJornadasEntity, JornadasMapper jornadasMapper) {
        this.crudJornadasEntity = crudJornadasEntity;
        this.jornadasMapper = jornadasMapper;
    }

    @Override
    public List<JornadasDto> obtenerJornadas() {
        return jornadasMapper.toDto(crudJornadasEntity.findAll());
    }

    @Override
    public JornadasDto buscarJornadas(Long codigo) {
        Jornadas jornada = crudJornadasEntity.findById(codigo).orElse(null);
        if (jornada == null) {
            throw new JornadaNotExistsException(codigo);
        }
        return jornadasMapper.toDto(jornada);
    }

    @Override
    public JornadasDto guardarJornadas(JornadasDto jornadasDto) {
        if (crudJornadasEntity.findFirstByNombreJornada(jornadasDto.nombreJornada()) != null) {
            throw new JornadaExistsException(jornadasDto.nombreJornada());
        }
        Jornadas jornada = jornadasMapper.toEntity(jornadasDto);
        crudJornadasEntity.save(jornada);
        return jornadasMapper.toDto(jornada);
    }

    @Override
    public JornadasDto modificarJornadas(Long codigo, ModJornadasDto modJornadasDto) {
        Jornadas jornada = crudJornadasEntity.findById(codigo).orElse(null);
        if (jornada == null) {
            throw new JornadaNotExistsException(codigo);
        }
        jornada.setNombreJornada(modJornadasDto.nombreJornada());
        return jornadasMapper.toDto(crudJornadasEntity.save(jornada));
    }

    @Override
    public void eliminarJornadas(Long codigo) {
        Jornadas jornada = crudJornadasEntity.findById(codigo).orElse(null);
        if (jornada == null) {
            throw new JornadaNotExistsException(codigo);
        }
        crudJornadasEntity.deleteById(codigo);
    }
}
