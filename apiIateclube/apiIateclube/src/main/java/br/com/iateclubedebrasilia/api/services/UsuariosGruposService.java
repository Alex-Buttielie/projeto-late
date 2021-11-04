package br.com.iateclubedebrasilia.api.services;


import br.com.iateclubedebrasilia.api.entitys.UsuariosGrupos;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UsuariosGruposService {
    ResponseEntity<Map<String, UsuariosGrupos>> salvar(UsuariosGrupos usuariosGrupos);
    List<UsuariosGrupos> listar();
    UsuariosGrupos pesquisarUsuariosGrupos(Integer id);
    List<UsuariosGrupos> alterarUsuariosGrupos(List<UsuariosGrupos> listaDeUsuariosGrupos);
    UsuariosGrupos alterarUsuariosGrupos(UsuariosGrupos usuariosGrupos, Integer id);
    ResponseEntity deletarUsuariosGrupos(Integer id);
}
