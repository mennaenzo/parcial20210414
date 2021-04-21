package com.example.parcial20210414.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
public class Amigo extends Persona{

    @NotNull(message = "El campo profesion es obligatorio.")
    private String profesion;

    @NotNull(message = "El campo statusSocial es obligatorio.")
    private TipoStatus statusSocial;

}
