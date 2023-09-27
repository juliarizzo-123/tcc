package br.com.JGgaragem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/PaginaPrincipal")
public class PrincipalController {

    @GetMapping
    public String carregarPaginaPrincipal(){

        return "principal/paginaPrincipal";
    }



}
