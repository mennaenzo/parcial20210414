package com.example.parcial20210414.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "tipoPersona", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Representante.class, name = "REPRESENTANTE"),
        @JsonSubTypes.Type(value = Jugador.class, name = "JUGADOR"),
        @JsonSubTypes.Type(value = Amigo.class, name = "AMIGO")
})
public abstract class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@NotNull(message = "El campo nombre es obligatorio.")
    @NotBlank(message = "El campo nombre es obligatorio y no puede estar vacio.")
    private String nombre;

    //@NotNull(message = "El campo apellido es obligatorio.")
    @NotBlank(message = "El campo apellido es obligatorio y no puede estar vacio.")
    private String apellido;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "cumpleanitos_id")
    private Set<Cumpleanitos> cumpleanitos;
}
