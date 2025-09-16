package org.kinscript.Academy.persistence.mapper;

import org.kinscript.Academy.dominio.dto.JornadasDto;
import org.kinscript.Academy.persistence.entity.Jornadas;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface JornadasMapper {

    JornadasDto toDto(Jornadas entity);

    List<JornadasDto> toDto(Iterable<Jornadas> entities);

    @InheritInverseConfiguration
    Jornadas toEntity(JornadasDto dto);
}