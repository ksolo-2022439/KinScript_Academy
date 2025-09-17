package org.kinscript.Academy.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import java.util.List;
import org.kinscript.Academy.dominio.dto.CursosDto;
import org.kinscript.Academy.persistence.entity.Cursos;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CursosMapper {

    CursosDto toDto(Cursos entity);

    List<CursosDto> toDto(Iterable<Cursos> entities);

    @InheritInverseConfiguration
    Cursos toEntity(CursosDto dto);
}
