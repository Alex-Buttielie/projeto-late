package br.com.iateclubedebrasilia.api.services;

import br.com.iateclubedebrasilia.api.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private JavaMailSender mailSender;

    public String sendEmail(SimpleMailMessage msg){ return null;}

    @Override
    public String sendNewPasswordEmail(Usuario usuario, String newPass) {
        return sendMail(usuario, newPass);
    }

    public String sendMail(Usuario usuario, String newPass) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Solicitação de nova senha");
        message.setText("Olá! Sua nova senha é: " + usuario.getSenha());
        message.setTo(usuario.getEmail());
        message.setFrom(usuario.getEmail());
        message.setSentDate(new Date(System.currentTimeMillis()));

        try {

            enviarEmail(message);
            return "Email enviado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar email.";
        }
    }

    public void enviarEmail(SimpleMailMessage message) {
        mailSender.send(message);
    }

}
