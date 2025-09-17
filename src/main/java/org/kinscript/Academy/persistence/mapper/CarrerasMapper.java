package org.kinscript.Academy.persistence.mapper;

import org.kinscript.Academy.dominio.dto.CarrerasDto;
import org.kinscript.Academy.persistence.entity.Carreras;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarrerasMapper {
    @Mappings({
            @Mapping(source = "idCarrera", target = "idCarrera"),
            @Mapping(source = "nombreCarrera", target = "nombreCarrera")
    })
    CarrerasDto toDto(Carreras carreras);

    List<CarrerasDto> toDto(List<Carreras> carreras);

    @InheritInverseConfiguration
    @Mapping(target = "idCarrera", ignore = true)
    Carreras toEntity(CarrerasDto carrerasDto);
}