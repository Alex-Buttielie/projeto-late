package br.com.iateclubedebrasilia.api.repositorys;

import br.com.iateclubedebrasilia.api.entitys.UsuariosGrupos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosGruposRepository extends JpaRepository<UsuariosGrupos, Integer> {
}
