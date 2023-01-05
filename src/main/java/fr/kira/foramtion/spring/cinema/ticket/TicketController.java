package fr.kira.foramtion.spring.cinema.ticket;

import fr.kira.foramtion.spring.cinema.exceptions.BadRequestException;
import fr.kira.foramtion.spring.cinema.film.FilmController;
import fr.kira.foramtion.spring.cinema.seance.Seance;
import fr.kira.foramtion.spring.cinema.seance.SeanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tickets")
@CrossOrigin
public class TicketController {
    private final TicketService service;
    private final SeanceService seanceService;
    private final Logger logger = (Logger) LoggerFactory.getLogger(FilmController.class);

    public TicketController(TicketService service, SeanceService seanceService) {
        this.service = service;
        this.seanceService = seanceService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ticket save(@RequestBody Ticket ticket) {
        if (ticket.getSeance() == null) {
            logger.warn("Le ticket doit être assoicé à une séance.");
            throw new BadRequestException("Le ticket doit posséder une séance.");
        }
        var seanceById = seanceService.findById(ticket.getSeance().getId());
        var placeDispo = seanceById.getPlacesDisponibles();
        var nbrPlacesAReserver = ticket.getNombrePlaces();
        if (placeDispo < nbrPlacesAReserver) {
            logger.warn("Places restantes : " + placeDispo);
            throw new BadRequestException("Plus de place pour cette séance");
        } else {
            seanceById.setPlacesDisponibles(placeDispo - nbrPlacesAReserver);
            // ...TODO... => retourner le détail de la séance en sync avec la route get Seances
        }
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
