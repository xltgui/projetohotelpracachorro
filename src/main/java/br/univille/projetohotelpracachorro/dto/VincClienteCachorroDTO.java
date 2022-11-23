package br.univille.projetohotelpracachorro.dto;

import java.util.ArrayList;
import java.util.List;

import br.univille.projetohotelpracachorro.entity.Cachorro;

public class VincClienteCachorroDTO {
    
	private long id;
    private String nome;
    private String CPF;
    private String telefone;
    private List<Cachorro> listaCachorros = new ArrayList<>();
    private Cachorro novoCachorro;
    
    public Cachorro getNovoCachorro() {
		return novoCachorro;
	}
    public void setNovoCachorro(Cachorro novoCachorro) {
		this.novoCachorro = novoCachorro;
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
