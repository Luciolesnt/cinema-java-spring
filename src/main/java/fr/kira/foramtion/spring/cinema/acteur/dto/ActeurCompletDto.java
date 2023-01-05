package fr.kira.foramtion.spring.cinema.acteur.dto;

import fr.kira.foramtion.spring.cinema.film.Film;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ActeurCompletDto {
    private Integer id;
    private String nom;
    private String prenom;
    private List<Film> films = new ArrayList<>();
}