package br.com.iateclubedebrasilia.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/permissoesController")
public class PermissoesController {

    @Autowired
    PermissoesController permissoesController;
}