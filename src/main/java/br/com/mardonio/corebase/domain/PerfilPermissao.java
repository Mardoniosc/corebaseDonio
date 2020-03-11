package br.com.mardonio.corebase.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.mardonio.corebase.domain.enums.StatusPermissaoPerfil;
import br.com.mardonio.corebase.domain.enums.StatusUsuario;

@Entity
public class PerfilPermissao {
	
	@JsonIgnore
	@EmbeddedId
	private PerfilPermissaoPK id = new PerfilPermissaoPK();

	private Integer status;
	
	public PerfilPermissao() {}

	public PerfilPermissao(Perfil perfil, Permissao permissao, StatusPermissaoPerfil status) {
		super();
		id.setPerfil(perfil);
		id.setPermissao(permissao);
		this.status = (status == null) ? null : status.getCod();
	}
	
	public Perfil getPerfil() {
		return id.getPerfil();
	}
	
	@JsonIgnore
	public Permissao getPermissao() {
		return id.getPermissao();
	}

	public PerfilPermissaoPK getId() {
		return id;
	}

	public void setId(PerfilPermissaoPK id) {
		this.id = id;
	}

	public StatusUsuario getStatus() {
		return StatusUsuario.toEnum(status);
	}

	public void setStatus(StatusUsuario status) {
		this.status = status.getCod();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PerfilPermissao other = (PerfilPermissao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
