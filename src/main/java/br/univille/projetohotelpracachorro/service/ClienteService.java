package br.univille.projetohotelpracachorro.service;

import java.util.List;

import br.univille.projetohotelpracachorro.dto.VincClienteCachorroDTO;
import br.univille.projetohotelpracachorro.entity.Cliente;

public interface ClienteService {
    List<Cliente> getAll();

    Cliente save(VincClienteCachorroDTO cliente);
    VincClienteCachorroDTO findById(long id);

    Cliente findClienteById(long id);

    void delete(long id);

    List<Cliente> findByNome(String nome);
}
