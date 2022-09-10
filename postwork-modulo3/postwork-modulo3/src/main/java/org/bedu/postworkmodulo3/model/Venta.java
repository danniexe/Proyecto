package org.bedu.postworkmodulo3.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;
@Data
@Builder
public class Venta {

    @PositiveOrZero(message = "El identificador no puede ser un número negativo")
    private long ventaId;

    @NotEmpty(message = "Debe contener al menos un producto")
    private List<Producto> productos;

    @NotNull(message = "Ingresar un comprador")
    private String comprador;

    @PastOrPresent(message = "La venta no puede ocurrir en el futuro")
    private LocalDateTime fecha;

    @NotEmpty(message = "Ingrese la cantidad de acuerdo con el mismo orden de los productos")
    private List<Integer> cantidad;

}
