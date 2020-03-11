package br.com.mardonio.corebase;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mardonio.corebase.domain.Perfil;
import br.com.mardonio.corebase.domain.Permissao;
import br.com.mardonio.corebase.domain.Usuario;
import br.com.mardonio.corebase.domain.enums.StatusUsuario;
import br.com.mardonio.corebase.repositories.PerfilRepository;
import br.com.mardonio.corebase.repositories.PermissaoRepository;
import br.com.mardonio.corebase.repositories.UsuarioRepository;

@SpringBootApplication
public class CoreBaseApplication implements CommandLineRunner{

	@Autowired
	private PermissaoRepository permissaoRepository;
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CoreBaseApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		 
		 Permissao pm1 = new Permissao(null, "Home", "/home", null);
		 Permissao pm2 = new Permissao(null, "DashBoard", "/dashboard", null);
		 Permissao pm3 = new Permissao(null, "Usuario", "/usuario", null);
		 
		 Perfil pf1 = new Perfil(null, "root");
		 Perfil pf2 = new Perfil(null, "Administrador");
		 Perfil pf3 = new Perfil(null, "Gertor");
		 Perfil pf4 = new Perfil(null, "Operador");
		 
		 pf1.getPermissoes().addAll(Arrays.asList(pm1,pm2,pm3));
		 pf2.getPermissoes().addAll(Arrays.asList(pm1,pm2,pm3));
		 pf3.getPermissoes().addAll(Arrays.asList(pm1,pm2));
		 pf4.getPermissoes().addAll(Arrays.asList(pm1));
		 
		 pm1.getPerfil().addAll(Arrays.asList(pf1,pf2,pf3,pf4));
		 pm2.getPerfil().addAll(Arrays.asList(pf1,pf2,pf3));
		 pm3.getPerfil().addAll(Arrays.asList(pf1,pf2));

		 permissaoRepository.saveAll(Arrays.asList(pm1,pm2,pm3));
		 
		 perfilRepository.saveAll(Arrays.asList(pf1, pf2, pf3, pf4));
		 
		 Usuario user1 = new Usuario(null,"root", "root@tecnisys.com.br", "123123", "41193360005", "root", null, null, StatusUsuario.ATIVADO, pf1);
		 
		 usuarioRepository.saveAll(Arrays.asList(user1));
		 
	}

}
