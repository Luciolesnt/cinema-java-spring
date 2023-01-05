package fr.kira.foramtion.spring.cinema.acteur;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import fr.kira.foramtion.spring.cinema.film.Film;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="acteurs")
@Getter
@Setter
@JsonIdentityInfo(generator = com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Acteur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nom;

    private String prenom;

    @ManyToMany(mappedBy = "acteurs")
    private List<Film> films = new ArrayList<>();
}
