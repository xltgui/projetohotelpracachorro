package br.univille.projetohotelpracachorro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetohotelpracachorro.entity.Cliente;
import br.univille.projetohotelpracachorro.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    

    @GetMapping
    public ModelAndView index(){
        var listaCliente = clienteService.getAll();
        return new ModelAndView("cliente/index", "listaClientes", listaCliente);

    }

}
