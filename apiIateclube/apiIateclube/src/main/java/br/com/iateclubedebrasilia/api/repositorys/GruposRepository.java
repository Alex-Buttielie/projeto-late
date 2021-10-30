package br.com.iateclubedebrasilia.api.repositorys;

import br.com.iateclubedebrasilia.api.entitys.Grupos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GruposRepository extends JpaRepository<Grupos, Integer> {
}
