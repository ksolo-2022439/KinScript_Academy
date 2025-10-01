package org.kinscript.Academy.persistence.crud;

import org.kinscript.Academy.persistence.entity.Notas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CrudNotasEntity extends CrudRepository<Notas, Integer> {

    @Query("SELECT n FROM Notas n WHERE " +
            "(:idAlumno IS NULL OR n.idAlumno = :idAlumno) AND " +
            "(:idCurso IS NULL OR n.idCurso = :idCurso)")
    List<Notas> findByFilters(@Param("idAlumno") Long idAlumno, @Param("idCurso") Long idCurso);

    Optional<Notas> findByIdAlumnoAndIdCurso(Long idAlumno, Long idCurso);

    List<Notas> findByIdAlumno(Long idAlumno);
}