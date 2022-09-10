package org.bedu.postworkmodulo3.persistence.entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
@Data
@Table(name = "VISITA")
@Entity
@NoArgsConstructor
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long visitaId;
    private long clienteId;

    private LocalDateTime fechaProgramada;


    private String direccion;

    private String proposito;

    private String vendedor;


}
