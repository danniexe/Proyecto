package org.bedu.postworkmodulo3.persistence;

import org.bedu.postworkmodulo3.persistence.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.*;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}
