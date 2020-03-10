package br.com.mardonio.corebase.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mardonio.corebase.domain.Permissao;
import br.com.mardonio.corebase.repositories.PermissaoRepository;
import br.com.mardonio.corebase.services.exceptions.ObjectNotFoundException;

@Service
public class PermissaoService {

	@Autowired
	private PermissaoRepository repo;
	
	public Permissao find(Long id) {
		Optional<Permissao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Permissao.class.getName()));
	}
}
