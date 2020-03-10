package br.com.mardonio.corebase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mardonio.corebase.domain.Permissao;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

}
