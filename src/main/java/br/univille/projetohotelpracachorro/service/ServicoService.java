package br.univille.projetohotelpracachorro.service;

import java.util.List;

import br.univille.projetohotelpracachorro.entity.Servico;


public interface ServicoService {
    List<Servico> getAll();

    Servico save(Servico servico);

    Servico findById(long id);
    
    List<Servico> findByNome(String nome);
    
    void delete (long id);
}
