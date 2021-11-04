package br.com.iateclubedebrasilia.api.implement;

import br.com.iateclubedebrasilia.api.entitys.UsuariosGrupos;
import br.com.iateclubedebrasilia.api.repositorys.UsuariosGruposRepository;
import br.com.iateclubedebrasilia.api.services.UsuariosGruposService;
import br.com.iateclubedebrasilia.api.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UsuariosGruposServiceImpl implements UsuariosGruposService {

    @Autowired
    private UsuariosGruposRepository usuariosGruposRepository;

    @Override
    public ResponseEntity<Map<String, UsuariosGrupos>> salvar(UsuariosGrupos usuariosGrupos) {
        return Optional
                .ofNullable(usuariosGruposRepository.save(usuariosGrupos))
                .map(UsuariosGruposSalvos->{
                    Map<String, UsuariosGrupos> resposta =  new HashMap<>();
                    resposta.put("Registro salvo", usuariosGrupos);
                    return  ResponseEntity.ok(resposta);
                }).orElseThrow(()-> new NullPointerException( "N�o foi poss�vel realizar o cadastro!"));
    }

    @Override
    public List<UsuariosGrupos> listar() {
        return Optional
                .ofNullable(usuariosGruposRepository.findAll())
                .orElseThrow(() -> new NullPointerException("N�o exitem grupos cadastrados para o usu�rio"));
    }

    @Override
    public UsuariosGrupos pesquisarUsuariosGrupos(Integer id) {
        return Optional
                .ofNullable(id)
                .map(idConsultado->usuariosGruposRepository.findById(idConsultado).orElse(null))
                .orElseThrow(() -> new NullPointerException("Grupo n�o encontrado"));
    }

    @Override
    public List<UsuariosGrupos> alterarUsuariosGrupos(List<UsuariosGrupos> listaDeUsuariosGrupos) {
        return Optional
                .ofNullable(Util.isListaObjVazia(listaDeUsuariosGrupos))
                .map(listaValidada-> usuariosGruposRepository.saveAll(listaDeUsuariosGrupos))
                .orElseThrow(()-> new NullPointerException("Informe pelo menos um item para ser alterado"));
    }

    @Override
    public UsuariosGrupos alterarUsuariosGrupos(UsuariosGrupos usuariosGrupos, Integer id) {
        return Optional
                .ofNullable(usuariosGruposRepository.findById(id).orElse(null))
                .map(usuariosGruposConsultado-> {
                    usuariosGrupos.setUgrIden(usuariosGruposConsultado.getUgrIden());
                    return usuariosGruposRepository.save(usuariosGrupos);
                }).orElseThrow(()-> new NullPointerException("N�o foi poss�vel realizar a altera��o"));
    }

    @Override
    public ResponseEntity deletarUsuariosGrupos(Integer id) {
        return Optional
                .ofNullable(usuariosGruposRepository.findById(id).orElse(null))
                .map(usuariosGruposConsultado-> {
                    usuariosGruposRepository.delete(usuariosGruposConsultado);
                    return ResponseEntity.ok("Registro exclu�do");
                }).orElseThrow(()-> new NullPointerException("Grupos do usu�rio n�o encontrado para exclus�o"));
    }
}
