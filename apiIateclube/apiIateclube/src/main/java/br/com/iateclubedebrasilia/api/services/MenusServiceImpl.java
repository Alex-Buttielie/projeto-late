package br.com.iateclubedebrasilia.api.services;

import br.com.iateclubedebrasilia.api.entitys.Menu;
import br.com.iateclubedebrasilia.api.repositorys.MenusRepository;
import br.com.iateclubedebrasilia.api.services.MenusService;
import br.com.iateclubedebrasilia.api.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MenusServiceImpl implements MenusService {

    @Autowired
    private MenusRepository menusRepository;

    @Override
    public ResponseEntity<Map<String, Menu>> salvar(Menu menu) {
        return Optional
                .ofNullable(menusRepository.save(menu))
                .map(menuSalvo->{
                    Map<String, Menu> resposta =  new HashMap<>();
                    resposta.put("Registro salvo", menuSalvo);
                    return  ResponseEntity.ok(resposta);
                }).orElseThrow(()-> new NullPointerException( "N�o foi poss�vel realizar o cadastro!"));
    }

    @Override
    public List<Menu> listar() {
        return Optional
                .ofNullable(menusRepository.findAll())
                .orElseThrow(() -> new NullPointerException("N�o exitem menus cadastrados"));
    }

    @Override
    public Menu pesquisarMenu(Integer id) {
        return Optional
                .ofNullable(id)
                .map(idConsultado->menusRepository.findById(idConsultado).orElse(null))
                .orElseThrow(() -> new NullPointerException("Menu n�o encontrado"));
    }

    @Override
    public List<Menu> alterarMenus(List<Menu> menus) {
        return Optional
                .ofNullable(Util.isListaObjVazia(menus))
                .map(listaValidada-> menusRepository.saveAll(menus))
                .orElseThrow(()-> new NullPointerException("Informe pelo menos um menu para ser alterado"));
    }

    @Override
    public Menu alterarMenus(Menu menu, Integer id) {
        return Optional
                .ofNullable(menusRepository.findById(id).orElse(null))
                .map(menuConsultado-> {
                    menu.setMenIden(menuConsultado.getMenIden());
                    return menusRepository.save(menu);
                }).orElseThrow(()-> new NullPointerException("N�o foi poss�vel realizar a altera��o"));
    }

    @Override
    public ResponseEntity deletarMenus(Integer id) {
        return Optional
                .ofNullable(menusRepository.findById(id).orElse(null))
                .map(menuConsultado-> {
                    menusRepository.delete(menuConsultado);
                    return ResponseEntity.ok("Registro exclu�do");
                }).orElseThrow(()-> new NullPointerException("Menu n�o encontrado para exclus�o"));
    }
}
