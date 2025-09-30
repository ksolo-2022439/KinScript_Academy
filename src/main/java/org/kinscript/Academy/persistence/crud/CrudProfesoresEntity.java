package org.kinscript.Academy.persistence.crud;

import org.kinscript.Academy.persistence.entity.Profesores;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CrudProfesoresEntity extends CrudRepository<Profesores, Long> {

    @Query("SELECT p FROM Profesores p WHERE " +
            "(:nombre IS NULL OR lower(p.nombreCompleto) LIKE lower(concat('%', :nombre, '%'))) AND " +
            "(:apellido IS NULL OR lower(p.apellidoCompleto) LIKE lower(concat('%', :apellido, '%'))) AND " +
            "(:telefono IS NULL OR p.numeroTelefono LIKE concat('%', :telefono, '%')) AND " +
            "(:email IS NULL OR lower(p.email) LIKE lower(concat('%', :email, '%')))")
    List<Profesores> findByFilters(
            @Param("nombre") String nombre,
            @Param("apellido") String apellido,
            @Param("telefono") String telefono,
            @Param("email") String email
    );

    Optional<Profesores> findFirstByEmail (String email);
}