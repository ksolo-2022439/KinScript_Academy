package org.kinscript.Academy.persistence.crud;

import org.kinscript.Academy.persistence.entity.Alumnos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CrudAlumnosEntity extends CrudRepository<Alumnos, Integer> {

    @Query("SELECT a FROM Alumnos a WHERE " +
            "(:carnet IS NULL OR lower(a.carnetAlumno) LIKE lower(concat('%', :carnet, '%'))) AND " +
            "(:nombre IS NULL OR lower(a.nombreCompleto) LIKE lower(concat('%', :nombre, '%'))) AND " +
            "(:email IS NULL OR lower(a.emailAcademico) LIKE lower(concat('%', :email, '%'))) AND " +
            "(:idGrado IS NULL OR a.idGrado = :idGrado) AND " +
            "(:idSeccion IS NULL OR a.idSeccion = :idSeccion) AND " +
            "(:idCarrera IS NULL OR a.idCarrera = :idCarrera)")
    List<Alumnos> findByFilters(
            @Param("carnet") String carnet,
            @Param("nombre") String nombre,
            @Param("email") String email,
            @Param("idGrado") Long idGrado,
            @Param("idSeccion") Long idSeccion,
            @Param("idCarrera") Long idCarrera
    );

    List<Alumnos> findByCarnetAlumnoContainingIgnoreCaseAndNombreCompletoContainingIgnoreCaseAndEmailAcademicoContainingIgnoreCase(
            String carnet, String nombre, String email
    );

    Optional<Alumnos> findByCarnetAlumno(String carnetAlumno);
}