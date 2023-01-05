package fr.kira.foramtion.spring.cinema.seance;

import org.springframework.data.jpa.repository.JpaRepository;
public interface SeanceJpaRepository extends JpaRepository<Seance, Integer> {
}
