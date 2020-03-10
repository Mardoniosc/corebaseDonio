package br.com.mardonio.corebase.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
public class Permissao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String descricao;
	
	@NotNull
	private String url;
	
	@Null
	@ManyToOne
	@JoinColumn(name = "permissao_pai_id")
	private Permissao permissaoPai;

	public Permissao() {
	}

	public Permissao(Long id, String descricao, String url, Permissao permissaoPai) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.url = url;
		this.permissaoPai = permissaoPai;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Permissao getPermissaoPai() {
		return permissaoPai;
	}

	public void setPermissaoPai(Permissao permissaoPai) {
		this.permissaoPai = permissaoPai;
	}

}
