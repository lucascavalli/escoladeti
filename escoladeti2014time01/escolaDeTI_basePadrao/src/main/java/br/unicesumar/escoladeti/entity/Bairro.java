package br.unicesumar.escoladeti.entity;

import br.unicesumar.escoladeti.entity.SuperEntidade;
import br.unicesumar.escoladeti.types.TipoBairro;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Bairro extends SuperEntidade{
    
    @NotEmpty
    private String nome;
    
    @NotNull
    @Column
    @Enumerated(EnumType.STRING)
    private TipoBairro tipo;
    
    @OneToMany(mappedBy = "bairro")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<FaixaDeNumero> faixasDeNumero = new ArrayList<FaixaDeNumero>();

    public List<FaixaDeNumero> getFaixasDeNumero() {
        return faixasDeNumero;
    }

    public void setFaixasDeNumero(List<FaixaDeNumero> faixasDeNumero) {
        this.faixasDeNumero = faixasDeNumero;
    }

    public TipoBairro getTipo() {
        return tipo;
    }

    public void setTipo(TipoBairro tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
