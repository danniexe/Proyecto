package org.bedu.postworkmodulo3.persistence.entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;
import java.util.List;
@Data
@Table(name = "VENTA")
@Entity
@NoArgsConstructor
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ventaId;

    private List<Producto> productos;

    private String comprador;
    private LocalDateTime fecha;
    private List<Integer> cantidad;

}
