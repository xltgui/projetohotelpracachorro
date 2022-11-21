package br.univille.projetohotelpracachorro.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetohotelpracachorro.entity.Funcionario;
import br.univille.projetohotelpracachorro.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;
    

    @GetMapping
    public ModelAndView index(){
        var listaFuncionarios = funcionarioService.getAtll();

        return new ModelAndView("funcionario/index", "listaFuncionarios", listaFuncionarios);
        
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var funcionario = new Funcionario();
        
        return new ModelAndView("funcionario/form", "funcionario", funcionario);
    }

    @PostMapping(params = "form")
    public ModelAndView save(Funcionario funcionario){
        funcionarioService.save(funcionario);
        return new ModelAndView("redirect:/funcionarios");
    }

    @GetMapping("alterar/{id}")
        public ModelAndView alterar(@PathVariable("id") long id){
            var umFuncionario = funcionarioService.findById(id);

            return new ModelAndView("funcionario/form", "funcionario", umFuncionario);
        }

    @GetMapping("delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        funcionarioService.delete(id);
        return new ModelAndView("redirect:/funcionarios");
    }

    
}

