package org.bedu.postworkmodulo3.persistence.entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
@Data
@Table(name = "PRODUCTOS")
@Entity
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productoId;

    private String nombre;

    private String categoria;

    private float precio;

    private String numeroRegistro;

    private LocalDate fechaCreacion;


}
