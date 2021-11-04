package br.com.iateclubedebrasilia.api.implement;

import br.com.iateclubedebrasilia.api.entitys.MenuPermissoes;
import br.com.iateclubedebrasilia.api.repositorys.MenuPermissoesRepository;
import br.com.iateclubedebrasilia.api.services.MenuPermissoesService;
import br.com.iateclubedebrasilia.api.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MenuPermissoesServiceImpl implements MenuPermissoesService {

    @Autowired
    private MenuPermissoesRepository menuPermissoesRepository;

    @Override
    public ResponseEntity<Map<String, MenuPermissoes>> salvar(MenuPermissoes menuPermissoes) {
        return Optional
                .ofNullable(menuPermissoesRepository.save(menuPermissoes))
                .map(menuPermissoesSalvo->{
                    Map<String, MenuPermissoes> resposta =  new HashMap<>();
                    resposta.put("Registro salvo", menuPermissoesSalvo);
                    return  ResponseEntity.ok(resposta);
                }).orElseThrow(()-> new NullPointerException( "N�o foi poss�vel realizar o cadastro!"));
    }

    @Override
    public List<MenuPermissoes> listar() {
        return Optional
                .ofNullable(menuPermissoesRepository.findAll())
                .orElseThrow(() -> new NullPointerException("N�o exitem permiss�es cadastradas para o menu"));
    }

    @Override
    public MenuPermissoes pesquisarMenuPermissoes(Integer id) {
        return Optional
                .ofNullable(id)
                .map(idConsultado->menuPermissoesRepository.findById(idConsultado).orElse(null))
                .orElseThrow(() -> new NullPointerException("Permiss�es do menu n�o encontradas "));
    }

    @Override
    public List<MenuPermissoes> alterarMenuPermissoes(List<MenuPermissoes> listaDeMenuPermissoes) {
        return Optional
                .ofNullable(Util.isListaObjVazia(listaDeMenuPermissoes))
                .map(listaValidada-> menuPermissoesRepository.saveAll(listaDeMenuPermissoes))
                .orElseThrow(()-> new NullPointerException("Informe pelo menos um menu para alterar aas permiss�es"));
    }

    @Override
    public MenuPermissoes alterarMenuPermissoes(MenuPermissoes menuPermissoes, Integer id) {
        return Optional
                .ofNullable(menuPermissoesRepository.findById(id).orElse(null))
                .map(menuPermissoesConsultado-> {
                    menuPermissoes.setMpeMen(menuPermissoesConsultado.getMpeMen());
                    return menuPermissoesRepository.save(menuPermissoes);
                }).orElseThrow(()-> new NullPointerException("N�o foi poss�vel realizar a altera��o"));
    }

    @Override
    public ResponseEntity deletarMenuPermissoes(Integer id) {
        return Optional
                .ofNullable(menuPermissoesRepository.findById(id).orElse(null))
                .map(menuPermissoesConsultado-> {
                    menuPermissoesRepository.delete(menuPermissoesConsultado);
                    return ResponseEntity.ok("Registro exclu�do");
                }).orElseThrow(()-> new NullPointerException("Permiss�es do menu n�o encontradas para exclus�o"));
    }
}
