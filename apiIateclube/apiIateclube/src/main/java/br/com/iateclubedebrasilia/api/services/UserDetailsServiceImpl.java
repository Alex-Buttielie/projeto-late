package br.com.iateclubedebrasilia.api.services;

import br.com.iateclubedebrasilia.api.dto.UsuarioDTO;
import br.com.iateclubedebrasilia.api.entitys.Grupo;
import br.com.iateclubedebrasilia.api.entitys.Usuario;
import br.com.iateclubedebrasilia.api.repositorys.UsuarioRepository;
import br.com.iateclubedebrasilia.api.security.UserSS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import br.com.iateclubedebrasilia.api.domain.Usuario;
import br.com.iateclubedebrasilia.api.repositories.UsuarioRepository;
import br.com.iateclubedebrasilia.api.security.UserSS;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    /*
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        //Usuario usu = usuarioRepository.findByUsuEmail(login);
        UsuarioDTO usu = new UsuarioDTO(1, "admin.login", "admin@gmail.com", "admin", "admin", null );
        if (usu == null){
            throw new UsernameNotFoundException(login);
        }
        //return new UserSS(usu.getUsuIden(), usu.getUsuEmail(), usu.getUsuSenha(), usu.getGruposUsuario());

        return new UserSS(usu.getId(), usu.getEmail(), usu.getSenha(), null);
    }*/

	@Autowired
	private UsuarioRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario cli = repo.findByEmail(email);
		if (cli == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(cli.getId(), cli.getEmail(), cli.getSenha(), cli.getPerfis());
	}

}
