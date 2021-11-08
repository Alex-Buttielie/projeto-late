package br.com.iateclubedebrasilia.api.services;

import br.com.iateclubedebrasilia.api.entitys.Usuario;
import br.com.iateclubedebrasilia.api.repositorys.UsuarioRepository;
import br.com.iateclubedebrasilia.api.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usu = usuarioRepository.findByUsuLogin(login);
        if (usu == null){
            throw new UsernameNotFoundException(login);
        }
        return new UserSS(usu.getUsuIden(), usu.getUsuLogin(), usu.getUsuEmail(), usu.getUsuSenha(), usu.getGruposUsuario());
    }
}
