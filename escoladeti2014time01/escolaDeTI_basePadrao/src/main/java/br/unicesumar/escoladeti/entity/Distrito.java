package br.unicesumar.escoladeti.entity;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Entity 
public class Distrito extends SuperEntidade {
    @NotNull
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "SEDE_FK")
	private Cidade sede;
    
    @NotNull
    @OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "DISTRITO_FK") 
	private Cidade distrito;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date inicioVigencia;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fimVigencia;
    
    public Distrito() {
    }
    
    public Distrito(Cidade sede, Cidade distrito, Date inicioVigencia, Date fimVigencia) {
        this.sede = sede;
        this.distrito = distrito;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
    }

    public Date getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(Date inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public Date getFimVigencia() {
        return fimVigencia;
    }

    public void setFimVigencia(Date fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

    public Cidade getSede() {
        return sede;
    }

    public void setSede(Cidade sede) {
        this.sede = sede;
    }

    public Cidade getDistrito() {
        return distrito;
    }

    public void setDistrito(Cidade distrito) {
        this.distrito = distrito;
    }
    
} 
