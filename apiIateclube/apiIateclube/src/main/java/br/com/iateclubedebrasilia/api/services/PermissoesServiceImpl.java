package br.com.iateclubedebrasilia.api.services;

import br.com.iateclubedebrasilia.api.entitys.Permissao;
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
    public ResponseEntity<Map<String, Permissao>> salvar(Permissao permissao) {
        return Optional
                .ofNullable(permissoesRepository.save(permissao))
                .map(permissaoSalvas ->{
                    Map<String, Permissao> resposta =  new HashMap<>();
                    resposta.put("Registro salvo", permissaoSalvas);
                    return  ResponseEntity.ok(resposta);
                }).orElseThrow(()-> new NullPointerException( "N�o foi poss�vel realizar o cadastro!"));
    }

    @Override
    public List<Permissao> listar() {
        return Optional
                .ofNullable(permissoesRepository.findAll())
                .orElseThrow(() -> new NullPointerException("N�o exitem permiss�es cadastrados"));
    }

    @Override
    public Permissao pesquisarPermissao(Integer id) {
        return Optional
                .ofNullable(id)
                .map(idConsultado->permissoesRepository.findById(idConsultado).orElse(null))
                .orElseThrow(() -> new NullPointerException("Permiss�es n�o encontradas"));
    }

    @Override
    public List<Permissao> alterarPermissoes(List<Permissao> listaDePermissoes) {
        return Optional
                .ofNullable(Util.isListaObjVazia(listaDePermissoes))
                .map(listaValidada-> permissoesRepository.saveAll(listaDePermissoes))
                .orElseThrow(()-> new NullPointerException("Informe pelo menos uma permiss�o para ser alterar"));
    }

    @Override
    public Permissao alterarPermissao(Permissao permissao, Integer id) {
        return Optional
                .ofNullable(permissoesRepository.findById(id).orElse(null))
                .map(permissaoConsultada-> {
                    permissao.setPerIden(permissaoConsultada.getPerIden());
                    return permissoesRepository.save(permissao);
                }).orElseThrow(()-> new NullPointerException("N�o foi poss�vel realizar a altera��o"));
    }

    @Override
    public ResponseEntity deletarPermissao(Integer id) {
        return Optional
                .ofNullable(permissoesRepository.findById(id).orElse(null))
                .map(permissaoConsultadas -> {
                    permissoesRepository.delete(permissaoConsultadas);
                    return ResponseEntity.ok("Registro exclu�do");
                }).orElseThrow(()-> new NullPointerException("Permiss�o n�o encontrada para exclus�o"));
    }
}
