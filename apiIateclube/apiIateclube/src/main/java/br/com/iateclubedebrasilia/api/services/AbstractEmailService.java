package br.com.iateclubedebrasilia.api.services;

import br.com.iateclubedebrasilia.api.domain.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;

public class AbstractEmailService{
    @Value("${default.sender}")
    private String sender;

    public String sendEmail(SimpleMailMessage msg) {
        return null;
    }

    public String sendNewPasswordEmail(Usuario usuario, String newPass) {
        SimpleMailMessage sm = prepareNewPasswordEmail(usuario, newPass);
        return sendEmail(sm);
    }

    protected SimpleMailMessage prepareNewPasswordEmail(Usuario usuario, String newPass) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(usuario.getEmail());
        sm.setFrom(sender);
        sm.setSubject("Solicitação de nova senha");
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText("Nova senha: " + newPass);
        return sm;
    }
}
