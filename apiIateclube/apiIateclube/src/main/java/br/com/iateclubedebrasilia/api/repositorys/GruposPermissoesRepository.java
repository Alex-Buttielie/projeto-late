package br.com.iateclubedebrasilia.api.repositorys;

import br.com.iateclubedebrasilia.api.entitys.GruposPermissoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GruposPermissoesRepository extends JpaRepository<GruposPermissoes, Integer> {
}
