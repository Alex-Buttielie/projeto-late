package br.com.iateclubedebrasilia.api.services;

import br.com.iateclubedebrasilia.api.entitys.Usuario;
import br.com.iateclubedebrasilia.api.repositorys.UsuarioRepository;
import br.com.iateclubedebrasilia.api.services.exceptions.ObjectNotFoundException;
import br.com.iateclubedebrasilia.api.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    private EmailService emailService;

    public String sendNewPassword(String login) {

        Usuario usuario = usuarioRepository.findByUsuEmail(login);
        if (usuario == null) {
            throw new ObjectNotFoundException("Email não encontrado");
        }

        String newPass = Util.newPassword();
        usuario.setUsuSenha(pe.encode(newPass));

        usuario = usuarioRepository.save(usuario);
        return emailService.sendNewPasswordEmail(usuario, newPass);
    }

}
