package fr.kira.foramtion.spring.cinema.salle;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("salles")
@CrossOrigin
public class SalleController {
    private final SalleService service;

    public SalleController(SalleService service) {
        this.service = service;
    }

    @PostMapping
    public Salle save(@RequestBody Salle salle) {
        return service.save(salle);
    }

    @GetMapping
    public List<Salle> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public Salle findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @PutMapping
    public Salle update(@RequestBody Salle salle){
        return this.service.save(salle);
    }
}
