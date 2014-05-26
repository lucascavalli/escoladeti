package br.unicesumar.escoladeti.entity;

import br.unicesumar.escoladeti.types.TipoLogradouro;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Logradouro extends SuperEntidade {
    
    @NotEmpty
    private String nome;
    
    @OneToMany(mappedBy = "logradouro")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<FaixaDeNumero> faixasDeNumero = new ArrayList<FaixaDeNumero>();
    
    @NotNull
    @Column
    @Enumerated(EnumType.STRING)
    private TipoLogradouro tipo;
    
    public TipoLogradouro getTipo() {
        return tipo;
    }

    public void setTipo(TipoLogradouro tipo) {
        this.tipo = tipo;
    }

    public List<FaixaDeNumero> getFaixasDeNumero() {
        return faixasDeNumero;
    }

    public void setFaixasDeNumero(List<FaixaDeNumero> faixasDeNumero) {
        this.faixasDeNumero = faixasDeNumero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
