package br.com.iateclubedebrasilia.api.implement;

import br.com.iateclubedebrasilia.api.entitys.Grupos;
import br.com.iateclubedebrasilia.api.entitys.GruposPermissoes;
import br.com.iateclubedebrasilia.api.repositorys.GruposPermissoesRepository;
import br.com.iateclubedebrasilia.api.services.GruposPermissoesService;
import br.com.iateclubedebrasilia.api.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class GruposPermissoesServiceImpl implements GruposPermissoesService {

    @Autowired
    private GruposPermissoesRepository gruposPermissoesRepository;


    @Override
    public ResponseEntity<Map<String, GruposPermissoes>> salvar(GruposPermissoes gruposPermissoes) {
        return Optional
                .ofNullable(gruposPermissoesRepository.save(gruposPermissoes))
                .map(grupoPermissoesSalvo->{
                    Map<String, GruposPermissoes> resposta =  new HashMap<>();
                    resposta.put("Registro salvo", grupoPermissoesSalvo);
                    return  ResponseEntity.ok(resposta);
                }).orElseThrow(()-> new NullPointerException( "Não foi possível realizar o cadastro!"));
    }

    @Override
    public List<GruposPermissoes> listar() {
        return Optional
                .ofNullable(gruposPermissoesRepository.findAll())
                .orElseThrow(() -> new NullPointerException("Não xitem permissões cadastradas para esse grupo"));
    }

    @Override
    public GruposPermissoes pesquisarGruposPermissoes(Integer id) {
        return Optional
                .ofNullable(id)
                .map(idConsultado->gruposPermissoesRepository.findById(idConsultado).orElse(null))
                .orElseThrow(() -> new NullPointerException("Grupos e permissões não encontrados"));
    }

    @Override
    public List<GruposPermissoes> alterarGruposPermissoes(List<GruposPermissoes> listaDeGruposPermissoes) {
        return Optional
                .ofNullable(Util.isListaObjVazia(listaDeGruposPermissoes))
                .map(listaValidada-> gruposPermissoesRepository.saveAll(listaDeGruposPermissoes))
                .orElseThrow(()-> new NullPointerException("Informe pelo menos um grupo para alterar a permissão"));
    }

    @Override
    public GruposPermissoes alterarGruposPermissoes(GruposPermissoes gruposPermissoes, Integer id) {
        return Optional
                .ofNullable(gruposPermissoesRepository.findById(id).orElse(null))
                .map(grupoPermissoesConsultado-> {
                    gruposPermissoes.setGrpPerIden(grupoPermissoesConsultado.getGrpPerIden());
                    return gruposPermissoesRepository.save(gruposPermissoes);
                }).orElseThrow(()-> new NullPointerException("Não foi possível realizar a alteração"));
    }

    @Override
    public ResponseEntity deletarGruposPermissoes(Integer id) {
        return Optional
                .ofNullable(gruposPermissoesRepository.findById(id).orElse(null))
                .map(grupoPermissoesConsultado-> {
                    gruposPermissoesRepository.delete(grupoPermissoesConsultado);
                    return ResponseEntity.ok("Registro excluído");
                }).orElseThrow(()-> new NullPointerException("Grupo não encontrado para exclusão"));
    }
}
