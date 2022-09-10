package org.bedu.postworkmodulo3.persistence;


import org.bedu.postworkmodulo3.persistence.entities.Visita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitaRepository extends JpaRepository<Visita,Long> {
}
