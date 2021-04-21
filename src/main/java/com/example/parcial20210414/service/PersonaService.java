package com.example.parcial20210414.service;

import com.example.parcial20210414.model.*;
import com.example.parcial20210414.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PersonaService {

    private PersonaRepository personaRepository;

    @Autowired
    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> getAll() {
        return personaRepository.findAll();
    }

    public void add(Persona persona) {
        personaRepository.save(persona);
    }

    public Persona getById(Integer id) {
        return personaRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void delete(Integer id) {
        personaRepository.deleteById(id);
    }

    public void addJugadorToRepresentante(Integer idRepresentante, Integer idJugador) {

        Representante representante = getById(idRepresentante) instanceof Representante ? ((Representante) getById(idRepresentante)) : null;

        if (representante != null)
        {
            Jugador jugador = getById(idJugador) instanceof Jugador ? ((Jugador) getById(idJugador)) : null;
            if (jugador != null)
            {
                representante.getJugadores().add(jugador);
                personaRepository.save(representante);
            }else{
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST); // Podria mandarse que no existe el idJugador
            }
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST); // Podria mandarse que no existe el idRepresentante
        }
    }

    public void addAmigoToCumpleanito(Integer id, Integer idAmigo) {

        Persona amigo = getById(idAmigo);

        if (amigo instanceof Amigo)
        {

        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }

    public void addCumpleanitoToPersona(Integer idPersona, Cumpleanitos cumpleanito) {
        Persona persona = getById(idPersona);
        cumpleanito.setCumpleaniero(persona);
        persona.getCumpleanitos().add(cumpleanito);
        personaRepository.save(persona);
    }

    public void addAmigoToRepresentante(Integer idRepresentante, Integer idAmigo) {
        Persona representante = getById(idRepresentante);
        Persona amigo = getById(idAmigo);

        if((representante instanceof Representante) && (amigo instanceof Amigo)){
            if(((Representante) representante).getAmigos().contains(amigo)){
                throw new IllegalArgumentException(String.format("Ya eres amigo de %s", amigo.getNombre()));
            }
            ((Representante) representante).getAmigos().add((Amigo) amigo);
            personaRepository.save(representante);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }

}
