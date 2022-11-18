package br.univille.projetohotelpracachorro.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetohotelpracachorro.entity.Cliente;
import br.univille.projetohotelpracachorro.service.CachorroService;
import br.univille.projetohotelpracachorro.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CachorroService cachorroService;
    

    @GetMapping
    public ModelAndView index(){
        var listaCliente = clienteService.getAll();
        return new ModelAndView("cliente/index", "listaClientes", listaCliente);

    }
    
    @GetMapping("/novo")
    public ModelAndView novo(){
        var cliente = new Cliente();

        var listaCachorros = cachorroService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("cliente", cliente);
        dados.put("listaCachorros", listaCachorros);
        return new ModelAndView("cliente/form", dados);
        
    }
}
