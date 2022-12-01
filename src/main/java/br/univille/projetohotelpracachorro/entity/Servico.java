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
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Reserva reserva;

    public float getTotalReserva(){   
        float valor = 0;
        if(reserva.getCachorro() != null){   
            if(reserva.getCachorro().getPeso() >= 0 && reserva.getCachorro().getPeso() <= 15 ){
                valor = 55;
            }
            if(reserva.getCachorro().getPeso() >= 16 && reserva.getCachorro().getPeso() <= 25 ){
                valor = 65;
            }
            if(reserva.getCachorro().getPeso() >= 26){
                valor = 75;
            }
        }
        return (this.getValorServico() + valor) * reserva.getDiasPermanecentes();
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

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    

}
