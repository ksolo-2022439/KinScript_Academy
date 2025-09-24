package org.kinscript.Academy.persistence.mapper;

import org.kinscript.Academy.dominio.dto.CoordinadoresDto;
import org.kinscript.Academy.persistence.entity.Coordinadores;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoordinadoresMapper {

    CoordinadoresDto toDto(Coordinadores coordinador);
    List<CoordinadoresDto> toDto(List<Coordinadores> coordinadores);

    @InheritInverseConfiguration
    @Mapping(target = "grado", ignore = true)
    Coordinadores toEntity(CoordinadoresDto coordinadoresDto);
}