//package org.kinscript.Academy.persistence.mapper;
//
//import org.kinscript.Academy.dominio.dto.ProfesoresDto;
//import org.kinscript.Academy.persistence.entity.Profesores;
//import org.mapstruct.InheritInverseConfiguration;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.MappingConstants;
//import java.util.List;
//
//@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
//public interface ProfesoresMapper {
//
//    @Mapping(target = "contrasena", ignore = true)
//    ProfesoresDto toDto(Profesores entity);
//
//    List<ProfesoresDto> toDto(Iterable<Profesores> entities);
//
//    @InheritInverseConfiguration
//    @Mapping(target = "idProfesor", ignore = true)
//    Profesores toEntity(ProfesoresDto dto);
//}