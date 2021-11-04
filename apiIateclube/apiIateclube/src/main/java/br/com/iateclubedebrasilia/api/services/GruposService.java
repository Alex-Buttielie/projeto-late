package br.com.iateclubedebrasilia.api.services;


import br.com.iateclubedebrasilia.api.entitys.Grupos;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface GruposService {

    ResponseEntity<Map<String, Grupos>> salvar(Grupos grupo);
    List<Grupos> listar();
    List<Grupos> alterarGrupos(List<Grupos> listaDeGrupos);
    Grupos alterarGrupo(Grupos grupo, Integer id);
    Grupos pesquisarGrupo(Integer id);
    ResponseEntity deletarGrupo(Integer id);
}
