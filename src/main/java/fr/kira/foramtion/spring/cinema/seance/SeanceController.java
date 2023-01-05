package fr.kira.foramtion.spring.cinema.seance;

import fr.kira.foramtion.spring.cinema.acteur.Acteur;
import fr.kira.foramtion.spring.cinema.exceptions.BadRequestException;
import fr.kira.foramtion.spring.cinema.film.Film;
import fr.kira.foramtion.spring.cinema.film.FilmController;
import fr.kira.foramtion.spring.cinema.salle.Salle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("seances")
@CrossOrigin
public class SeanceController {
    private final SeanceService service;
    private final Logger logger = (Logger) LoggerFactory.getLogger(FilmController.class);


    public SeanceController(SeanceService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Seance save(@RequestBody Seance seance) {
        if(seance.getSalle() == null || seance.getFilm() == null) {
            logger.warn("La séance doit posséder une salle et un film.");
            throw new BadRequestException("La séance doit posséder une salle et un film.");
        }
        var capacite = seance.getSalle().getCapacite();
        seance.setPlacesDisponibles(capacite);
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

    /**
     * <h2>Ajoute la Salle à une {@link Seance} en fonction de leurs ids</h2>
     * @param id de la seance
     * @param idSalle du salle
     */
    @PostMapping("{id}/salle/{idSalle}")
    public void addSalle(@PathVariable Integer id, @PathVariable Integer idSalle){
        this.service.addSalleById(id, idSalle);
    }

    /**
     * <h2>Supprime la Salle d'une {@link Seance}</h2>
     * @param id de la seance
     */
    @DeleteMapping("{id}/salle")
    public void deleteSalle(@PathVariable Integer id){
        this.service.deleteSalle(id);
    }

    /**
     * <h2>Ajoute le Film à une {@link Seance} en fonction de leurs ids</h2>
     * @param id de la seance
     * @param idFilm du film
     */
    @PostMapping("{id}/film/{idFilm}")
    public void addFilm(@PathVariable Integer id, @PathVariable Integer idFilm){
        this.service.addFilmById(id, idFilm);
    }

    /**
     * <h2>Supprime le Film d'une {@link Seance}</h2>
     * @param id de la seance
     */
    @DeleteMapping("{id}/film")
    public void deleteFilm(@PathVariable Integer id){
        this.service.deleteFilm(id);
    }
}
