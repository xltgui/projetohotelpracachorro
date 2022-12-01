package br.univille.projetohotelpracachorro.service;

import java.util.List;

import br.univille.projetohotelpracachorro.entity.Funcionario;

public interface FuncionarioService {
    List<Funcionario> getAll();

    Funcionario save(Funcionario funcionario);

    Funcionario findById(long id);

    void delete (long id);

    List<Funcionario> findByNome(String nome);
}
