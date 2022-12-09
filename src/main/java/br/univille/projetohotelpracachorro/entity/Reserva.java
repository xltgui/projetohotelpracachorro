package br.univille.projetohotelpracachorro.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataEntrada;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataSaida;

    // long diasPermanecentes = ChronoUnit.DAYS.between(this.getDataEntrada(),
    // this.getDataSaida());

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Cachorro cachorro = new Cachorro();
    
    /*@ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "listaCachorros_reservas")
    private List<Cachorro> listaCachorros = new ArrayList<>();*/ 

    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "listaClientes_reservas")
    private List<Cliente> listaClientes = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "listaServicos_reservas")
    private List<Servico> listaServicos = new ArrayList<>();

    @ManyToMany
    @JoinColumn(name = "funcionarios_reservas")
    private List<Funcionario> listaAtendentes = new ArrayList<>();

    public long getDiasPermanecentes() {
        long diasPermanecentes = ChronoUnit.DAYS.between(this.getDataEntrada(), this.getDataSaida());
        return diasPermanecentes;
    }

    public Cachorro getCachorro() {
        return cachorro;
    }

    public void setCachorro(Cachorro cachorro) {
        this.cachorro = cachorro;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaCliente) {
        this.listaClientes = listaCliente;
    }

    public List<Funcionario> getListaAtendentes() {
        return listaAtendentes;
    }

    public void addServico(Servico servico) {
        this.listaServicos.add(servico);
    }

    public float getTotalReserva(){   
        float valor = 0;
        if(getCachorro() != null){   
            if(getCachorro().getPeso() >= 0 && getCachorro().getPeso() <= 15 ){
                valor = 55;
            }
            if(getCachorro().getPeso() >= 16 && getCachorro().getPeso() <= 25 ){
                valor = 65;
            }
            if(getCachorro().getPeso() >= 26){
                valor = 75;
            }
        }
        var totalServ = 0;
        for(var umServ:listaServicos){
            totalServ += umServ.getValorServico();
        }
        return totalServ + (valor * getDiasPermanecentes());
    }

    public void setListaAtendentes(List<Funcionario> listaAtendentes) {
        this.listaAtendentes = listaAtendentes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public List<Servico> getListaServicos() {
        return listaServicos;
    }

    public void setListaServicos(List<Servico> listaServicos) {
        this.listaServicos = listaServicos;
    }

    /*public List<Cachorro> getListaCachorros() {
        return listaCachorros;
    }

    public void setListaCachorros(List<Cachorro> listaCachorros) {
        this.listaCachorros = listaCachorros;
    }*/

}
