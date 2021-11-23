package br.com.iateclubedebrasilia.api.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/permissoesController")
public class PermissoesController {

  /*  @Autowired
    private PermissoesService permissoesService;


    
    @PostMapping("/salvarGrupo")
    public ResponseEntity<Map<String, Permissao>> salvar(@RequestBody Permissao permissao) {
        return permissoesService.salvar(permissao);
    }

    @GetMapping("/pesquisarPermissoes")
    public List<Permissao> pesquisarPermissoes(){
        return permissoesService.listar();
    }

    @GetMapping("/pesquisarPermissao/{id}")
    public Permissao pesquisarPermissao(@PathVariable Integer id){
        return permissoesService.pesquisarPermissao(id);
    }

    @PutMapping("/alterarPermissoes")
    public List<Permissao> alterarPermissoes(@RequestBody List<Permissao> listaDePermissoes){
        return permissoesService.alterarPermissoes(listaDePermissoes);
    }

    @PutMapping("/alterarPermissao/{id}")
    public Permissao alterarGrupo (@RequestBody Permissao grupo, @PathVariable Integer id) {
        return permissoesService.alterarPermissao(grupo, id);
    }

    @DeleteMapping("/deletarPermissao/{id}")
    public ResponseEntity deletarPermissao(@PathVariable Integer id){
        return permissoesService.deletarPermissao(id);
    }*/
}
