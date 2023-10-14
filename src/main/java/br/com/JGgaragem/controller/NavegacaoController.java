package br.com.JGgaragem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/navegacao")
public class NavegacaoController {

    @GetMapping("paginaPrincipal")
    public String navegarPaginaPrincipal(){
        return "principal/paginaPrincipal";
    }

    @GetMapping("login")
    public String navegarLogin(){
        return "principal/login";
    }

    @GetMapping("cadastroUsuario")
    public String navegacaoCadastroUsuario(){
        return "principal/cadastroUsuario";
    }
}
