package br.com.iateclubedebrasilia.api.services;

import br.com.iateclubedebrasilia.api.entitys.MenuPermissoes;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface MenuPermissoesService {

    ResponseEntity<Map<String, MenuPermissoes>> salvar(MenuPermissoes menuPermissoes);
    List<MenuPermissoes> listar();
    MenuPermissoes pesquisarMenuPermissoes(Integer id);
    List<MenuPermissoes> alterarMenuPermissoes(List<MenuPermissoes> listaDeMenuPermissoes);
    MenuPermissoes alterarMenuPermissoes(MenuPermissoes menuPermissoes, Integer id);
    ResponseEntity deletarMenuPermissoes(Integer id);
}
