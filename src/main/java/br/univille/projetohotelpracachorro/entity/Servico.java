package br.univille.projetohotelpracachorro.entity;

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
    
    @ManyToOne
    private Cachorro cachorro;

    public float getTotalReserva(float valorServico){
        float valor = 0;
        if(cachorro.getPeso() >= 2 && cachorro.getPeso() <= 15 ){
            valor = 55;
        }
        if(cachorro.getPeso() >= 16 && cachorro.getPeso() <= 25 ){
            valor = 65;
        }
        if(cachorro.getPeso() >= 26 && cachorro.getPeso() <= 60 ){
            valor = 75;
        }

        return valor + valorServico;
    }
    
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

    public Cachorro getCachorro() {
        return cachorro;
    }

    public void setCachorro(Cachorro cachorro) {
        this.cachorro = cachorro;
    }
    

}
