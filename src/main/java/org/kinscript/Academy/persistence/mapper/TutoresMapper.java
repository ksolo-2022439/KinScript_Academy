package org.kinscript.Academy.persistence.mapper;

import org.kinscript.Academy.dominio.dto.TutoresDto;
import org.kinscript.Academy.persistence.entity.Tutores;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TutoresMapper {

    TutoresDto toDto(Tutores entity);

    List<TutoresDto> toDto(Iterable<Tutores> entities);

    @InheritInverseConfiguration
    Tutores toEntity(TutoresDto dto);
}