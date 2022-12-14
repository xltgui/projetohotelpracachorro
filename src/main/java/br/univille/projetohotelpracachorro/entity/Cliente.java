package br.univille.projetohotelpracachorro.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 1000, nullable = false)
    private String nome;
    private String CPF;
    private String telefone;
    

   
    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "cliente_id")
    private List<Cachorro> listaCachorros = new ArrayList<>(); 
    
    
    


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
    public String getCPF() {
        return CPF;
    }
    public List<Cachorro> getListaCachorros() {
        return listaCachorros;
    }
    public void setListaCachorros(List<Cachorro> listaCachorros) {
        this.listaCachorros = listaCachorros;
    }
    public void setCPF(String cPF) {
        CPF = cPF;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
