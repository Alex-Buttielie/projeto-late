package br.com.iateclubedebrasilia.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import java.sql.PreparedStatement;

public class SmtpEmailService extends AbstractEmailService{

    @Autowired
    private MailSender mailSender;

    private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);

    @Override
    public String sendEmail(SimpleMailMessage msg) {
        try{
            LOG.info("Enviando email...");
            mailSender.send(msg);
            return "E-mail enviado";
        } catch (Exception e ){
            LOG.info("Problema ao enviar e-email");
            return "Problema ao enviar e-email";
        }

    }
}
