package org.kinscript.Academy.persistence.crud;

import org.kinscript.Academy.persistence.entity.ProfesorAsignacion;
import org.kinscript.Academy.persistence.entity.ProfesorAsignacionId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrudProfesorAsignacionEntity extends CrudRepository<ProfesorAsignacion, ProfesorAsignacionId> {

    List<ProfesorAsignacion> findByIdProfesor(Integer idProfesor);
}