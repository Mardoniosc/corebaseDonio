package br.com.mardonio.corebase.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mardonio.corebase.domain.Usuario;
import br.com.mardonio.corebase.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Long id) {
		Usuario obj = service.find(id);
		return ResponseEntity.ok(obj);
	}
}
