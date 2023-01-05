package fr.kira.foramtion.spring.cinema.seance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SeanceJpaRepository extends JpaRepository<Seance, Integer> {
    List<Seance> findByDate(LocalDate date);
}
