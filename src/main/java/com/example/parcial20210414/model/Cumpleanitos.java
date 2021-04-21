package com.example.parcial20210414.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Cumpleanitos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "El campo fecha es obligatorio.")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private LocalDate fecha;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "persona_id")
    @JsonIgnore
    private Persona cumpleaniero;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "persona_id")
    private Set<Persona> invitados;

}
