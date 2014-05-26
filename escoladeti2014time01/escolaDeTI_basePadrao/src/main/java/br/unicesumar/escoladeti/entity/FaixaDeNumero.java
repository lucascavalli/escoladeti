package br.unicesumar.escoladeti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class FaixaDeNumero extends SuperEntidade {
    
    @NotNull
    private int numeroInicial;
    
    @NotNull
    private int numeroFinal;
    
    @NotEmpty
    private String cep;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "bairro_fk")
    private Bairro bairro;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "logradouro_fk")
    private Logradouro logradouro;

    public int getNumeroInicial() {
        return numeroInicial;
    }

    public void setNumeroInicial(int numeroInicial) {
        this.numeroInicial = numeroInicial;
    }

    public int getNumeroFinal() {
        return numeroFinal;
    }

    public void setNumeroFinal(int numeroFinal) {
        this.numeroFinal = numeroFinal;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    
}
