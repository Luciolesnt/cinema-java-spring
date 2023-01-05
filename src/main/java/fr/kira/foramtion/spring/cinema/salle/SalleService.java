package fr.kira.foramtion.spring.cinema.salle;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SalleService {

    private final SalleJpaRepository jpaRepository;

    public SalleService(SalleJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public Salle save(Salle salle) {
        return jpaRepository.save(salle);
    }

    public List<Salle> findAll() {
        return jpaRepository.findAll();
    }

    public Salle findById(Integer integer) {
        return jpaRepository.findById(integer).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deleteById(Integer integer) {
        jpaRepository.deleteById(integer);
    }
}
