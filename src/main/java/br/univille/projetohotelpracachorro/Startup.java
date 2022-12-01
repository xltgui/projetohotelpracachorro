package br.univille.projetohotelpracachorro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.univille.projetohotelpracachorro.entity.Cachorro;
import br.univille.projetohotelpracachorro.entity.Cliente;
import br.univille.projetohotelpracachorro.entity.Funcionario;
import br.univille.projetohotelpracachorro.entity.Servico;
import br.univille.projetohotelpracachorro.repository.CachorroRepository;
import br.univille.projetohotelpracachorro.repository.FuncionarioRepository;
import br.univille.projetohotelpracachorro.repository.ServicoRepository;

@Component
public class Startup {

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private CachorroRepository cachorroRepository;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event){
            if(!servicoRepository.findById(1l).isPresent()){
                Servico servico = new Servico();
                servico.setId(1l);
                servico.setNome("Taxi dog");
                servico.setValorServico(35);
                
                servicoRepository.save(servico);
            }

            if(!servicoRepository.findById(2l).isPresent()){
                Servico servico = new Servico();
                servico.setId(2l);
                servico.setNome("Banho e tosa");
                servico.setValorServico(65);
                
                servicoRepository.save(servico);
            }

            if(!servicoRepository.findById(3l).isPresent()){
                Servico servico = new Servico();
                servico.setId(3l);
                servico.setNome("Medicação");
                servico.setValorServico(25);
                
                servicoRepository.save(servico);
            }

            if(!funcionarioRepository.findById(1l).isPresent()){
                Funcionario funcionario = new Funcionario();

                funcionario.setId(1l);
                funcionario.setFuncao("Atendente");
                funcionario.setNome("Guilherme");
                funcionario.setAvaliacao(5);

                funcionarioRepository.save(funcionario);
                
            }
            if(!cachorroRepository.findById(1l).isPresent()){
                Cachorro cachorro = new Cachorro();

                cachorro.setId(1l);
                cachorro.setNomeCachorro("lilica");
                cachorro.setPeso(2);

                cachorroRepository.save(cachorro);
                
            }



               
    }
}
