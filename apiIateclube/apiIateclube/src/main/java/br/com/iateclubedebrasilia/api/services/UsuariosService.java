package br.com.iateclubedebrasilia.api.services;

import br.com.iateclubedebrasilia.api.entitys.Usuario;
import br.com.iateclubedebrasilia.api.repositorys.UsuarioRepository;
import br.com.iateclubedebrasilia.api.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UsuariosService {


    @Autowired
    private BCryptPasswordEncoder pe;

    private UsuarioRepository usuarioRepository;

    public UsuariosService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public ResponseEntity salvar(Usuario usuario) {
        return Optional
                .ofNullable(definirSenhaUsuarioESalvar(usuario))
                .map(usuariosalvo ->{
                    Map<String, Usuario> resposta =  new HashMap<>();
                    resposta.put("Registro salvo", usuariosalvo);
                    return  ResponseEntity.ok(resposta);
                }).orElseThrow(()-> new NullPointerException( "Nao foi possivel realizar o cadastro!"));
    }

    private Usuario definirSenhaUsuarioESalvar(Usuario usuario) {

        return Optional.ofNullable(usuario)
                .map(user -> setSenhaSalvaUsuer(user))
                .orElse(null);

    }

    private Usuario setSenhaSalvaUsuer(Usuario user) {
        String newPass = Util.newPassword();
        user.setUsuSenha(pe.encode(newPass));
        return usuarioRepository.save(user);
    }

    public List<Usuario> listar(){
        return Optional
                .ofNullable(usuarioRepository.findAll())
                .orElseThrow(() -> new NullPointerException("Nao exitem Usuarios cadastrados"));
    }

    public Usuario pesquisarUsuario(Integer id) {
        return Optional
                .ofNullable(id)
                .map(idConsultado-> usuarioRepository.findById(idConsultado).orElse(null))
                .orElseThrow(() -> new NullPointerException("Usuario nao encontrado"));
    }

    public ResponseEntity deletarUsuario(Integer id) {
        return Optional
                .ofNullable(usuarioRepository.findById(id).orElse(null))
                .map(usuarioConsultado-> {
                    usuarioRepository.delete(usuarioConsultado);
                    return ResponseEntity.ok("Registro excluíudo");
                }).orElseThrow(()-> new NullPointerException("Usuario nao encontrado para exclus�o"));
    }

    public List<Usuario> alterarUsuarios(List<Usuario> listaDeUsuarios) {
        return Optional
                .ofNullable(Util.isListaObjVazia(listaDeUsuarios))
                .map(listaValidada-> usuarioRepository.saveAll(listaDeUsuarios))
                .orElseThrow(()-> new NullPointerException("Informe pelo menos um usuario para ser alterado"));
    }

    public Usuario alterarUsuario(Usuario usuario, Integer id){
        return Optional
                .ofNullable(usuarioRepository.findById(id).orElse(null))
                .map(usuarioConsultado-> {
                    usuario.setUsuIden(usuarioConsultado.getUsuIden());
                    return usuarioRepository.save(usuario);
                }).orElseThrow(()-> new NullPointerException("Nao foi possivel realizar a alteracao"));

    }


}
