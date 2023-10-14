package br.com.JGgaragem.domain.usuario;


import br.com.JGgaragem.domain.veiculo.DadosAlteraVeiculo;
import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    //depois procurar anotaçao para senha
    private String senha;

    private String cpf;

    private boolean vendedor;


    public Usuario(DadosCadastroUsuario dados){
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
        this.cpf = dados.cpf();
        this.vendedor = dados.vendedor();
    }
    public Usuario() {}

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }



    public void atualizaDadosUsuario(DadosAlteraUsuarios dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
    }
}
