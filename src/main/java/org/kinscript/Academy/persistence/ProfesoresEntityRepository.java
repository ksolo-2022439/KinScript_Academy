package org.kinscript.Academy.persistence;

import org.kinscript.Academy.dominio.dto.ModProfesoresDto;
import org.kinscript.Academy.dominio.dto.ProfesoresDto;
import org.kinscript.Academy.dominio.exception.ProfesorExistsException;
import org.kinscript.Academy.dominio.exception.ProfesorNotExistsException;
import org.kinscript.Academy.dominio.repository.ProfesoresRepository;
import org.kinscript.Academy.persistence.crud.CrudProfesoresEntity;
import org.kinscript.Academy.persistence.entity.Profesores;
import org.kinscript.Academy.persistence.mapper.ProfesoresMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProfesoresEntityRepository implements ProfesoresRepository {

    private final CrudProfesoresEntity crudProfesoresEntity;
    private final ProfesoresMapper profesoresMapper;

    public ProfesoresEntityRepository(CrudProfesoresEntity crudProfesoresEntity, ProfesoresMapper profesoresMapper) {
        this.crudProfesoresEntity = crudProfesoresEntity;
        this.profesoresMapper = profesoresMapper;
    }

    @Override
    public List<ProfesoresDto> obtenerProfesores() {
        return profesoresMapper.toDto(crudProfesoresEntity.findAll());
    }

    @Override
    public ProfesoresDto buscarProfesorPorId(Long idProfesor) {
        Profesores profesor = crudProfesoresEntity.findById(idProfesor).orElse(null);
        if (profesor == null) {
            throw new ProfesorNotExistsException(idProfesor);
        }
        return profesoresMapper.toDto(profesor);
    }

    @Override
    public ProfesoresDto guardarProfesor(ProfesoresDto profesoresDto) {
        if (crudProfesoresEntity.findFirstByEmail(profesoresDto.email()) != null) {
            throw new ProfesorExistsException(profesoresDto.email());
        }
        Profesores profesor = profesoresMapper.toEntity(profesoresDto);
        crudProfesoresEntity.save(profesor);
        return profesoresMapper.toDto(profesor);
    }

    @Override
    public ProfesoresDto modificarProfesor(Long idProfesor, ModProfesoresDto modProfesoresDto) {
        Profesores profesor = crudProfesoresEntity.findById(idProfesor).orElse(null);
        if (profesor == null) {
            throw new ProfesorNotExistsException(idProfesor);
        }
        profesor.setNombreCompleto(modProfesoresDto.nombreCompleto());
        profesor.setApellidoCompleto(modProfesoresDto.apellidoCompleto());
        profesor.setDireccion(modProfesoresDto.direccion());
        profesor.setNumeroTelefono(modProfesoresDto.numeroTelefono());
        return profesoresMapper.toDto(crudProfesoresEntity.save(profesor));
    }

    @Override
    public void eliminarProfesor(Long idProfesor) {
        Profesores profesor = crudProfesoresEntity.findById(idProfesor).orElse(null);
        if (profesor == null) {
            throw new ProfesorNotExistsException(idProfesor);
        }
        crudProfesoresEntity.deleteById(idProfesor);
    }

    @Override
    public Optional<ProfesoresDto> findByEmail(String email) {
        return crudProfesoresEntity.findFirstByEmail(email)
                .map(profesoresMapper::toDto);
    }

    @Override
    public List<ProfesoresDto> buscarPorFiltros(String nombre, String apellido, String telefono, String email) {
        List<Profesores> profesores = crudProfesoresEntity.findByFilters(
                (nombre != null && !nombre.isEmpty()) ? nombre : null,
                (apellido != null && !apellido.isEmpty()) ? apellido : null,
                (telefono != null && !telefono.isEmpty()) ? telefono : null,
                (email != null && !email.isEmpty()) ? email : null
        );
        return profesoresMapper.toDto(profesores);
    }

    @Override
    public long contarTotal() {
        return crudProfesoresEntity.count();
    }

}