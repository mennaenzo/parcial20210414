package com.example.parcial20210414.controller;

import com.example.parcial20210414.model.Jugador;
import com.example.parcial20210414.service.PersonaService;
import com.example.parcial20210414.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @PostMapping
    public void add(@RequestBody Persona persona){
        personaService.add(persona);
    }

    @GetMapping
    public List<Persona> getAll(){
        return personaService.getAll();
    }

    @GetMapping("/{id}")
    public Persona getPersonaById(@PathVariable Integer id){
        return personaService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        personaService.delete(id);
    }

    @PutMapping("/{idRepresentante}/jugador/{idJugador}")
    public void addJugadorToRepresentante(@PathVariable Integer idRepresentante, @PathVariable List<Integer> idJugadores){
        personaService.addJugadorToRepresentante(idRepresentante, idJugadores);
    }
}
