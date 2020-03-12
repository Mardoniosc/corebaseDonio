package br.com.mardonio.corebase.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.mardonio.corebase.domain.Perfil;
import br.com.mardonio.corebase.dto.PerfilDTO;
import br.com.mardonio.corebase.repositories.PerfilRepository;
import br.com.mardonio.corebase.services.exceptions.DataIntegrityException;
import br.com.mardonio.corebase.services.exceptions.ObjectNotFoundException;

@Service
public class PerfilService {

	@Autowired
	private PerfilRepository repo;
	
	public Perfil find(Long id) {
		Optional<Perfil> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Perfil.class.getName()));
	}
	
	public Perfil fromDTO(PerfilDTO objDTO) {
		return new Perfil(objDTO.getId(), objDTO.getNome());
	}
	
	public List<Perfil> findAll(){
		return repo.findAll();
	}
	
	public Perfil insert(Perfil obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Perfil update(Perfil obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Long id) {
		find(id);
		try {
			repo.deleteById(id);			
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma perfil com permissões associadas");
		}
	}
	
	public Page<Perfil> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
