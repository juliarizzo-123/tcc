package br.com.JGgaragem.controller;

import br.com.JGgaragem.domain.usuario.*;
import br.com.JGgaragem.exceptions.ValidacaoExecepition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping("/cadastrarUsuario")
    public String carregaPaginaCadastroUsuario(Long id , Model model){
        if (id != null){
            var usuario = repository.getReferenceById(id);
            model.addAttribute("usuario" , usuario);
        }
        return "/usuarios/formularioUsuario";
    }

    @GetMapping
    public String garregaPaginaListaDeUsuarios(Model model){
        model.addAttribute("lista", repository.findAll());
        return "/usuarios/listaDeUsuarios";
    }
    @PostMapping
    @Transactional
    public  String cadastrarUsuarios(DadosCadastroUsuario dados){
        Usuario usuario = new Usuario(dados);
        if(!repository.findUsuarioByNome(dados.nome())){
            throw new ValidacaoExecepition("Já existe um usuário cadastro com esse nome");
        }
        if(!repository.findUsuarioByCpf(dados.cpf())){
            throw new ValidacaoExecepition("Já existe um usuário cadastro com esse CPF");
        }
        if (!ValidadorCPF.validarCPF(dados.cpf())) {
            throw new ValidacaoExecepition("O CPF é inválido");
        }
        repository.save(usuario);
        return "redirect:/usuarios";
    }

    @DeleteMapping
    @Transactional
    public String ExcluirUsuario(Long id){
        System.out.println("USUARIO EXCLUIDO");
        repository.deleteById(id);
        return "redirect:/usuarios";
    }

    @PutMapping
    @Transactional
    public  String editarUsuario(DadosAlteraUsuarios dados){
        var usuario = repository.getReferenceById(dados.id());
        usuario.atualizaDadosUsuario(dados);
        return "redirect:/usuarios";
    }



}
