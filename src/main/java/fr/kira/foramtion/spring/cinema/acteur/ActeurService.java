package fr.kira.foramtion.spring.cinema.acteur;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.kira.foramtion.spring.cinema.acteur.dto.ActeurCompletDto;
import fr.kira.foramtion.spring.cinema.acteur.dto.ActeurSansFilmDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActeurService {

    private final ActeurJpaRepository jpaRepository;
    private final ObjectMapper mapper;

    public ActeurService(ActeurJpaRepository jpaRepository, ObjectMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    public ActeurCompletDto save(Acteur entity) {
        Acteur entitySauvegarder = jpaRepository.save(entity);
        return mapper.convertValue(entitySauvegarder, ActeurCompletDto.class);
    }

    public ActeurCompletDto findById(Integer integer) {
        Acteur entity = jpaRepository.findById(integer).orElseThrow();
        return mapper.convertValue(entity, ActeurCompletDto.class);
    }

    public void deleteById(Integer integer) {
        jpaRepository.deleteById(integer);
    }

    public List<ActeurSansFilmDto> findAll() {
        List<Acteur> entities = jpaRepository.findAll();
        return entities.stream().map(acteur -> mapper.convertValue(acteur, ActeurSansFilmDto.class)).toList();
    }

    public Acteur findOrInsert(Acteur acteur){
        return this.jpaRepository.findById(acteur.getId()).orElseGet(()->this.jpaRepository.save(acteur));
    }
}
