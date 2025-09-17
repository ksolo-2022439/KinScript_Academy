package org.kinscript.Academy.persistence;

import org.kinscript.Academy.dominio.dto.AlumnosDto;
import org.kinscript.Academy.dominio.dto.ModAlumnosDto;
import org.kinscript.Academy.dominio.exception.AlumnoExistsException;
import org.kinscript.Academy.dominio.exception.AlumnoNotExistsException;
import org.kinscript.Academy.dominio.repository.AlumnosRepository;
import org.kinscript.Academy.persistence.crud.CrudAlumnosEntity;
import org.kinscript.Academy.persistence.entity.Alumnos;
import org.kinscript.Academy.persistence.mapper.AlumnosMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlumnosEntityRepository implements AlumnosRepository {

    private final CrudAlumnosEntity crudAlumnosEntity;
    private final AlumnosMapper alumnosMapper;

    public AlumnosEntityRepository(CrudAlumnosEntity crudAlumnosEntity, AlumnosMapper alumnosMapper) {
        this.crudAlumnosEntity = crudAlumnosEntity;
        this.alumnosMapper = alumnosMapper;
    }

    @Override
    public List<AlumnosDto> obtenerTodos() {
        return alumnosMapper.toDto((List<Alumnos>) crudAlumnosEntity.findAll());
    }

    @Override
    public AlumnosDto buscarPorId(Integer idAlumno) {
        return crudAlumnosEntity.findById(idAlumno)
                .map(alumnosMapper::toDto)
                .orElseThrow(() -> new AlumnoNotExistsException(idAlumno));
    }

    @Override
    public AlumnosDto guardar(AlumnosDto alumnosDto) {
        if (crudAlumnosEntity.findByCarnetAlumno(alumnosDto.carnetAlumno()).isPresent()) {
            throw new AlumnoExistsException(alumnosDto.carnetAlumno());
        }
        Alumnos alumno = alumnosMapper.toEntity(alumnosDto);
        return alumnosMapper.toDto(crudAlumnosEntity.save(alumno));
    }

    @Override
    public AlumnosDto modificar(Integer idAlumno, ModAlumnosDto modAlumnosDto) {
        Alumnos alumno = crudAlumnosEntity.findById(idAlumno)
                .orElseThrow(() -> new AlumnoNotExistsException(idAlumno));

        alumno.setCarnetAlumno(modAlumnosDto.carnetAlumno());
        alumno.setNombreCompleto(modAlumnosDto.nombreCompleto());
        alumno.setApellidoCompleto(modAlumnosDto.apellidoCompleto());
        alumno.setEmailAcademico(modAlumnosDto.emailAcademico());
        alumno.setContrasena(modAlumnosDto.contrasena());
        alumno.setDireccion(modAlumnosDto.direccion());
        alumno.setIdGrado(modAlumnosDto.idGrado());
        alumno.setIdSeccion(modAlumnosDto.idSeccion());
        alumno.setIdJornada(modAlumnosDto.idJornada());
        alumno.setIdCarrera(modAlumnosDto.idCarrera());
        alumno.setIdTutor(modAlumnosDto.idTutor());

        return alumnosMapper.toDto(crudAlumnosEntity.save(alumno));
    }

    @Override
    public void eliminar(Integer idAlumno) {
        if (!crudAlumnosEntity.existsById(idAlumno)) {
            throw new AlumnoNotExistsException(idAlumno);
        }
        crudAlumnosEntity.deleteById(idAlumno);
    }
}