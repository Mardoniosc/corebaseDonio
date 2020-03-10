package br.com.mardonio.corebase.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mardonio.corebase.domain.Permissao;

@RestController
@RequestMapping("/permissoes")
public class PermissaoResource {

	@GetMapping
	public List<Permissao> listar() {
		Permissao p1 = new Permissao(1, "Home", "/dashboard");
		Permissao p2 = new Permissao(2, "usuario", "/usuarios");
		
		List<Permissao> lista = new ArrayList<>();
		
		lista.add(p1);
		lista.add(p2);
		
		return lista;
	}
}
