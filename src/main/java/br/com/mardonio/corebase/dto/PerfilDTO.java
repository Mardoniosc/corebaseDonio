package br.com.mardonio.corebase.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.mardonio.corebase.domain.Perfil;

public class PerfilDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty(message = "Preenchimento Obrigatório")
	@Length(min = 4, max = 40, message = "Tamanha deve ser entre 4 e 40 catracteres")
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
