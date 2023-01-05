package fr.kira.foramtion.spring.cinema.seance;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("seances")
@CrossOrigin
public class SeanceController {
    private final SeanceService service;

    public SeanceController(SeanceService service) {
        this.service = service;
    }

    @PostMapping
    public Seance save(@RequestBody Seance seance) {
        return service.save(seance);
    }

    @GetMapping
    public List<Seance> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public Seance findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @PutMapping
    public Seance update(@RequestBody Seance seance){
        return this.service.save(seance);
    }

}
