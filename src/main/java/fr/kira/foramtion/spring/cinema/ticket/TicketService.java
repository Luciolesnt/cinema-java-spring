package fr.kira.foramtion.spring.cinema.ticket;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TicketService {

    private final TicketJpaRepository jpaRepository;

    public TicketService(TicketJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public Ticket save(Ticket ticket) {
        return jpaRepository.save(ticket);
    }

    public List<Ticket> findAll() {
        return jpaRepository.findAll();
    }

    public Ticket findById(Integer integer) {
        return jpaRepository.findById(integer).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deleteById(Integer integer) {
        jpaRepository.deleteById(integer);
    }
}
