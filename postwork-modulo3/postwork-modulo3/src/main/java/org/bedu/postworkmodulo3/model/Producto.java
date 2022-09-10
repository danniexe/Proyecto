package org.bedu.postworkmodulo3.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;
@Data
@Builder
public class Producto {

    @PositiveOrZero(message = "El identificador no puede ser un número negativo")
    private long productoId;

    @NotEmpty(message = "El nombre del producto no puede estar vacio")
    private String nombre;

    @Size(min = 5, max = 20, message = "Minimo 5 letras, maximo 20")
    private String categoria;

    @DecimalMin(value = "1.00", inclusive = true)
    private float precio;


    @Pattern(regexp = "^(\\d{3}[-]?){2}\\d{4}$")
    private String numeroRegistro;

    @PastOrPresent
    private LocalDate fechaCreacion;


}
