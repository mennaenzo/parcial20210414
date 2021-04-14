package model;

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

    private Float pesoBoveda;

    private Float montoTotal;
}
