package br.unicesumar.escoladeti.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Entity 
public class Cidade extends SuperEntidade {
    
    private int codigoIbge;
    
    @NotEmpty
    private String nome;
    
    /*@NotNull
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "UF_FK")
    private Uf uf;*/
    
    public Cidade() {
    }

    /*public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }*/

    public Cidade(int codigoIbge, String nome, String sigla, Uf uf) {
        this.codigoIbge = codigoIbge;
        this.nome = nome;
        //this.uf = uf;
    }
    

    public int getCodigoIbge() {
        return codigoIbge;
    }

    public void setCodigoIbge(int codigoIbge) {
        this.codigoIbge = codigoIbge;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
} 
