package br.com.JGgaragem.domain.usuario;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean findUsuarioByNome(String nome);
    boolean findUsuarioByCpf(String nome);

}
