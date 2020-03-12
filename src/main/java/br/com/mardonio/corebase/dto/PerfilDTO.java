package br.com.mardonio.corebase.dto;

import java.io.Serializable;

import br.com.mardonio.corebase.domain.Perfil;

public class PerfilDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	
	public PerfilDTO() {}

	public PerfilDTO(Perfil obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
