package br.com.iateclubedebrasilia.api.services;

import org.springframework.mail.SimpleMailMessage;

import br.com.iateclubedebrasilia.api.domain.Usuario;

public interface EmailService {

	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Usuario usuario, String newPass);
}
