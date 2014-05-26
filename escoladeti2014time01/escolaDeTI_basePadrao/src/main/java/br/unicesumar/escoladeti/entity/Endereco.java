package br.unicesumar.escoladeti.entity;

import javax.persistence.Entity;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Endereco extends SuperEntidade{
        @NotEmpty
	private String Cidade;
	
        @NotEmpty
	private String Uf;
        
	@NotEmpty
	private String Pais;
	
        @NotEmpty
	private String Logradouro;
        
        @NotEmpty
	private String Bairro;
        
	@NotEmpty
	private String Cep;
	
        @NotEmpty
	private String Numero;

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getUf() {
        return Uf;
    }

    public void setUf(String Uf) {
        this.Uf = Uf;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public String getLogradouro() {
        return Logradouro;
    }

    public void setLogradouro(String Logradouro) {
        this.Logradouro = Logradouro;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String Cep) {
        this.Cep = Cep;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }
}
