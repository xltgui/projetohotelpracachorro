package br.univille.projetohotelpracachorro.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetohotelpracachorro.dto.ReservaDTO;
import br.univille.projetohotelpracachorro.entity.Cachorro;
import br.univille.projetohotelpracachorro.entity.Cliente;
import br.univille.projetohotelpracachorro.entity.Reserva;
import br.univille.projetohotelpracachorro.entity.Servico;
import br.univille.projetohotelpracachorro.service.CachorroService;
import br.univille.projetohotelpracachorro.service.ClienteService;
import br.univille.projetohotelpracachorro.service.FuncionarioService;
import br.univille.projetohotelpracachorro.service.ReservaService;
import br.univille.projetohotelpracachorro.service.ServicoService;

@Controller
@RequestMapping("/reservas")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CachorroService cachorroService;

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ModelAndView index() {
        var listaReservas = reservaService.getAll();
        return new ModelAndView("reserva/index", "listaReservas", listaReservas);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var novaReserva = new ReservaDTO();

        var listaAtendentes = funcionarioService.getAll();
        var listaClientes = clienteService.getAll();
        var listaCachorros = cachorroService.getAll();
        var listaServicos = servicoService.getAll();
        HashMap<String, Object> dados = new HashMap<>();

        dados.put("listaClientes", listaClientes);
        dados.put("reserva", novaReserva);
        dados.put("listaCachorros", listaCachorros);
        dados.put("listaServicos", listaServicos);
        dados.put("listaAtendentes", listaAtendentes);
        return new ModelAndView("reserva/form", dados);
    }
    
    @GetMapping("/novo/{idcliente}")
    public ModelAndView novoComCliente(@PathVariable(name = "idcliente") long idcliente) {
        var novaReserva = new ReservaDTO();

        var listaAtendentes = funcionarioService.getAll();
        var listaClientes = new ArrayList<Cliente>();
        var clientSelecionado = clienteService.findClienteById(idcliente);
        listaClientes.add(clientSelecionado);
        var listaCachorros = clientSelecionado.getListaCachorros();
        var listaServicos = servicoService.getAll();
        HashMap<String, Object> dados = new HashMap<>();

        dados.put("listaClientes", listaClientes);
        dados.put("reserva", novaReserva);
        dados.put("listaCachorros", listaCachorros);
        dados.put("listaServicos", listaServicos);
        dados.put("listaAtendentes", listaAtendentes);
        return new ModelAndView("reserva/form", dados);
    }

    
    @PostMapping(params = "concluir")
      public ModelAndView form() {

      return new ModelAndView("redirect:/reservas");
    }
    
    @GetMapping("/agendada")
    public ModelAndView reservaAgendada() {
        return new ModelAndView("reserva/confirmacao");

    }
     

    @PostMapping(params = "confirmar")
    public ModelAndView confirmar(ReservaDTO reserva) {
        reservaService.save(reserva);
        return new ModelAndView("redirect:/reservas/agendada");
    }

    @PostMapping(params = "vincservico")
    public ModelAndView vincularServico(ReservaDTO reserva) {
        reserva.getListaServicos().add(reserva.getNovoServico());
        reserva.setNovoServico(null);

        var listaServicos = servicoService.getAll();
        var listaClientes = clienteService.getAll();
        var listaAtendentes = funcionarioService.getAll();
        var listaCachorros = cachorroService.getAll();
        //var listaReservas = reservaService.getAll();

        HashMap<String, Object> dados = new HashMap<>();
        //dados.put("listaReservas", listaReservas);
        dados.put("listaAtendentes", listaAtendentes);
        dados.put("listaClientes", listaClientes);
        dados.put("listaServicos", listaServicos);
        dados.put("listaCachorros", listaCachorros);
        dados.put("reserva", reserva);
        dados.put("novoServico", new Servico());
        return new ModelAndView("reserva/form", dados);
    }

    /*@PostMapping(params = "carregaCachorros")
    public ModelAndView carregarCachorros(){

        Cachorro cachorro = new Cachorro();
        var listaServicos = servicoService.getAll();
        var listaClientes = clienteService.getAll();
        var listaAtendentes = funcionarioService.getAll();
        var listaCachorros = cachorroService.findbyCachorroId(cachorro.getId());
        //var listaReservas = reservaService.getAll();

        HashMap<String, Object> dados = new HashMap<>();
        //dados.put("listaReservas", listaReservas);
        dados.put("listaAtendentes", listaAtendentes);
        dados.put("listaClientes", listaClientes);
        dados.put("listaServicos", listaServicos);
        dados.put("listaCachorros", listaCachorros);
        //dados.put("reserva", reserva);
        //dados.put("novoServico", new Servico());
        return new ModelAndView("reserva/form", dados);
    }*/

    @PostMapping(params = "removeservico")
    public ModelAndView removerServico(@RequestParam("removeservico") int index,
            ReservaDTO reserva) {
        reserva.getListaServicos().remove(index);
        
        //var listaReservas = reservaService.getAll();
        var listaServicos = servicoService.getAll();
        var listaAtendentes = funcionarioService.getAll();
        var listaClientes = clienteService.getAll();
        var listaCachorros = cachorroService.getAll();

        HashMap<String, Object> dados = new HashMap<>();
        //dados.put("listaReservas", listaReservas);
        dados.put("listaAtendentes", listaAtendentes);
        dados.put("listaClientes", listaClientes);
        dados.put("listaCachorros", listaCachorros);
        dados.put("reserva", reserva);
        dados.put("listaServicos", listaServicos);
        dados.put("novoServico", new Servico());
        return new ModelAndView("reserva/form", dados);
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id) {
        ReservaDTO umaReserva = new ReservaDTO();
        umaReserva = reservaService.findById(id);

        var listaAtendentes = funcionarioService.getAll();
        var listaClientes = clienteService.getAll();
        var listaCachorros = cachorroService.getAll();
        var listaServicos = servicoService.getAll();
        HashMap<String, Object> dados = new HashMap<>();

        dados.put("reserva", umaReserva);
        dados.put("listaClientes", listaClientes);
        dados.put("listaAtendentes", listaAtendentes);
        dados.put("listaServicos", listaServicos);
        dados.put("listaCachorros", listaCachorros);
        dados.put("novaReserva", new Reserva());
        return new ModelAndView("reserva/form", dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id) {
        reservaService.delete(id);

        return new ModelAndView("redirect:/reservas");
    }

    

}
