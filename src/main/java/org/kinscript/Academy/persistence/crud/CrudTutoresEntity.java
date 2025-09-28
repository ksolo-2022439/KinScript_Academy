package org.kinscript.Academy.persistence.crud;

import org.kinscript.Academy.persistence.entity.Tutores;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrudTutoresEntity extends CrudRepository<Tutores, Integer> {

    List<Tutores> findByNombreCompletoContainingIgnoreCaseAndNumeroTelefonoContainingIgnoreCase(
            String nombre, String telefono
    );

    Tutores findByNombreCompleto(String nombreCompleto);
}