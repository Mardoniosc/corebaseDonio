package br.com.mardonio.corebase.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Permissao {

	@GetMapping
	public String listar() {
		return "Rest está funcionando";
	}
}
