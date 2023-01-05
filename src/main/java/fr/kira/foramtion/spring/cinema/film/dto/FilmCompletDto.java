package fr.kira.foramtion.spring.cinema.film.dto;

import fr.kira.foramtion.spring.cinema.acteur.dto.ActeurSansFilmDto;
import fr.kira.foramtion.spring.cinema.realisateur.dto.RealisateurSansFilmDto;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class FilmCompletDto {
    private Integer Id;
    private String titre;
    private String resume;
    private int duree;
    private LocalDate dateSortie;
    private List<ActeurSansFilmDto> acteurs = new ArrayList<>();
    private List<RealisateurSansFilmDto> realisateurs = new ArrayList<>();
}
