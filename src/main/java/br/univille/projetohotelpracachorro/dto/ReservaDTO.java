package br.univille.projetohotelpracachorro.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import br.univille.projetohotelpracachorro.entity.Cachorro;
import br.univille.projetohotelpracachorro.entity.Cliente;
import br.univille.projetohotelpracachorro.entity.Funcionario;
import br.univille.projetohotelpracachorro.entity.Servico;

public class ReservaDTO {
    private long id;
    
    @DateTimeFormat(pattern = "yyyy-MMM-dd")
    private Date dataEntrada;
    
    private Cachorro cachorro;
    private List<Cliente> listaClientes = new ArrayList<>();
    private List<Servico> listaServicos = new ArrayList<>();
    private List<Funcionario> listaAtendentes;

    public List<Funcionario> getListaAtendentes() {
        return listaAtendentes;
    }

    public void setListaAtendentes(List<Funcionario> listaAtendentes) {
        this.listaAtendentes = listaAtendentes;
    }

    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Cachorro getCachorro() {
        return cachorro;
    }

    public void setCachorro(Cachorro cachorro) {
        this.cachorro = cachorro;
    }


    public List<Servico> getListaServicos() {
        return listaServicos;
    }

    public void setListaServicos(List<Servico> listaServicos) {
        this.listaServicos = listaServicos;
    }


    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
}
