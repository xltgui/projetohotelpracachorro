package br.univille.projetohotelpracachorro.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetohotelpracachorro.dto.ReservaDTO;
import br.univille.projetohotelpracachorro.entity.Reserva;
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
    public ModelAndView index(){
        var listaReservas = reservaService.getAll();
        return new ModelAndView("reserva/index", "listaReservas", listaReservas);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var novaReserva = new ReservaDTO();

        var listaAtendentes = funcionarioService.getAtll();
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

    @PostMapping(params = "form")
    public ModelAndView save(ReservaDTO reserva){
        System.out.println(reserva.getDataEntrada());
        reservaService.save(reserva);
        return new ModelAndView("redirect:/reservas");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id) {
        ReservaDTO umaReserva = new ReservaDTO();
        umaReserva = reservaService.findById(id);
        
        var listaAtendentes = funcionarioService.getAtll();
        var listaClientes = clienteService.getAll();
        var listaCachorros = cachorroService.getAll();
        var listaServicos = servicoService.getAll();
        HashMap<String, Object> dados = new HashMap<>();

        dados.put("reserva", umaReserva);
        dados.put("listaClientes", listaClientes);
        dados.put("listaAtendentes", listaAtendentes);
        dados.put("listaServicos", listaServicos);
        dados.put("listaCachorros", listaCachorros);
        return new ModelAndView("reserva/form", dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id) {
        reservaService.delete(id);

        return new ModelAndView("redirect:/reservas");
    }
    
}
