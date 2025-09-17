package org.kinscript.Academy.persistence.mapper;

import org.kinscript.Academy.dominio.dto.ModTutoresDto;
import org.kinscript.Academy.dominio.dto.TutoresDto;
import org.kinscript.Academy.persistence.entity.Tutores;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TutoresMapper {
    TutoresDto toDto(Tutores entity);

    List<TutoresDto> toDto(Iterable<Tutores> entities);

    @InheritInverseConfiguration
    Tutores toEntity(TutoresDto dto);

    @Mapping(target = "idTutor", ignore = true)
    void modificarEntityFromDto(ModTutoresDto dto, @MappingTarget Tutores entity);
}