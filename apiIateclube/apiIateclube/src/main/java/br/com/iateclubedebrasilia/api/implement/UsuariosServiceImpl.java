package br.com.iateclubedebrasilia.api.implement;

import br.com.iateclubedebrasilia.api.entitys.Usuarios;
import br.com.iateclubedebrasilia.api.repositorys.UsuariosRepository;
import br.com.iateclubedebrasilia.api.services.UsuariosService;
import br.com.iateclubedebrasilia.api.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public ResponseEntity salvar(Usuarios usuario) {
        return Optional
                .ofNullable(usuariosRepository.save(usuario))
                .map(Usuariosalvo->{
                    Map<String, Usuarios> resposta =  new HashMap<>();
                    resposta.put("Registro salvo", Usuariosalvo);
                    return  ResponseEntity.ok(resposta);
                }).orElseThrow(()-> new NullPointerException( "Não foi possível realizar o cadastro!"));
    }

    @Override
    public List<Usuarios> listar(){
        return Optional
                .ofNullable(usuariosRepository.findAll())
                .orElseThrow(() -> new NullPointerException("Não exitem Usuarios cadastrados"));
    }

    @Override
    public Usuarios pesquisarUsuario(Integer id) {
        return Optional
                .ofNullable(id)
                .map(idConsultado->usuariosRepository.findById(idConsultado).orElse(null))
                .orElseThrow(() -> new NullPointerException("Usuario não encontrado"));
    }

    @Override
    public ResponseEntity deletarUsuario(Integer id) {
        return Optional
                .ofNullable(usuariosRepository.findById(id).orElse(null))
                .map(usuarioConsultado-> {
                    usuariosRepository.delete(usuarioConsultado);
                    return ResponseEntity.ok("Registro excluído");
                }).orElseThrow(()-> new NullPointerException("Usuario não encontrado para exclusão"));
    }

    @Override
    public List<Usuarios> alterarUsuarios(List<Usuarios> listaDeUsuarios) {
        return Optional
                .ofNullable(Util.isListaObjVazia(listaDeUsuarios))
                .map(listaValidada-> usuariosRepository.saveAll(listaDeUsuarios))
                .orElseThrow(()-> new NullPointerException("Informe pelo menos um usuario para ser alterado"));
    }

    @Override
    public Usuarios alterarUsuario(Usuarios usuario, Integer id){
        return Optional
                .ofNullable(usuariosRepository.findById(id).orElse(null))
                .map(usuarioConsultado-> {
                    usuario.setUsuIden(usuarioConsultado.getUsuIden());
                    return usuariosRepository.save(usuario);
                }).orElseThrow(()-> new NullPointerException("Não foi possível realizar a alteração"));

    }
}
