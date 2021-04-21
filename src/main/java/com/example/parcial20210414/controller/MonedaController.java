package com.example.parcial20210414.controller;

import com.example.parcial20210414.service.MonedaService;
import com.example.parcial20210414.model.Moneda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moneda")
public class MonedaController {

    @Autowired
    MonedaService monedaService;

    @PostMapping
    public void add(@RequestBody Moneda moneda){
        monedaService.add(moneda);
    }

    @GetMapping
    public List<Moneda> getAll(){
        return monedaService.getAll();
    }

    @GetMapping("/{id}")
    public Moneda getMonedaById(@PathVariable Integer id){
        return monedaService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        monedaService.delete(id);
    }

}
