package org.kinscript.Academy.persistence.mapper;

import org.kinscript.Academy.dominio.dto.GradoCursoDto;
import org.kinscript.Academy.persistence.entity.GradoCurso;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GradoCursoMapper {

    GradoCursoDto toDto(GradoCurso gradoCurso);
    List<GradoCursoDto> toDto(List<GradoCurso> gradoCursos);

    @InheritInverseConfiguration
    @Mapping(target = "grado", ignore = true)
    @Mapping(target = "curso", ignore = true)
    GradoCurso toEntity(GradoCursoDto gradoCursoDto);
}