package br.unicesumar.escoladeti.types;

public enum TipoLogradouro {

    AEROPORTO("Aeroporto"),
    ALAMEDA("Alameda"),
    AVENIDA ("Avenida"),
    RUA ("Rua"),
    ESTRADA ("Estrada"),
    RODOVIA ("Rodovia"),
    OUTROS ("Outros");

    TipoLogradouro(String descricao) {
        this.descricao = descricao;
    }

    private String descricao;

    public String getDescricao() {
        return descricao;
    }
    
}
