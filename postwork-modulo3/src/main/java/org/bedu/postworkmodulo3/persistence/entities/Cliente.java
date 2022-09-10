package org.bedu.postworkmodulo3.persistence.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Table(name = "CLIENTES")
@Entity
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "correo_contacto", nullable = false)
    private String correoContacto;

    @Column(name = "numero_empleados")
    private String numeroEmpleados;

    private String direccion;

}
