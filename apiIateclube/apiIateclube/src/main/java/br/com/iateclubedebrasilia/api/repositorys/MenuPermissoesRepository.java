package br.com.iateclubedebrasilia.api.repositorys;

import br.com.iateclubedebrasilia.api.entitys.MenuPermissoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuPermissoesRepository extends JpaRepository<MenuPermissoes, Integer> {
}
