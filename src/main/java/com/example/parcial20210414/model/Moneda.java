package com.example.parcial20210414.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
public class Moneda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@NotNull(message = "El campo descripcion es obligatorio.")
    @NotBlank(message = "El campo descripcion no puede estar vacio.")
    private String descripcion;

    @NotNull(message = "El campo monto es obligatorio.")
    @Min(value = 0, message = "El valor monto debe ser positivo.")
    private Float monto;

}
