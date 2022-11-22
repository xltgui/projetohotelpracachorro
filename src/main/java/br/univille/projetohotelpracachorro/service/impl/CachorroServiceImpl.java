package br.univille.projetohotelpracachorro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projetohotelpracachorro.entity.Cachorro;
import br.univille.projetohotelpracachorro.repository.CachorroRepository;
import br.univille.projetohotelpracachorro.service.CachorroService;

@Service
public class CachorroServiceImpl implements CachorroService {
    @Autowired
    private CachorroRepository repositorio;

    @Override
    public List<Cachorro> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Cachorro save(Cachorro cachorro) {
        return repositorio.save(cachorro);
    }

    @Override
    public Cachorro findById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new Cachorro();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
        
    }

    @Override
    public List<Cachorro> findByNome(String nome) {
        return repositorio.findByNomeCachorroIgnoreCaseContaining(nome);
    }

    
}
