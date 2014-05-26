package br.unicesumar.escoladeti.types;

public enum TipoBairro {

        AREA("Área"),
        CHACARA("Chácara"),
        COLONIA("Colônia"),
        CONDOMINIO("Condomínio"),
        CONJUNTO("Conjunto"),
        DISTRITO("Distrito"),
        FAVELA("Favela"),
        FAZENDA("Fazenda"),
        JARDIM("Jardim"),
        LOTEAMENTO("Loteamento"),
        MORRO("Morro"),
        PARQUE("Parque"),
        ZONA("Zona"),
        PRAÇA("Praça"),
        QUADRA("Quadra"),
        RECANTO("Recanto"),
        RESIDENCIAL("Residencial"),
        RODOVIA("Rodovia"),
        SETOR("Setor"),
        SITIO("Sítio"),
        VALE("Vale"),
        OUTROS("Outros");

	TipoBairro(String descricao) {
		this.descricao = descricao;
	}

	private String descricao;

	public String getDescricao() {
		return descricao;
	}

}