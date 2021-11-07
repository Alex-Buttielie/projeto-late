package br.com.iateclubedebrasilia.api.services;

import br.com.iateclubedebrasilia.api.entitys.Usuario;
import br.com.iateclubedebrasilia.api.repositorys.UsuarioRepository;
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
    private UsuarioRepository usuarioRepository;

    @Override
    public ResponseEntity salvar(Usuario usuario) {
        return Optional
                .ofNullable(usuarioRepository.save(usuario))
                .map(usuariosalvo ->{
                    Map<String, Usuario> resposta =  new HashMap<>();
                    resposta.put("Registro salvo", usuariosalvo);
                    return  ResponseEntity.ok(resposta);
                }).orElseThrow(()-> new NullPointerException( "N�o foi poss�vel realizar o cadastro!"));
    }

    @Override
    public List<Usuario> listar(){
        return Optional
                .ofNullable(usuarioRepository.findAll())
                .orElseThrow(() -> new NullPointerException("N�o exitem Usuarios cadastrados"));
    }

    @Override
    public Usuario pesquisarUsuario(Integer id) {
        return Optional
                .ofNullable(id)
                .map(idConsultado-> usuarioRepository.findById(idConsultado).orElse(null))
                .orElseThrow(() -> new NullPointerException("Usuario n�o encontrado"));
    }

    @Override
    public ResponseEntity deletarUsuario(Integer id) {
        return Optional
                .ofNullable(usuarioRepository.findById(id).orElse(null))
                .map(usuarioConsultado-> {
                    usuarioRepository.delete(usuarioConsultado);
                    return ResponseEntity.ok("Registro exclu�do");
                }).orElseThrow(()-> new NullPointerException("Usuario n�o encontrado para exclus�o"));
    }

    @Override
    public List<Usuario> alterarUsuarios(List<Usuario> listaDeUsuarios) {
        return Optional
                .ofNullable(Util.isListaObjVazia(listaDeUsuarios))
                .map(listaValidada-> usuarioRepository.saveAll(listaDeUsuarios))
                .orElseThrow(()-> new NullPointerException("Informe pelo menos um usuario para ser alterado"));
    }

    @Override
    public Usuario alterarUsuario(Usuario usuario, Integer id){
        return Optional
                .ofNullable(usuarioRepository.findById(id).orElse(null))
                .map(usuarioConsultado-> {
                    usuario.setUsuIden(usuarioConsultado.getUsuIden());
                    return usuarioRepository.save(usuario);
                }).orElseThrow(()-> new NullPointerException("N�o foi poss�vel realizar a altera��o"));

    }
}
