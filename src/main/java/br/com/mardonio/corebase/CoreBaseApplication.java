package br.com.mardonio.corebase;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mardonio.corebase.domain.Perfil;
import br.com.mardonio.corebase.domain.PerfilPermissao;
import br.com.mardonio.corebase.domain.Permissao;
import br.com.mardonio.corebase.domain.Usuario;
import br.com.mardonio.corebase.domain.enums.StatusPermissaoPerfil;
import br.com.mardonio.corebase.domain.enums.StatusUsuario;
import br.com.mardonio.corebase.repositories.PerfilPermissaoRepository;
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
	
	@Autowired
	private PerfilPermissaoRepository perfilPermissaoRepository;
	
	
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
//		 Perfil pf4 = new Perfil(null, "Operador");
		 
		 // usuario root
		 PerfilPermissao pp1 = new PerfilPermissao(pf1, pm1, StatusPermissaoPerfil.ATIVADO);
		 PerfilPermissao pp2 = new PerfilPermissao(pf1, pm2, StatusPermissaoPerfil.ATIVADO);
		 PerfilPermissao pp3 = new PerfilPermissao(pf1, pm3, StatusPermissaoPerfil.ATIVADO);
		 
		 // Usuario admin
		 PerfilPermissao pp4 = new PerfilPermissao(pf2, pm1, StatusPermissaoPerfil.INATIVO);
		 PerfilPermissao pp5 = new PerfilPermissao(pf2, pm2, StatusPermissaoPerfil.ATIVADO);
		 PerfilPermissao pp6 = new PerfilPermissao(pf2, pm3, StatusPermissaoPerfil.ATIVADO);
		 
		 // Usuario Gestor
		 PerfilPermissao pp7 = new PerfilPermissao(pf3, pm1, StatusPermissaoPerfil.INATIVO);
		 PerfilPermissao pp8 = new PerfilPermissao(pf3, pm3, StatusPermissaoPerfil.ATIVADO);

		 // Usuario Operador
//		 PerfilPermissao pp9 = new PerfilPermissao(pf4, pm1, StatusPermissaoPerfil.INATIVO);
		 
		 permissaoRepository.saveAll(Arrays.asList(pm1,pm2,pm3));
		 
		 perfilRepository.saveAll(Arrays.asList(pf1, pf2, pf3));
		 
		 perfilPermissaoRepository.saveAll(Arrays.asList(pp1, pp2, pp3, pp4, pp5, pp6, pp7, pp8));
		 Usuario user1 = new Usuario(null,"root", "root@tecnisys.com.br", "123123", "41193360005", "root", null, null, StatusUsuario.ATIVADO, pf1);
		 
		 usuarioRepository.saveAll(Arrays.asList(user1));
		 
	}

}
