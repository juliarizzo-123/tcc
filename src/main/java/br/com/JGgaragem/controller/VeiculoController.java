package br.com.JGgaragem.controller;

import br.com.JGgaragem.domain.veiculo.DadosCadastroVeiculo;
import br.com.JGgaragem.domain.veiculo.Veiculo;
import br.com.JGgaragem.domain.veiculo.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired // o spring vai criar esse obj
    private VeiculoRepository repository;

    @GetMapping("cadastrarVeiculo")
    public String carregaPaginaFormulario(Long id , Model model){
        if (id != null){
            var veiculo = repository.getReferenceById(id);
            model.addAttribute("veiculo" , veiculo);

        }
        return "veiculos/formulario";
    }

    @GetMapping    //("/listagemDeVeiculo")
    public String carregaPaginaListagem(Model model){
        model.addAttribute("lista", repository.findAll());
        return "veiculos/listagem";
    }

    @PostMapping
    @Transactional
    public  String cadastrarVeiculo(DadosCadastroVeiculo dados){
        Veiculo veiculo = new Veiculo(dados);
        repository.save(veiculo);
        return "redirect:/veiculos";
    }


    @DeleteMapping
    @Transactional
    public String ExcluirVeiculo(Long id){
        System.out.println("VEICULO EXCLUIDO");
        repository.deleteById(id);
        return "redirect:/veiculos";
    }

    @PutMapping
    @Transactional
    public  String editarVeiculo(DadosAlteraVeiculo dados){
        var veiculo = repository.getReferenceById(dados.id());
        veiculo.atualizaDados(dados);

        return "redirect:/veiculos";
    }


}
