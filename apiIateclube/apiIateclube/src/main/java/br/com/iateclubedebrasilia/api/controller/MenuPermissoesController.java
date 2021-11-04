package br.com.iateclubedebrasilia.api.controller;

import br.com.iateclubedebrasilia.api.entitys.MenuPermissoes;
import br.com.iateclubedebrasilia.api.services.MenuPermissoesService;
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
@RequestMapping("/menuPermissoesController")
public class MenuPermissoesController {

    @Autowired
    MenuPermissoesService menuPermissoesService;

    @PostMapping("/salvarMenuPermissoes")
    public ResponseEntity<Map<String, MenuPermissoes>> salvar(@RequestBody MenuPermissoes MenuPermissoes) {
        return menuPermissoesService.salvar(MenuPermissoes);
    }

    @GetMapping("/pesquisarMenuPermissoes")
    public List<MenuPermissoes> pesquisarMenuPermissoes(){
        return menuPermissoesService.listar();
    }

    @GetMapping("/pesquisarMenuPermissoes/{id}")
    public MenuPermissoes pesquisarMenuPermissoes(@PathVariable Integer id){
        return menuPermissoesService.pesquisarMenuPermissoes(id);
    }

    @PutMapping("/alterarMenuPermissoes")
    public List<MenuPermissoes> alterarMenuPermissoes(@RequestBody List<MenuPermissoes> listaDeMenu){
        return menuPermissoesService.alterarMenuPermissoes(listaDeMenu);
    }

    @PutMapping("/alterarMenuPermissoes/{id}")
    public  MenuPermissoes alterarMenuPermissoes (@RequestBody MenuPermissoes MenuPermissoes, @PathVariable Integer id) {
        return menuPermissoesService.alterarMenuPermissoes(MenuPermissoes, id);
    }

    @DeleteMapping("/deletarMenuPermissoes/{id}")
    public ResponseEntity deletarMenuPermissoes(@PathVariable Integer id){
        return menuPermissoesService.deletarMenuPermissoes(id);
    }
}
