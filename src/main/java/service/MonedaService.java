package service;

import model.Moneda;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import repository.MonedaRepository;

import java.util.List;

@Service
public class MonedaService {

    private MonedaRepository monedaRepository;

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
