package org.kinscript.Academy.persistence.crud;

import org.kinscript.Academy.persistence.entity.Coordinadores;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CrudCoordinadoresEntity extends CrudRepository<Coordinadores, Long> {

    @Query("SELECT c FROM Coordinadores c WHERE " +
            "(:nombre IS NULL OR lower(c.nombreCompleto) LIKE lower(concat('%', :nombre, '%'))) AND " +
            "(:apellido IS NULL OR lower(c.apellidoCompleto) LIKE lower(concat('%', :apellido, '%'))) AND " +
            "(:email IS NULL OR lower(c.email) LIKE lower(concat('%', :email, '%'))) AND " +
            "(:idGrado IS NULL OR c.idGrado = :idGrado)")
    List<Coordinadores> findByFilters(
            @Param("nombre") String nombre,
            @Param("apellido") String apellido,
            @Param("email") String email,
            @Param("idGrado") Long idGrado
    );

    Optional<Coordinadores> findByEmail(String email);
    Optional<Coordinadores> findFirstByEmail(String email);
}