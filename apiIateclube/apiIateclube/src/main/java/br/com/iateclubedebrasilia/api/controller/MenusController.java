package br.com.iateclubedebrasilia.api.controller;

import br.com.iateclubedebrasilia.api.entitys.Menus;
import br.com.iateclubedebrasilia.api.services.MenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menusController")
public class MenusController {

    @Autowired
    private MenusService menuService;


    @PostMapping("/salvarMenus")
    public ResponseEntity<Map<String, Menus>> salvar(@RequestBody Menus menu) {
        return menuService.salvar(menu);
    }

    @GetMapping("/pesquisarMenus")
    public List<Menus> pesquisarMenus(){
        return menuService.listar();
    }

    @GetMapping("/pesquisarMenu/{id}")
    public Menus pesquisarMenu(@PathVariable Integer id){
        return menuService.pesquisarMenu(id);
    }

    @PutMapping("/alterarMenus")
    public List<Menus> alterarMenus(@RequestBody List<Menus> listaDeMenus){
        return menuService.alterarMenus(listaDeMenus);
    }

    @PutMapping("/alterarMenus/{id}")
    public  Menus alterarMenus (@RequestBody Menus Menus, @PathVariable Integer id) {
        return menuService.alterarMenus(Menus, id);
    }

    @DeleteMapping("/deletarMenus/{id}")
    public ResponseEntity deletarMenus(@PathVariable Integer id){
        return menuService.deletarMenus(id);
    }
}
