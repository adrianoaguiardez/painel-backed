package br.com.simconsult.painel.modelo;

public enum Tipo {
	GASOLINA ("Gasolina"),
	DIESEL ("Diesel"),
	ETANOL("Etanol"),
	GAS("Gás");
	
	private String descricao;

	private Tipo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
	
	

}
