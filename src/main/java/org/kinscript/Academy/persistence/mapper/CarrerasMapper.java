//package org.kinscript.Academy.persistence.mapper;
//
//import org.kinscript.Academy.dominio.dto.CarrerasDto;
//import org.kinscript.Academy.persistence.entity.Carreras;
//import org.mapstruct.InheritInverseConfiguration;
//import org.mapstruct.Mapper;
//import org.mapstruct.MappingConstants;
//import java.util.List;
//
//@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
//public interface CarrerasMapper {
//
//    CarrerasDto toDto(Carreras entity);
//
//    List<CarrerasDto> toDto(Iterable<Carreras> entities);
//
//    @InheritInverseConfiguration
//    Carreras toEntity(CarrerasDto dto);
//}