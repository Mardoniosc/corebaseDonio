package br.com.mardonio.corebase.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.mardonio.corebase.domain.Usuario;
import br.com.mardonio.corebase.domain.enums.StatusUsuario;
import br.com.mardonio.corebase.dto.UsuarioDTO;
import br.com.mardonio.corebase.repositories.UsuarioRepository;
import br.com.mardonio.corebase.services.exceptions.DataIntegrityException;
import br.com.mardonio.corebase.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;
	
	public Usuario find(Long id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
	
	public Usuario fromDTO(UsuarioDTO objDTO) {
		return new Usuario(objDTO.getId(), objDTO.getNome(), objDTO.getEmail(), objDTO.getSenha(), null, objDTO.getLogin(), null, null, StatusUsuario.ATIVADO, null);
	}
	
	public List<Usuario> findAll(){
		return repo.findAll();
	}
	
	public Usuario update(Usuario obj) {
		Usuario newObj =  find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setCPF(obj.getCPF());
		newObj.setPerfil(obj.getPerfil());
	}
	
	public void delete(Long id) {
		find(id);
		try {
			repo.deleteById(id);			
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Usuario!");
		}
	}
	
	public Page<Usuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
