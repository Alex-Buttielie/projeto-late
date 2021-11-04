package br.com.iateclubedebrasilia.api.implement;

import br.com.iateclubedebrasilia.api.entitys.Menus;
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
    public ResponseEntity<Map<String, Menus>> salvar(Menus menu) {
        return Optional
                .ofNullable(menusRepository.save(menu))
                .map(menuSalvo->{
                    Map<String, Menus> resposta =  new HashMap<>();
                    resposta.put("Registro salvo", menuSalvo);
                    return  ResponseEntity.ok(resposta);
                }).orElseThrow(()-> new NullPointerException( "Não foi possível realizar o cadastro!"));
    }

    @Override
    public List<Menus> listar() {
        return Optional
                .ofNullable(menusRepository.findAll())
                .orElseThrow(() -> new NullPointerException("Não exitem menus cadastrados"));
    }

    @Override
    public Menus pesquisarMenu(Integer id) {
        return Optional
                .ofNullable(id)
                .map(idConsultado->menusRepository.findById(idConsultado).orElse(null))
                .orElseThrow(() -> new NullPointerException("Menu não encontrado"));
    }

    @Override
    public List<Menus> alterarMenus(List<Menus> menus) {
        return Optional
                .ofNullable(Util.isListaObjVazia(menus))
                .map(listaValidada-> menusRepository.saveAll(menus))
                .orElseThrow(()-> new NullPointerException("Informe pelo menos um menu para ser alterado"));
    }

    @Override
    public Menus alterarMenus(Menus menu, Integer id) {
        return Optional
                .ofNullable(menusRepository.findById(id).orElse(null))
                .map(menuConsultado-> {
                    menu.setMenIden(menuConsultado.getMenIden());
                    return menusRepository.save(menu);
                }).orElseThrow(()-> new NullPointerException("Não foi possível realizar a alteração"));
    }

    @Override
    public ResponseEntity deletarMenus(Integer id) {
        return Optional
                .ofNullable(menusRepository.findById(id).orElse(null))
                .map(menuConsultado-> {
                    menusRepository.delete(menuConsultado);
                    return ResponseEntity.ok("Registro excluído");
                }).orElseThrow(()-> new NullPointerException("Menu não encontrado para exclusão"));
    }
}
