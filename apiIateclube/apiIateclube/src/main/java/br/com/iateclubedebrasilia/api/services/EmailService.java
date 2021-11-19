package br.com.iateclubedebrasilia.api.services;

import br.com.iateclubedebrasilia.api.entitys.Usuario;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {

    String sendEmail(SimpleMailMessage msg);

    String sendNewPasswordEmail(Usuario usuario, String newPass);
}
