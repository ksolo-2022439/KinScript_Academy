package org.kinscript.Academy.persistence.mapper;

import org.kinscript.Academy.dominio.dto.ProfesorAsignacionDto;
import org.kinscript.Academy.persistence.entity.ProfesorAsignacion;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfesorAsignacionMapper {
    ProfesorAsignacionDto toDto(ProfesorAsignacion asignacion);

    List<ProfesorAsignacionDto> toDto(List<ProfesorAsignacion> asignaciones);

    @InheritInverseConfiguration
    @Mapping(target = "profesor", ignore = true)
    @Mapping(target = "curso", ignore = true)
    @Mapping(target = "grado", ignore = true)
    @Mapping(target = "seccion", ignore = true)
    @Mapping(target = "jornada", ignore = true)
    ProfesorAsignacion toEntity(ProfesorAsignacionDto asignacionDto);
}
