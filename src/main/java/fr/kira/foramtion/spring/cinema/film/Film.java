package fr.kira.foramtion.spring.cinema.film;

// jakarta == JEE
// jakarta.persistance == JPA
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import fr.kira.foramtion.spring.cinema.acteur.Acteur;
import fr.kira.foramtion.spring.cinema.realisateur.Realisateur;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Ici on utilise la norme JEE JPA implémenté par l'ORM hibernate
 * JEE => ensemble des normes Java pour les applications d'entreprises
 * JPA => norme JEE pour la gestion de la persistance des données
 * Hibernate => Implémentation la plus courante de JPA pour faire un ORM
 */
// ORM = Object Relationnal Mapping ici hibernate
@Entity // Définie que la classe représente une entité dans la base de données
@Table(name="films") // permet de définir dans quelle table ce trouve cette entité
@Getter // Ajoute un getter pour chaque attribut
@Setter // Ajoute un setter pour chaque attribut
@AllArgsConstructor
@NoArgsConstructor// Ajoute un constructeur sans paramètre
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Film {
    @Id // Définie que le champ représente la clé primaire de la table
    @GeneratedValue(strategy = GenerationType.AUTO) // permet de générer l'id automatiquement
    private Integer id;

    @Column(name= "titre", nullable = false)
    private String titre;

    private LocalDate date_sortie;

    private int duree;

    @Column(length = 500)
    private String resume;

    @ManyToMany() // fais référence à l'attribut films de la classe Acteur
    @JoinTable(
            name = "acteur_film", // nom de la table de jointure
            joinColumns = @JoinColumn(name = "id_film"), // nom de la colonne de la table courante
            inverseJoinColumns = @JoinColumn(name="id_acteur") // nom de la colonne pour les acteurs
    )
    private List<Acteur> acteurs = new ArrayList();

    @ManyToMany()
    @JoinTable(
            name = "realisateur_film",
            inverseJoinColumns = @JoinColumn(name = "id_realisateur"),
            joinColumns = @JoinColumn(name = "id_film")
    )
    private List<Realisateur> realisateurs = new ArrayList();
}
