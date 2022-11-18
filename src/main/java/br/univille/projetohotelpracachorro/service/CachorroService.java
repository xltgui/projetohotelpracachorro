package br.univille.projetohotelpracachorro.service;

import java.util.List;

import br.univille.projetohotelpracachorro.entity.Cachorro;

public interface CachorroService {
    List<Cachorro> getAll();

    Cachorro save(Cachorro cachorro);
    Cachorro findById(long id);

    void delete(long id);

    List<Cachorro> findByNome(String nome);
}
