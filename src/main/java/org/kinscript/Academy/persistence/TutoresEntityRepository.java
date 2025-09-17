package org.kinscript.Academy.persistence;

import org.kinscript.Academy.dominio.dto.ModTutoresDto;
import org.kinscript.Academy.dominio.dto.TutoresDto;
import org.kinscript.Academy.dominio.repository.TutoresRepository;
import org.kinscript.Academy.persistence.crud.CrudTutoresEntity;
import org.kinscript.Academy.persistence.entity.Tutores;
import org.kinscript.Academy.persistence.mapper.TutoresMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TutoresEntityRepository implements TutoresRepository {
    private final CrudTutoresEntity crudTutoresEntity;
    private final TutoresMapper mapper;

    public TutoresEntityRepository(CrudTutoresEntity crudTutoresEntity, TutoresMapper mapper) {
        this.crudTutoresEntity = crudTutoresEntity;
        this.mapper = mapper;
    }

    @Override
    public List<TutoresDto> obtenerTodo() {
        Iterable<Tutores> entities = crudTutoresEntity.findAll();
        return mapper.toDto(entities);
    }

    @Override
    public Optional<TutoresDto> buscarPorCodigo(Integer codigo) {
        return crudTutoresEntity.findById(codigo).map(mapper::toDto);
    }

    @Override
    public TutoresDto guardarTutor(TutoresDto tutorDto) {
        if (this.crudTutoresEntity.findByNombreCompleto(tutorDto.nombreCompleto()) != null) {
            return null;
        }
        Tutores tutor = mapper.toEntity(tutorDto);
        this.crudTutoresEntity.save(tutor);
        return mapper.toDto(tutor);
    }

    @Override
    public TutoresDto modificarTutor(Integer codigo, ModTutoresDto modTutoresDto) {
        Tutores tutor = this.crudTutoresEntity.findById(codigo).orElse(null);

        if (tutor == null) {
            return null;
        }

        this.mapper.modificarEntityFromDto(modTutoresDto, tutor);
        return mapper.toDto(this.crudTutoresEntity.save(tutor));
    }

    @Override
    public void eliminarTutor(Integer codigo) {
        Tutores tutor = this.crudTutoresEntity.findById(codigo).orElse(null);

        if (tutor == null) {
        } else {
            this.crudTutoresEntity.deleteById(codigo);
        }
    }
}