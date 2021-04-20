package com.example.parcial20210414.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Jugador extends Persona{

    private Float peso;
    private Float altura;
    private Integer goles;
    private Integer minutosJugados;
    @ManyToOne
    private Moneda valor;
    private Date fechaNacimiento;

}
