package controller;

import model.Moneda;
import model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.MonedaService;

import java.util.List;

@RestController
@RequestMapping("/moneda")
public class MonedaController {

    @Autowired
    private MonedaService monedaService;

    @PostMapping
    public void add(@RequestBody Moneda moneda){
        monedaService.add(moneda);
    }

    @GetMapping
    public List<Moneda> getAll(){
        return monedaService.getAll();
    }

    @GetMapping("/{id}")
    public Moneda getPersonaById(@PathVariable Integer id){
        return monedaService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        monedaService.delete(id);
    }

}
