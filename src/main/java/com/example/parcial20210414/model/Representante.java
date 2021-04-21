package com.example.parcial20210414.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Representante extends Persona{

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "jugador_id")
    private List<Jugador> jugadores;

    private Double pesoBoveda;

    private Double montoTotal;

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

}
