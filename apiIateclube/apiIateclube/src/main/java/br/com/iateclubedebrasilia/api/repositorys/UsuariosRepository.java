package br.com.iateclubedebrasilia.api.repositorys;

import br.com.iateclubedebrasilia.api.entitys.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
}