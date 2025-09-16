//package org.kinscript.Academy.persistence.mapper;
//
//import org.kinscript.Academy.dominio.dto.CoordinadoresDto;
//import org.kinscript.Academy.persistence.entity.Coordinadores;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.MappingConstants;
//import java.util.List;
//
//@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
//public interface CoordinadoresMapper {
//
//    @Mapping(source = "grado.nombreGrado", target = "nombreGrado")
//    @Mapping(target = "contrasena", ignore = true)
//    CoordinadoresDto toDto(Coordinadores entity);
//
//    List<CoordinadoresDto> toDto(Iterable<Coordinadores> entities);
//
//    @Mapping(target = "grado", ignore = true)
//    @Mapping(target = "contrasena", ignore = true)
//    Coordinadores toEntity(CoordinadoresDto dto);
//}