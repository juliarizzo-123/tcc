package br.com.JGgaragem.domain.veiculo;

public record DadosAlteraVeiculo(Long id,String tipo, String marca, String modelo, Integer ano, String cor, Double preco,
                                 Double quilometragem, String combustivel, String cambio, Double motor) {
}
