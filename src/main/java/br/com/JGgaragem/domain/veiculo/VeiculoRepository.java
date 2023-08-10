package br.com.JGgaragem.domain.veiculo;

import org.springframework.data.jpa.repository.JpaRepository;

//a interface vai acessar a tabela de veiculos
// como a interface esta herdando JpaRepository nao preciso criar metodos CRUD (Create, read, update, delete)
// pois na JpaRepository ja se tem esses metodos
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
