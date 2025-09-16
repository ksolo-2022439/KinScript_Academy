//package org.kinscript.Academy.persistence.mapper;
//
//import org.kinscript.Academy.dominio.dto.NotasDto;
//import org.kinscript.Academy.persistence.entity.Notas;
//import org.mapstruct.InheritInverseConfiguration;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.MappingConstants;
//import java.util.List;
//
//@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
//public interface NotasMapper {
//
//    @Mapping(source = "alumno.nombreCompleto", target = "nombreAlumno")
//    @Mapping(source = "alumno.carnetAlumno", target = "carnetAlumno")
//    @Mapping(source = "curso.nombreCurso", target = "nombreCurso")
//    NotasDto toDto(Notas entity);
//
//    List<NotasDto> toDto(Iterable<Notas> entities);
//
//    @InheritInverseConfiguration
//    @Mapping(target = "idNota", ignore = true) // Ignorar el ID al convertir de DTO a Entidad
//    @Mapping(target = "alumno", ignore = true) // Ignorar la entidad Alumnos
//    @Mapping(target = "curso", ignore = true)   // Ignorar la entidad Cursos
//    Notas toEntity(NotasDto dto);
//}