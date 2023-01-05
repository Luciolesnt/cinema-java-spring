package fr.kira.foramtion.spring.cinema.film;

import fr.kira.foramtion.spring.cinema.film.dto.FilmCompletDto;
import fr.kira.foramtion.spring.cinema.film.dto.FilmReduitDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repository pour la gestion des films en utilisant Spring Boot data JPA.
 * Ici il y a 2 types de générique :
 * - Film qui définie que cette interface gère les films
 * - Integer qui est le type de la clé primaire des films
 */
public interface FilmJpaRepository extends JpaRepository<Film, Integer> {
    List<Film> findByTitre(String titre);
    List<Film> findByTitreContaining(String titre);

    List<Film> findByTitreContainingIgnoreCaseAndDureeBetween(String titre, int dureeStart, int dureeEnd);

}
