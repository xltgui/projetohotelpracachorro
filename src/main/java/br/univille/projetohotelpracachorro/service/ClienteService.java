package br.univille.projetohotelpracachorro.service;

import java.util.List;

import br.univille.projetohotelpracachorro.entity.Cliente;

public interface ClienteService {
    List<Cliente> getAll();

    Cliente save(Cliente cliente);
    Cliente findById(long id);

    void delete(long id);

    List<Cliente> findByNome(String nome);
}
