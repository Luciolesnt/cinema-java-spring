package fr.kira.foramtion.spring.cinema.ticket;

import fr.kira.foramtion.spring.cinema.seance.Seance;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="tickets")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomClient;

    private int nombrePlaces;

    @ManyToOne
    @JoinColumn(name="seance_id")
    private Seance seance;
}
