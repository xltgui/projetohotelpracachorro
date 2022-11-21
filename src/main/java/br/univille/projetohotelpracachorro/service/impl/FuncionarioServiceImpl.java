package br.univille.projetohotelpracachorro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projetohotelpracachorro.entity.Funcionario;
import br.univille.projetohotelpracachorro.repository.FuncionarioRepository;
import br.univille.projetohotelpracachorro.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
    
    @Autowired
    private FuncionarioRepository repositorio;

    @Override
    public List<Funcionario> getAtll() {
        return repositorio.findAll();
    }

    @Override
    public Funcionario save(Funcionario funcionario) {
        return repositorio.save(funcionario);
    }

    @Override
    public Funcionario findById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new Funcionario();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
        
    }

    @Override
    public List<Funcionario> findByNome(String nome) {
        return repositorio.findByNomeIgnoreCaseContaining(nome);
    }
    
}
