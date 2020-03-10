package br.com.mardonio.corebase;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mardonio.corebase.domain.Permissao;
import br.com.mardonio.corebase.repositories.PermissaoRepository;

@SpringBootApplication
public class CoreBaseApplication implements CommandLineRunner{

	@Autowired
	private PermissaoRepository permissaoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CoreBaseApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		 Permissao p1 = new Permissao(null, "Home", "/home", null);
		 Permissao p2 = new Permissao(null, "DashBoard", "/dashboard", null);
		 Permissao p3 = new Permissao(null, "Usuario", "/usuario", null);
		 
		 permissaoRepository.saveAll(Arrays.asList(p1,p2,p3));
	}

}
