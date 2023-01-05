package fr.kira.foramtion.spring.cinema.realisateur;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.kira.foramtion.spring.cinema.realisateur.dto.RealisateurCompletDto;
import fr.kira.foramtion.spring.cinema.realisateur.dto.RealisateurSansFilmDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealisateurService {

    private final RealisateurJpaRepository jpaRepository;
    private final ObjectMapper mapper;

    public RealisateurService(RealisateurJpaRepository jpaRepository, ObjectMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    public RealisateurCompletDto save(Realisateur entity) {
        Realisateur entitySauvegarder = jpaRepository.save(entity);
        return mapper.convertValue(entitySauvegarder, RealisateurCompletDto.class);
    }

    public RealisateurCompletDto findById(Integer integer) {
        Realisateur entity = jpaRepository.findById(integer).orElseThrow();
        return mapper.convertValue(entity, RealisateurCompletDto.class);
    }

    public void deleteById(Integer integer) {
        jpaRepository.deleteById(integer);
    }

    public List<RealisateurSansFilmDto> findAll() {
        List<Realisateur> entities = jpaRepository.findAll();
        return entities.stream().map(acteur -> mapper.convertValue(acteur, RealisateurSansFilmDto.class)).toList();
    }
}
