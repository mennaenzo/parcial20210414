package com.example.parcial20210414.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Representante extends Persona{

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "jugador_id")
    private List<Jugador> jugadores;

    @NotNull(message = "El campo pesoBoveda es obligatorio.")
    private Double pesoBoveda;

    @NotNull(message = "El campo montoTotal es obligatorio.")
    private Double montoTotal;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "amigo_id")
    private List<Amigo> amigos;

    public Double getMontoTotal() {
        return jugadores.stream()
                .map(Jugador::getValor)
                .mapToDouble(n ->
                {
                    if (n.getDescripcion().equals("DOLAR")) {
                        return n.getMonto() * 120;
                    }else if (n.getDescripcion().equals("EUROS")){
                        return n.getMonto() * 150;
                    }
                    return 0;
                }
                ).reduce(0, Double::sum);
    }

    public Double getPesoBoveda() {
        return getMontoTotal() / 100;
    }

}
