package br.com.mardonio.corebase.domain.enums;

public enum StatusPermissaoPerfil {
	
	ATIVADO(1, "Ativado"),
	INATIVO(2, "Desativado");
	
	private int cod;
	private String descricao;
	
	private StatusPermissaoPerfil(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static StatusPermissaoPerfil toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for (StatusPermissaoPerfil x : StatusPermissaoPerfil.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}

