package fr.kira.foramtion.spring.cinema.salle;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="salles")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private int numero;

    private int capacite;

}
