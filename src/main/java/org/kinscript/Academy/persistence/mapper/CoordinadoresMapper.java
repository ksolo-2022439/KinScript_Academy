package org.kinscript.Academy.persistence.mapper;

import org.kinscript.Academy.dominio.dto.CoordinadoresDto;
import org.kinscript.Academy.persistence.entity.Coordinadores;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoordinadoresMapper {
    @Mappings({
            @Mapping(source = "idCoordinador", target = "idCoordinador"),
            @Mapping(source = "nombreCompleto", target = "nombreCompleto")
    })
    CoordinadoresDto toDto(Coordinadores coordinadores);

    List<CoordinadoresDto> toDto(List<Coordinadores> coordinadores);

    @InheritInverseConfiguration
    @Mapping(target = "idCarrera", ignore = true)
    Coordinadores toEntity(CoordinadoresDto coordinadoresDto);
}