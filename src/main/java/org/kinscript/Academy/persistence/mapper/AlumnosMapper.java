package org.kinscript.Academy.persistence.mapper;

import org.kinscript.Academy.dominio.dto.AlumnosDto;
import org.kinscript.Academy.persistence.entity.Alumnos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AlumnosMapper {

    @Mapping(source = "grado.idGrado", target = "idGrado")
    @Mapping(source = "secciones.idSeccion", target = "idSeccion")
    @Mapping(source = "jornadas.idJornada", target = "idJornada")
    @Mapping(source = "carreras.idCarrera", target = "idCarrera")
    @Mapping(source = "tutores.idTutor", target = "idTutor")
    @Mapping(target = "contrasena", ignore = true)
    AlumnosDto toDto(Alumnos entity);

    List<AlumnosDto> toDto(Iterable<Alumnos> entities);

    @Mapping(target = "grado", ignore = true)
    @Mapping(target = "secciones", ignore = true)
    @Mapping(target = "jornadas", ignore = true)
    @Mapping(target = "carreras", ignore = true)
    @Mapping(target = "tutores", ignore = true)
    @Mapping(target = "idAlumno", ignore = true)
    @Mapping(target = "contrasena", ignore = true)
    Alumnos toEntity(AlumnosDto dto);
}