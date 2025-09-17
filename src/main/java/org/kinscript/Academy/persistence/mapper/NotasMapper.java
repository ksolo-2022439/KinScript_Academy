package org.kinscript.Academy.persistence.mapper;

import org.kinscript.Academy.dominio.dto.NotasDto;
import org.kinscript.Academy.persistence.entity.Notas;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotasMapper {

    NotasDto toDto(Notas nota);
    List<NotasDto> toDto(List<Notas> notas);

    @InheritInverseConfiguration
    @Mapping(target = "alumno", ignore = true)
    @Mapping(target = "curso", ignore = true)
    Notas toEntity(NotasDto notasDto);
}