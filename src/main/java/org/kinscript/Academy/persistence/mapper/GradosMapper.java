package org.kinscript.Academy.persistence.mapper;

import org.kinscript.Academy.dominio.dto.GradosDto;
import org.kinscript.Academy.persistence.entity.Grados;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GradosMapper {

    GradosDto toDto(Grados entity);

    List<GradosDto> toDto(Iterable<Grados> entities);

    @InheritInverseConfiguration
    Grados toEntity(GradosDto dto);
}