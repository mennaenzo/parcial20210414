package com.example.parcial20210414.service;

import com.example.parcial20210414.model.Jugador;
import com.example.parcial20210414.model.Persona;
import com.example.parcial20210414.model.Representante;
import com.example.parcial20210414.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

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
            }
        }
    }

}
