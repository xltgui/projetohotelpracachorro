package br.univille.projetohotelpracachorro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.univille.projetohotelpracachorro.entity.Cachorro;

@Repository
public interface CachorroRepository extends JpaRepository<Cachorro, Long> {
    List<Cachorro> findByNomeCachorroIgnoreCaseContaining(@Param("nomeCachorro") String nomeCachorro);

    //List<Cachorro> findByCachorroById(@Param("id")long id);

}
