package org.bedu.postworkmodulo3.persistence;

import org.bedu.postworkmodulo3.persistence.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta,Long> {
}
