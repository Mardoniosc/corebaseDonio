package br.com.mardonio.corebase.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mardonio.corebase.domain.Perfil;
import br.com.mardonio.corebase.dto.PerfilDTO;
import br.com.mardonio.corebase.services.PerfilService;

@RestController
@RequestMapping("/perfils")
public class PerfilResource {

	@Autowired
	private PerfilService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Perfil> find(@PathVariable Long id) {
		Perfil obj = service.find(id);
		return ResponseEntity.ok().body(obj) ;
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody PerfilDTO objDTO){
		Perfil obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody PerfilDTO objDTO, @PathVariable Long id){
		Perfil obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<PerfilDTO>> findAll() {
		List<Perfil> list = service.findAll();
		List<PerfilDTO> listDTO = list.stream().map(obj -> new PerfilDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<PerfilDTO>> findPage(
				@RequestParam(value = "page", defaultValue = "0" ) Integer page,
				@RequestParam(value = "linesPerPage", defaultValue = "24" ) Integer linesPerPage,
				@RequestParam(value = "orderBy", defaultValue = "nome" ) String orderBy,
				@RequestParam(value = "direction", defaultValue = "ASC" ) String direction
			) {
		Page<Perfil> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<PerfilDTO> listDTO = list.map(obj -> new PerfilDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}
}
