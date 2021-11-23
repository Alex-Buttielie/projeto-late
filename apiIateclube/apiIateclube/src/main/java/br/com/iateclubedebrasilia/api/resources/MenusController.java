package br.com.iateclubedebrasilia.api.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menusController")
public class MenusController {


   /* @Autowired
    private MenusService menuService;


    @PostMapping("/salvarMenus")
    public ResponseEntity<Map<String, Menu>> salvar(@RequestBody Menu menu) {
        return menuService.salvar(menu);
    }

    @GetMapping("/pesquisarMenus")
    public List<Menu> pesquisarMenus(){
        return menuService.listar();
    }

    @GetMapping("/pesquisarMenu/{id}")
    public Menu pesquisarMenu(@PathVariable Integer id){
        return menuService.pesquisarMenu(id);
    }

    @PutMapping("/alterarMenus")
    public List<Menu> alterarMenus(@RequestBody List<Menu> listaDeMenus){
        return menuService.alterarMenus(listaDeMenus);
    }

    @PutMapping("/alterarMenus/{id}")
    public Menu alterarMenus (@RequestBody Menu Menu, @PathVariable Integer id) {
        return menuService.alterarMenus(Menu, id);
    }

    @DeleteMapping("/deletarMenus/{id}")
    public ResponseEntity deletarMenus(@PathVariable Integer id){
        return menuService.deletarMenus(id);
    }

    */
}
