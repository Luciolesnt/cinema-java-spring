package fr.kira.foramtion.spring.cinema.seance;

import fr.kira.foramtion.spring.cinema.salle.Salle;
import fr.kira.foramtion.spring.cinema.film.Film;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="seances")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate date;

    private int placesDisponibles;

    private float prix;

    @ManyToOne
    @JoinColumn(name="film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name="salle_id")
    private Salle salle;
}
