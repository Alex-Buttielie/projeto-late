package br.com.iateclubedebrasilia.api.services;


import br.com.iateclubedebrasilia.api.entitys.Permissao;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface PermissoesService {
    ResponseEntity<Map<String, Permissao>> salvar(Permissao permissao);
    List<Permissao> listar();
    Permissao pesquisarPermissao(Integer id);
    List<Permissao> alterarPermissoes(List<Permissao> permissoes);
    Permissao alterarPermissao(Permissao permissao, Integer id);
    ResponseEntity deletarPermissao(Integer id);
}
