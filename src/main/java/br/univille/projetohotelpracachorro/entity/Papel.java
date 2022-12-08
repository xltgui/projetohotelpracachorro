package br.univille.projetohotelpracachorro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Papel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String papel;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getPapel() {
        return papel;
    }
    public void setPapel(String papel) {
        this.papel = papel;
    }

}
