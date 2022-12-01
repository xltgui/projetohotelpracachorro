package br.univille.projetohotelpracachorro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.univille.projetohotelpracachorro.entity.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository <Funcionario, Long> {
    List<Funcionario> findByNomeIgnoreCaseContaining(@Param("nome") String nome);
}
