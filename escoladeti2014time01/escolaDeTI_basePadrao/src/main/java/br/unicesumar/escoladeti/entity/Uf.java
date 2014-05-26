package br.unicesumar.escoladeti.entity;

import javax.persistence.*;
import org.hibernate.validator.constraints.NotEmpty;

@Entity 
public class Uf extends SuperEntidade {
    
    private int codigoIbge;
    
    @NotEmpty
    private String nome;

    public Uf() {
    }

    public Uf(int codigoIbge, String nome, String sigla) {
        this.codigoIbge = codigoIbge;
        this.nome = nome;
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
