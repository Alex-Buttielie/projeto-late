package br.com.iateclubedebrasilia.api.services;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.iateclubedebrasilia.api.security.UserSS;

public class UserService {
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}
