package br.univille.projetohotelpracachorro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import br.univille.projetohotelpracachorro.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository <Funcionario, Long> {
    List<Funcionario> findByNomeIgnoreCaseContaining(@Param("nome") String nome);
}
