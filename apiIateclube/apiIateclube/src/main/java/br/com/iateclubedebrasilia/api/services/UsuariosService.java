package br.com.iateclubedebrasilia.api.services;


import br.com.iateclubedebrasilia.api.entitys.Usuarios;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UsuariosService {
    ResponseEntity<Map<String, Usuarios>> salvar(Usuarios usuarios);
    List<Usuarios> listar();
    Usuarios pesquisarUsuario(Integer id);
    List<Usuarios> alterarUsuarios(List<Usuarios> listaDeUsuarios);
    Usuarios alterarUsuario(Usuarios usuarios, Integer id);
    ResponseEntity deletarUsuario(Integer id);
}
