package br.univille.projetohotelpracachorro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.univille.projetohotelpracachorro.entity.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
    List<Servico> findByNomeIgnoreCaseContaining(@Param("nome") String nome);
}
