package br.com.iateclubedebrasilia.api.resources;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gruposController")
public class GruposController{


  /*  @Autowired
    private GruposService gruposService;

    @PostMapping("/salvarGrupo")
    public ResponseEntity<Map<String, Grupo>> salvar(@RequestBody Grupo grupo) {
        return gruposService.salvar(grupo);
    }

    @GetMapping("/pesquisarGrupos")
    public List<Grupo> pesquisarGrupos(){
        return gruposService.listar();
    }

    @GetMapping("/pesquisarGrupo/{id}")
    public Grupo pesquisarGrupo(@PathVariable Integer id){
        return gruposService.pesquisarGrupo(id);
    }

    @PutMapping("/alterarGrupos")
    public List<Grupo> alterarGrupos(@RequestBody List<Grupo> listaDeGrupos){
        return gruposService.alterarGrupos(listaDeGrupos);
    }

    @PutMapping("/alterarGrupo/{id}")
    public Grupo alterarGrupo (@RequestBody Grupo grupo, @PathVariable Integer id) {
        return gruposService.alterarGrupo(grupo, id);
    }

    @DeleteMapping("/deletarGrupo/{id}")
    public ResponseEntity deletarGrupo(@PathVariable Integer id){
        return gruposService.deletarGrupo(id);
    }
*/
}
