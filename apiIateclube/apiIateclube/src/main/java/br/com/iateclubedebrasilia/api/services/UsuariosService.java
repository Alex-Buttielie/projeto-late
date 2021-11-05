package br.com.iateclubedebrasilia.api.services;


import br.com.iateclubedebrasilia.api.entitys.Usuario;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UsuariosService {
    ResponseEntity<Map<String, Usuario>> salvar(Usuario usuario);
    List<Usuario> listar();
    Usuario pesquisarUsuario(Integer id);
    List<Usuario> alterarUsuarios(List<Usuario> listaDeUsuarios);
    Usuario alterarUsuario(Usuario usuario, Integer id);
    ResponseEntity deletarUsuario(Integer id);
}
