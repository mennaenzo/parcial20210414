package com.example.parcial20210414.service;

import com.example.parcial20210414.model.Moneda;
import com.example.parcial20210414.repository.MonedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class MonedaService {

    @Autowired
    MonedaRepository monedaRepository;

    public List<Moneda> getAll() {
        return monedaRepository.findAll();
    }

    public void add(Moneda moneda) {
        monedaRepository.save(moneda);
    }

    public Moneda getById(Integer id) {
        return monedaRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void delete(Integer id) {
        monedaRepository.deleteById(id);
    }
}
