package br.univille.projetohotelpracachorro.controller;

import br.univille.projetohotelpracachorro.dto.ReservaDTO;
import br.univille.projetohotelpracachorro.dto.SalaDTO;
import br.univille.projetohotelpracachorro.entity.Cachorro;
import br.univille.projetohotelpracachorro.entity.Reserva;
import br.univille.projetohotelpracachorro.entity.ensalamento.Sala;
import br.univille.projetohotelpracachorro.service.SalaService;
import br.univille.projetohotelpracachorro.service.impl.SalaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
@RequestMapping("/ensalamento")
public class SalaController {
    @Autowired
    private SalaServiceImpl salaService;

    @GetMapping
    public ModelAndView index(){
        var listaSalas = salaService.getAll();

        return new ModelAndView("sala/index", "listaSalas", listaSalas);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var novaSala = new SalaDTO();
        return new ModelAndView("sala/form", "sala", novaSala);

    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") int id){
        var umaSala = salaService.findById(id);

        return new ModelAndView("sala/form", "sala", umaSala);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") int id){

        salaService.delete(id);

        return new ModelAndView("redirect:/ensalamento");
    }

}
