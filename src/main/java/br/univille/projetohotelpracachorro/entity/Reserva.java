package br.univille.projetohotelpracachorro.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MMM-dd")
    private Date dataEntrada;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MMM-dd")
    private Date dataSaida;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    private Cachorro cachorro;

    @OneToOne(cascade = CascadeType.ALL)
    private Cliente cliente;
           
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Servicos> listaServicos = new ArrayList<>();
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Funcionario atendente;

    public float totalReserva(){
        return 0;
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

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }


    public Cachorro getCachorro() {
        return cachorro;
    }

    public void setCachorro(Cachorro cachorro) {
        this.cachorro = cachorro;
    }

    public List<Servicos> getListaServicos() {
        return listaServicos;
    }

    public void setListaServicos(List<Servicos> listaServicos) {
        this.listaServicos = listaServicos;
    }

    
}
