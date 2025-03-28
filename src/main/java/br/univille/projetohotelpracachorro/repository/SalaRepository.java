package br.univille.projetohotelpracachorro.repository;

import br.univille.projetohotelpracachorro.dto.SalaDTO;
import br.univille.projetohotelpracachorro.entity.Cachorro;
import br.univille.projetohotelpracachorro.entity.ensalamento.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaRepository  extends JpaRepository<Sala, Long> {
    //List<Sala> findByNomeSalaIgnoreCaseContaining(@Param("nomeSala") String nomeSala);
}
