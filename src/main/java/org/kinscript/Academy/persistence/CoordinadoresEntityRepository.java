package org.kinscript.Academy.persistence;

import org.kinscript.Academy.dominio.dto.CoordinadoresDto;
import org.kinscript.Academy.dominio.dto.ModCoordinadoresDto;
import org.kinscript.Academy.dominio.exception.CoordinadorExistsException;
import org.kinscript.Academy.dominio.exception.CoordinadorNotExistsException;
import org.kinscript.Academy.dominio.repository.CoordinadoresRepository;
import org.kinscript.Academy.persistence.crud.CrudCoordinadoresEntity;
import org.kinscript.Academy.persistence.entity.Coordinadores;
import org.kinscript.Academy.persistence.mapper.CoordinadoresMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CoordinadoresEntityRepository implements CoordinadoresRepository {

    private final CrudCoordinadoresEntity crudCoordinadoresEntity;
    private final CoordinadoresMapper coordinadoresMapper;

    public CoordinadoresEntityRepository(CrudCoordinadoresEntity crudCoordinadoresEntity, CoordinadoresMapper coordinadoresMapper) {
        this.crudCoordinadoresEntity = crudCoordinadoresEntity;
        this.coordinadoresMapper = coordinadoresMapper;
    }

    @Override
    public List<CoordinadoresDto> obtenerTodos() {
        return coordinadoresMapper.toDto((List<Coordinadores>) crudCoordinadoresEntity.findAll());
    }

    @Override
    public Optional<CoordinadoresDto> buscarPorId(Long idCoordinador) {
        return crudCoordinadoresEntity.findById(idCoordinador)
                .map(coordinadoresMapper::toDto);
    }

    @Override
    public CoordinadoresDto guardar(CoordinadoresDto coordinadoresDto) {
        crudCoordinadoresEntity.findByEmail(coordinadoresDto.email())
                .ifPresent(c -> {
                    throw new CoordinadorExistsException(c.getEmail());
                });
        Coordinadores coordinador = coordinadoresMapper.toEntity(coordinadoresDto);
        return coordinadoresMapper.toDto(crudCoordinadoresEntity.save(coordinador));
    }

    @Override
    public Optional<CoordinadoresDto> modificar(Long idCoordinador, ModCoordinadoresDto modDto) {
        return crudCoordinadoresEntity.findById(idCoordinador)
                .map(coordinador -> {
                    coordinador.setNombreCompleto(modDto.nombreCompleto());
                    coordinador.setApellidoCompleto(modDto.apellidoCompleto());
                    coordinador.setEmail(modDto.email());
                    coordinador.setContrasena(modDto.contrasena());
                    coordinador.setIdGrado(modDto.idGrado());
                    return coordinadoresMapper.toDto(crudCoordinadoresEntity.save(coordinador));
                });
    }

    @Override
    public void eliminar(Long idCoordinador) {
        if (!crudCoordinadoresEntity.existsById(idCoordinador)) {
            throw new CoordinadorNotExistsException(idCoordinador);
        }
        crudCoordinadoresEntity.deleteById(idCoordinador);
    }

    @Override
    public Optional<CoordinadoresDto> findByEmail(String email) {
        return crudCoordinadoresEntity.findFirstByEmail(email)
                .map(coordinadoresMapper::toDto);
    }

    @Override
    public List<CoordinadoresDto> buscarPorFiltros(String nombre, String apellido, String email, Long idGrado) {
        List<Coordinadores> coordinadores = crudCoordinadoresEntity.findByFilters(
                (nombre != null && !nombre.isEmpty()) ? nombre : null,
                (apellido != null && !apellido.isEmpty()) ? apellido : null,
                (email != null && !email.isEmpty()) ? email : null,
                idGrado
        );
        return coordinadoresMapper.toDto(coordinadores);
    }

    @Override
    public long contarTotal() {
        return crudCoordinadoresEntity.count();
    }
}