package org.kinscript.Academy.persistence.mapper;

import org.kinscript.Academy.dominio.dto.AlumnosDto;
import org.kinscript.Academy.dominio.dto.ModAlumnosDto;
import org.kinscript.Academy.persistence.entity.Alumnos;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlumnosMapper {

    AlumnosDto toDto(Alumnos alumno);
    List<AlumnosDto> toDto(List<Alumnos> alumnos);

    @InheritInverseConfiguration
    @Mapping(target = "grado", ignore = true)
    @Mapping(target = "seccion", ignore = true)
    @Mapping(target = "jornada", ignore = true)
    @Mapping(target = "carrera", ignore = true)
    @Mapping(target = "tutor", ignore = true)
    Alumnos toEntity(AlumnosDto alumnosDto);

    @Mapping(target = "idAlumno", ignore = true)
    @Mapping(target = "grado", ignore = true)
    @Mapping(target = "seccion", ignore = true)
    @Mapping(target = "jornada", ignore = true)
    @Mapping(target = "carrera", ignore = true)
    @Mapping(target = "tutor", ignore = true)
    Alumnos toEntity(ModAlumnosDto modAlumnosDto);
}