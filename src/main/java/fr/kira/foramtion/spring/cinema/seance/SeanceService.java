package fr.kira.foramtion.spring.cinema.seance;

import fr.kira.foramtion.spring.cinema.film.Film;
import fr.kira.foramtion.spring.cinema.salle.Salle;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SeanceService {

    private final SeanceJpaRepository jpaRepository;

    public SeanceService(SeanceJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public Seance save(Seance seance) {
        return jpaRepository.save(seance);
    }

    public List<Seance> findAll() {
        return jpaRepository.findAll();
    }

    public Seance findById(Integer integer) {
        return jpaRepository.findById(integer).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deleteById(Integer integer) {
        jpaRepository.deleteById(integer);
    }

    /**
     * Supprime la Salle d'une {@link Seance};
     * @param id de la seance
     */
    public void deleteSalle(Integer id) {
        Seance seance = jpaRepository.findById(id).orElseThrow();
        seance.setSalle(null);
        jpaRepository.save(seance);
    }

    /**
     * Ajoute une {@link Salle} à une {@link Seance} en fonction de leurs ids;
     * @param id de la seance
     * @param idSalle de la salle
     */
    public void addSalleById(Integer id, Integer idSalle) {
        Salle salle = new Salle();
        salle.setId(idSalle);
        Seance seance = jpaRepository.findById(id).orElseThrow();
        seance.setSalle(salle);
        jpaRepository.save(seance);
    }

    /**
     * Supprime le Film d'une {@link Seance};
     * @param id de la seance
     */
    public void deleteFilm(Integer id) {
        Seance seance = jpaRepository.findById(id).orElseThrow();
        seance.setFilm(null);
        jpaRepository.save(seance);
    }

    /**
     * Ajoute un Film à une {@link Seance};
     * @param id de la seance
     * @param idFilm du Film
     */
    public void addFilmById(Integer id, Integer idFilm) {
        Film film = new Film();
        film.setId(idFilm);
        Seance seance = jpaRepository.findById(id).orElseThrow();
        seance.setFilm(film);
        jpaRepository.save(seance);
    }
}
