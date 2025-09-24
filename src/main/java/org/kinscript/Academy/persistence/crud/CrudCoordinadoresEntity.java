package org.kinscript.Academy.persistence.crud;

import org.kinscript.Academy.persistence.entity.Coordinadores;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CrudCoordinadoresEntity extends CrudRepository<Coordinadores, Long> {
    Optional<Coordinadores> findByEmail(String email);
}