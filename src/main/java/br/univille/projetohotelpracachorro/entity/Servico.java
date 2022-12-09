package br.univille.projetohotelpracachorro.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String nome;
    private float valorServico;
    
    
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
   
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValorServico() {
        return valorServico;
    }

    public void setValorServico(float valorServico) {
        this.valorServico = valorServico;
    }

}
