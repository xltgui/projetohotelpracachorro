package br.univille.projetohotelpracachorro.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.hibernate.validator.internal.engine.validationcontext.ParameterExecutableValidationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetohotelpracachorro.entity.Cachorro;
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
    public ModelAndView index() {
        var listaCliente = clienteService.getAll();
        return new ModelAndView("cliente/index", "listaClientes", listaCliente);

    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var cliente = new Cliente();

        var listaCachorros = cachorroService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("cliente", cliente);
        dados.put("listaDisponiveis", listaCachorros);
        dados.put("novoCachorro", new Cachorro());
        return new ModelAndView("cliente/form", dados);

    }

    @PostMapping(params = "save")
    public ModelAndView save(Cliente cliente) {
        clienteService.save(cliente);
        return new ModelAndView("redirect:/clientes");
    }

    @PostMapping(params = "vincdog")
    public ModelAndView vincularDog(Cliente cliente, Cachorro novoCachorro) {
        cliente.getListaCachorros().add(novoCachorro);

        var listaClientes = clienteService.getAll();
        var listaCachorros = cachorroService.getAll();
        HashMap<String, Object> dados = new HashMap<>();

        dados.put("listaClientes", listaClientes);
        dados.put("cliente", cliente);
        dados.put("listaDisponiveis", listaCachorros);
        dados.put("novoCachorro", new Cachorro());
        return new ModelAndView("cliente/form", dados);
    }

    @PostMapping(params = "removecachorro")
    public ModelAndView removerCachorro(@RequestParam("removecachorro") int index,
            Cliente cliente) {
        cliente.getListaCachorros().remove(index);

        var listaClientes = clienteService.getAll();
        var listaCachorros = cachorroService.getAll();
        HashMap<String, Object> dados = new HashMap<>();

        dados.put("listaClientes", listaClientes);
        dados.put("cliente", cliente);
        dados.put("listaCachorros", listaCachorros);
        dados.put("novoCachorro", new Cachorro());
        return new ModelAndView("cliente/form", dados);
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id) {
        var umCliente = clienteService.findById(id);
        var listaCachorros = cachorroService.getAll();
        HashMap<String, Object> dados = new HashMap<>();

        dados.put("cliente", umCliente);
        dados.put("listaCachorros", listaCachorros);
        return new ModelAndView("cliente/form", dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id) {
        clienteService.delete(id);

        return new ModelAndView("redirect:/clientes");
    }
}
