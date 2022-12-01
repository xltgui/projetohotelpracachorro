package br.univille.projetohotelpracachorro.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import br.univille.projetohotelpracachorro.entity.Cachorro;
import br.univille.projetohotelpracachorro.entity.Cliente;
import br.univille.projetohotelpracachorro.entity.Funcionario;
import br.univille.projetohotelpracachorro.entity.Servico;

public class ReservaDTO {
    private long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataEntrada;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataSaida;

    private List<Cliente> listaClientes = new ArrayList<>();
    private List<Servico> listaServicos = new ArrayList<>();

    private List<Cachorro> listaCachorros = new ArrayList<>(); 
    
    
    private Cachorro cachorro = new Cachorro();

    

    private List<Funcionario> listaAtendentes;

    private Servico novoServico;

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

    public Servico getNovoServico() {
        return novoServico;
    }

    public void setNovoServico(Servico novoServico) {
        this.novoServico = novoServico;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public List<Cachorro> getListaCachorros() {
        return listaCachorros;
    }

    public void setListaCachorros(List<Cachorro> listaCachorros) {
        this.listaCachorros = listaCachorros;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
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
