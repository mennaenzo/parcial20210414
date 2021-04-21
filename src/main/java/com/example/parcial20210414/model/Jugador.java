package com.example.parcial20210414.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Jugador extends Persona{

    @NotNull(message = "El campo peso es obligatorio.")
    @Min(value = 0, message = "El valor debe ser mayor a cero.")
    private Float peso;

    @NotNull(message = "El campo altura es obligatorio.")
    @Min(value = 150, message = "La altura debe ser mayor a 150cm.")
    @Max(value = 220, message = "La altura debe ser menor a 220cm.")
    private Integer altura;

    @NotNull(message = "El campo goles es obligatorio.")
    @Min(value = 0, message = "El valor debe ser mayor a cero.")
    private Integer goles;

    @NotNull(message = "El campo minutosJugados es obligatorio.")
    @Min(value = 0, message = "El valor debe ser mayor a cero.")
    private Integer minutosJugados;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "moneda_id")
    private Moneda valor;

    @NotNull(message = "El campo fechaNacimiento es obligatorio.")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private Date fechaNacimiento;

}
