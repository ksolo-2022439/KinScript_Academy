package org.kinscript.Academy.persistence.crud;

import org.kinscript.Academy.persistence.entity.ProfesorAsignacion;
import org.kinscript.Academy.persistence.entity.ProfesorAsignacionId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CrudProfesorAsignacionEntity extends CrudRepository<ProfesorAsignacion, ProfesorAsignacionId> {

    @Query("SELECT pa FROM ProfesorAsignacion pa WHERE " +
            "(:idProfesor IS NULL OR pa.idProfesor = :idProfesor) AND " +
            "(:idCurso IS NULL OR pa.idCurso = :idCurso) AND " +
            "(:idGrado IS NULL OR pa.idGrado = :idGrado) AND " +
            "(:idSeccion IS NULL OR pa.idSeccion = :idSeccion) AND " +
            "(:idJornada IS NULL OR pa.idJornada = :idJornada)")
    List<ProfesorAsignacion> findByFilters(
            @Param("idProfesor") Long idProfesor,
            @Param("idCurso") Long idCurso,
            @Param("idGrado") Long idGrado,
            @Param("idSeccion") Long idSeccion,
            @Param("idJornada") Long idJornada
    );

    List<ProfesorAsignacion> findByIdProfesor(Long idProfesor);
}