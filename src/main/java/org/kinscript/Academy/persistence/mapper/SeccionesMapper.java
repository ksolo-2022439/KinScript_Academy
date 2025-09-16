package org.kinscript.Academy.persistence.mapper;

import org.kinscript.Academy.dominio.dto.SeccionesDto;
import org.kinscript.Academy.persistence.entity.Secciones;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SeccionesMapper {

    SeccionesDto toDto(Secciones entity);

    List<SeccionesDto> toDto(Iterable<Secciones> entities);

    @InheritInverseConfiguration
    Secciones toEntity(SeccionesDto dto);
}