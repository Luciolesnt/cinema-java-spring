package fr.kira.foramtion.spring.cinema.ticket;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tickets")
@CrossOrigin
public class TicketController {
    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @PostMapping
    public Ticket save(@RequestBody Ticket ticket) {
        return service.save(ticket);
    }

    @GetMapping
    public List<Ticket> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public Ticket findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @PutMapping
    public Ticket update(@RequestBody Ticket ticket){
        return this.service.save(ticket);
    }
}
