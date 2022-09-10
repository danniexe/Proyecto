package org.bedu.postworkmodulo3.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Data
@Builder
public class Etapa {

    @PositiveOrZero(message = "El identificador no puede ser un número negativo")
    private long etapaId;

    @NotEmpty(message = "El nombre de la etapa no puede estar vacio")
    private String nombre;

    @Positive(message = "La etapa debe ser mayor a 0")
    private int orden;


}
