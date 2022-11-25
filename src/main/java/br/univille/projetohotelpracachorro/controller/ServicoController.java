package br.univille.projetohotelpracachorro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetohotelpracachorro.entity.Servico;
import br.univille.projetohotelpracachorro.repository.ServicoRepository;
import br.univille.projetohotelpracachorro.service.ServicoService;

@Controller
@RequestMapping("/servicos")
public class ServicoController {
    @Autowired
    private ServicoService servicoService;
    
    @GetMapping
    public ModelAndView index(){
        var listaServicos = servicoService.getAll();

        return new ModelAndView("servico/index", "listaServicos", listaServicos);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var novoServico = new Servico();
        return new ModelAndView("servico/form", "servico", novoServico);
    }
}
