package br.univille.projetohotelpracachorro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projetohotelpracachorro.entity.Servico;
import br.univille.projetohotelpracachorro.repository.ServicoRepository;
import br.univille.projetohotelpracachorro.service.ServicoService;

@Service
public class ServicoServiceImpl implements ServicoService{
    
    @Autowired
    private ServicoRepository repositorio;


    @Override
    public List<Servico> getAll() {
        
        return repositorio.findAll();
    }

    @Override
    public Servico save(Servico servico) {
        return repositorio.save(servico);
    }

    @Override
    public Servico findById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new Servico();
    }


    @Override
    public List<Servico> findByNome(String nome) {
        return repositorio.findByNomeIgnoreCaseContaining(nome);
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }
    
}
