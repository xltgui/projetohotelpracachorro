package br.univille.projetohotelpracachorro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Servicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String servico;
    private float valorAdicional;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getServico() {
        return servico;
    }
    public void setServico(String servico) {
        this.servico = servico;
    }
    public float getValorAdicional() {
        return valorAdicional;
    }
    public void setValorAdicional(float valorAdicional) {
        this.valorAdicional = valorAdicional;
    }
    

}
