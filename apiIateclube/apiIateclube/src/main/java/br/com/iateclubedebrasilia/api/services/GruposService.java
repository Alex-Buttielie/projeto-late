package br.com.iateclubedebrasilia.api.services;


import br.com.iateclubedebrasilia.api.entitys.Grupo;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface GruposService {

    ResponseEntity<Map<String, Grupo>> salvar(Grupo grupo);
    List<Grupo> listar();
    List<Grupo> alterarGrupos(List<Grupo> listaDeGrupos);
    Grupo alterarGrupo(Grupo grupo, Integer id);
    Grupo pesquisarGrupo(Integer id);
    ResponseEntity deletarGrupo(Integer id);
}
