package br.com.iateclubedebrasilia.api.services;


import br.com.iateclubedebrasilia.api.entitys.Menus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface MenusService {
    ResponseEntity<Map<String, Menus>> salvar(Menus menus);
    List<Menus> listar();
    Menus pesquisarMenu(Integer id);
    List<Menus> alterarMenus(List<Menus> menus);
    Menus alterarMenus(Menus menus, Integer id);
    ResponseEntity deletarMenus(Integer id);
}
