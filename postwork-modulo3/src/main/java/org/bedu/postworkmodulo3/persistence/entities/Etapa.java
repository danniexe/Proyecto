package org.bedu.postworkmodulo3.persistence.entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Data
@Table(name = "ETAPAS")
@Entity
@NoArgsConstructor
public class Etapa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long etapaId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "orden", nullable = false)
    private int orden;


}
