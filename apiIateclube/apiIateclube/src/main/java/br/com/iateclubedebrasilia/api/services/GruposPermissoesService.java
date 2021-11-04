package br.com.iateclubedebrasilia.api.services;


import br.com.iateclubedebrasilia.api.entitys.Grupos;
import br.com.iateclubedebrasilia.api.entitys.GruposPermissoes;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface GruposPermissoesService {

    ResponseEntity<Map<String, GruposPermissoes>> salvar(GruposPermissoes gruposPermissoes);
    List<GruposPermissoes> listar();
    GruposPermissoes pesquisarGruposPermissoes(Integer id);
    List<GruposPermissoes> alterarGruposPermissoes(List<GruposPermissoes> listaDeGruposPermissoes);
    GruposPermissoes alterarGruposPermissoes(GruposPermissoes grupo, Integer id);
    ResponseEntity deletarGruposPermissoes(Integer id);
}
