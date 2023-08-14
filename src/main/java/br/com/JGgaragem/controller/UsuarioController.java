package br.com.JGgaragem.controller;

import br.com.JGgaragem.domain.usuario.DadosAlteraUsuarios;
import br.com.JGgaragem.domain.usuario.DadosCadastroUsuario;
import br.com.JGgaragem.domain.usuario.Usuario;
import br.com.JGgaragem.domain.usuario.UsuarioRepository;
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
