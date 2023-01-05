package fr.kira.foramtion.spring.cinema.seance;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SeanceService {

    private final SeanceJpaRepository jpaRepository;

    public SeanceService(SeanceJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public Seance save(Seance seance) {
        return jpaRepository.save(seance);
    }

    public List<Seance> findAll() {
        return jpaRepository.findAll();
    }

    public Seance findById(Integer integer) {
        return jpaRepository.findById(integer).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deleteById(Integer integer) {
        jpaRepository.deleteById(integer);
    }
}
