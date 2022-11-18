package br.univille.projetohotelpracachorro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetohotelpracachorro.entity.Cachorro;
import br.univille.projetohotelpracachorro.repository.CachorroRepository;
import br.univille.projetohotelpracachorro.service.CachorroService;

@Controller
@RequestMapping("/cachorros")
public class CachorroController {
    @Autowired
    private CachorroService cachorroService;
    
    @GetMapping
    public ModelAndView index(){
        var listaCachorros = cachorroService.getAll();

        return new ModelAndView("cachorro/index", "listaCachorros", listaCachorros);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var novoCachorro = new Cachorro();
        return new ModelAndView("cachorro/form", "cachorro", novoCachorro);
        
    }

}
