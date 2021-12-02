package br.com.iateclubedebrasilia.api.services;


import br.com.iateclubedebrasilia.api.domain.Usuario;
import br.com.iateclubedebrasilia.api.repositories.UsuarioRepository;
import br.com.iateclubedebrasilia.api.services.exceptions.ObjectNotFoundException;
import br.com.iateclubedebrasilia.api.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    private EmailService emailService;

    public String sendNewPassword(String login) {

        Usuario usuario = usuarioRepository.findByEmail(login);
        if (usuario == null) {
            throw new ObjectNotFoundException("Email não encontrado");
        }

        String newPass = Util.newPassword();
        usuario.setSenha(pe.encode(newPass));

        usuario = usuarioRepository.save(usuario);
        return emailService.sendNewPasswordEmail(usuario, newPass);
    }

}
