package br.com.iateclubedebrasilia.api.services;

import br.com.iateclubedebrasilia.api.entitys.Grupo;
import br.com.iateclubedebrasilia.api.repositorys.GruposRepository;
import br.com.iateclubedebrasilia.api.services.GruposService;
import br.com.iateclubedebrasilia.api.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class GruposServiceImpl implements GruposService {


    @Autowired
    private GruposRepository gruposRepository;

    public GruposServiceImpl(GruposRepository gruposRepository) {
        this.gruposRepository = gruposRepository;
    }

    @Override
    public ResponseEntity salvar(Grupo grupo) {
        return Optional
                .ofNullable(gruposRepository.save(grupo))
                .map(grupoSalvo->{
                    Map<String, Grupo> resposta =  new HashMap<>();
                    resposta.put("Registro salvo", grupoSalvo);
                    return  ResponseEntity.ok(resposta);
                }).orElseThrow(()-> new NullPointerException( "Não foi possível realizar o cadastro!"));
    }

    @Override
    public List<Grupo> listar(){
        return Optional
                .ofNullable(gruposRepository.findAll())
                .orElseThrow(() -> new NullPointerException("Não exitem grupos cadastrados"));
    }

    @Override
    public Grupo pesquisarGrupo(Integer id) {
        return Optional
                .ofNullable(id)
                .map(idConsultado->gruposRepository.findById(idConsultado).orElse(null))
                .orElseThrow(() -> new NullPointerException("Grupo não encontrado"));
    }

    @Override
    public ResponseEntity deletarGrupo(Integer id) {
        return Optional
                .ofNullable(gruposRepository.findById(id).orElse(null))
                .map(grupoConsultado-> {
                    gruposRepository.delete(grupoConsultado);
                    return ResponseEntity.ok("Registro excluído");
                }).orElseThrow(()-> new NullPointerException("Grupo não encontrado para exclusão"));
    }

    @Override
    public List<Grupo> alterarGrupos(List<Grupo> listaDeGrupos) {
        return Optional
                .ofNullable(Util.isListaObjVazia(listaDeGrupos))
                .map(listaValidada-> gruposRepository.saveAll(listaDeGrupos))
                .orElseThrow(()-> new NullPointerException("Informe pelo menos um grupo para ser alterado"));
    }

    @Override
    public Grupo alterarGrupo(Grupo grupo, Integer id){
        return Optional
                .ofNullable(gruposRepository.findById(id).orElse(null))
                .map(grupoConsultado-> {
                    grupo.setGrpIden(grupoConsultado.getGrpIden());
                    return gruposRepository.save(grupo);
                }).orElseThrow(()-> new NullPointerException("Não foi possível realizar a alteração"));

    }
}