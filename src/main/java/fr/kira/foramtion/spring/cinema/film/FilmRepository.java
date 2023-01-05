package fr.kira.foramtion.spring.cinema.film;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository pour les films
 * Cette classe permet de gérer les films dans la bdd
 */
@Repository
public class FilmRepository {
    private final EntityManager entityManager;

    public FilmRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Sauvegarde un nouveau film dans la base de données
     * @param film a sauvegarder
     * @return le film avec son id
     */
    public Film save(Film film){
        // insération automatique du film dans la bdd (pas besoin d'écrire la requête sql
        entityManager.persist(film);
        // Synchroniser l'instance film avec la bdd. Ajoute donc l'id.
        entityManager.flush();
        return film;
    }

    /**
     * Retourne le film portant l'id
     * @param id du film recherché
     * @return le film portant l'id
     */
    public Film findById(Integer id){
        // Equivalent à SELECT * FROM films WHERE films.id == {id}
        return entityManager.find(Film.class, id);
    }

    /**
     * Retourne la liste de l'ensemble des films
     * @return la liste de l'ensemble des films
     */
    public List<Film> findAll(){
        TypedQuery<Film> query = entityManager.createQuery("SELECT f FROM films f", Film.class);
        return query.getResultList();
    }

    /**
     * Met a jour l'entité dans la bdd
     * @param film a metre a jour
     * @return film mis a jour
     */
    public Film update(Film film){
        entityManager.merge(film);
        return film;
    }

    /**
     * Supprime le film portant l'id
     * @param id du film a supprimer
     */
    public void deleteById(Integer id){
        Film film = this.findById(id);
        entityManager.remove(film);
    }
}
