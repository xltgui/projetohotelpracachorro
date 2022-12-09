package br.univille.projetohotelpracachorro.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/*enum RoleType{
    ADMIN,
    USUARIO
}*/

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // private RoleType role;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Papel> listaPapeis = new ArrayList<>();

    private String usuario;
    private String senha;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Papel> getListaPapeis() {
        return listaPapeis;
    }

    public void setListaPapeis(List<Papel> listaPapeis) {
        this.listaPapeis = listaPapeis;
    }

}