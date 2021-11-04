package br.com.iateclubedebrasilia.api.implement;

import br.com.iateclubedebrasilia.api.entitys.Permissoes;
import br.com.iateclubedebrasilia.api.repositorys.PermissoesRepository;
import br.com.iateclubedebrasilia.api.services.PermissoesService;
import br.com.iateclubedebrasilia.api.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PermissoesServiceImpl implements PermissoesService {

    @Autowired
    private PermissoesRepository permissoesRepository;

    @Override
    public ResponseEntity<Map<String, Permissoes>> salvar(Permissoes permissoes) {
        return Optional
                .ofNullable(permissoesRepository.save(permissoes))
                .map(permissoesSalvas->{
                    Map<String, Permissoes> resposta =  new HashMap<>();
                    resposta.put("Registro salvo", permissoesSalvas);
                    return  ResponseEntity.ok(resposta);
                }).orElseThrow(()-> new NullPointerException( "N�o foi poss�vel realizar o cadastro!"));
    }

    @Override
    public List<Permissoes> listar() {
        return Optional
                .ofNullable(permissoesRepository.findAll())
                .orElseThrow(() -> new NullPointerException("N�o exitem permiss�es cadastrados"));
    }

    @Override
    public Permissoes pesquisarPermissao(Integer id) {
        return Optional
                .ofNullable(id)
                .map(idConsultado->permissoesRepository.findById(idConsultado).orElse(null))
                .orElseThrow(() -> new NullPointerException("Permiss�es n�o encontradas"));
    }

    @Override
    public List<Permissoes> alterarPermissoes(List<Permissoes> listaDePermissoes) {
        return Optional
                .ofNullable(Util.isListaObjVazia(listaDePermissoes))
                .map(listaValidada-> permissoesRepository.saveAll(listaDePermissoes))
                .orElseThrow(()-> new NullPointerException("Informe pelo menos uma permiss�o para ser alterar"));
    }

    @Override
    public Permissoes alterarPermissao(Permissoes permissoes, Integer id) {
        return Optional
                .ofNullable(permissoesRepository.findById(id).orElse(null))
                .map(permissaoConsultada-> {
                    permissoes.setPerIden(permissaoConsultada.getPerIden());
                    return permissoesRepository.save(permissoes);
                }).orElseThrow(()-> new NullPointerException("N�o foi poss�vel realizar a altera��o"));
    }

    @Override
    public ResponseEntity deletarPermissao(Integer id) {
        return Optional
                .ofNullable(permissoesRepository.findById(id).orElse(null))
                .map(PermissoesConsultadas-> {
                    permissoesRepository.delete(PermissoesConsultadas);
                    return ResponseEntity.ok("Registro exclu�do");
                }).orElseThrow(()-> new NullPointerException("Permiss�o n�o encontrada para exclus�o"));
    }
}
