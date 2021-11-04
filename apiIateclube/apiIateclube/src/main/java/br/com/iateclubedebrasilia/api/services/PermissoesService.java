package br.com.iateclubedebrasilia.api.services;


import br.com.iateclubedebrasilia.api.entitys.Permissoes;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface PermissoesService {
    ResponseEntity<Map<String, Permissoes>> salvar(Permissoes permissoes);
    List<Permissoes> listar();
    Permissoes pesquisarPermissao(Integer id);
    List<Permissoes> alterarPermissoes(List<Permissoes> permissoes);
    Permissoes alterarPermissao(Permissoes permissoes, Integer id);
    ResponseEntity deletarPermissao(Integer id);
}
