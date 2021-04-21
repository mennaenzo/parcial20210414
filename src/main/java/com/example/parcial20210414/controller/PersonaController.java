package com.example.parcial20210414.controller;

import com.example.parcial20210414.model.Cumpleanitos;
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
    public void addJugadorToRepresentante(@PathVariable Integer idRepresentante, @PathVariable Integer idJugador){
        personaService.addJugadorToRepresentante(idRepresentante, idJugador);
    }

    @PutMapping("/representante/{idRepresentante}/amigo/{idAmigo}")
    public void addAmigoToRepresentante(@PathVariable Integer idRepresentante, @PathVariable Integer idAmigo){
        personaService.addAmigoToRepresentante(idRepresentante, idAmigo);
    }

    @PutMapping("/{idPersona}/cumpleanito")
    public void addCumpleanitoToPersona(@PathVariable Integer idPersona, @RequestBody Cumpleanitos cumpleanito){
        personaService.addCumpleanitoToPersona(idPersona, cumpleanito);
    }

    @PutMapping("/{id}/amigo/{idAmigo}")
    public void addAmigoToCumpleanito(@PathVariable Integer id, @PathVariable Integer idAmigo){
        personaService.addAmigoToCumpleanito(id, idAmigo);
    }
}
