package br.com.iateclubedebrasilia.api.resources;

import br.com.iateclubedebrasilia.api.dto.EmailDTO;
import br.com.iateclubedebrasilia.api.security.JWTUtil;
import br.com.iateclubedebrasilia.api.security.UserSS;
import br.com.iateclubedebrasilia.api.services.AuthService;

import br.com.iateclubedebrasilia.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthService service;

    @RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
    public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
        UserSS user = UserService.authenticated();
        String token = jwtUtil.generateToken(user.getUsername());
        response.addHeader("Authorization", "Bearer " + token);
        response.addHeader("access-control-expose-headers", "Authorization");
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/forgot", method = RequestMethod.POST)
    public ResponseEntity<String> forgot(@Valid @RequestBody EmailDTO objDto) {
        return ResponseEntity.ok().body(service.sendNewPassword(objDto.getEmail()));
    }
}
