package org.bedu.postworkmodulo3.persistence;


import org.bedu.postworkmodulo3.persistence.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Long> {
}
