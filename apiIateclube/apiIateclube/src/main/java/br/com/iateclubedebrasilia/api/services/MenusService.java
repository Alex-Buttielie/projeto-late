package br.com.iateclubedebrasilia.api.services;


import br.com.iateclubedebrasilia.api.entitys.Menu;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface MenusService {
    ResponseEntity<Map<String, Menu>> salvar(Menu menu);
    List<Menu> listar();
    Menu pesquisarMenu(Integer id);
    List<Menu> alterarMenus(List<Menu> menus);
    Menu alterarMenus(Menu menu, Integer id);
    ResponseEntity deletarMenus(Integer id);
}
