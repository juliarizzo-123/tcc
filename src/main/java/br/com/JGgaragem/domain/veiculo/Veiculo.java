package br.com.JGgaragem.domain.veiculo;

import jakarta.persistence.*;

@Entity
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoDoVeiculo;
    private String marca;
    private String modelo;
    private Integer ano;
    private String cor;
    private Double preco;
    private Double quilometragem;
    private String combustivel;
    private String cambio;
    private Double motor;

    public Veiculo(DadosCadastroVeiculo dados) {
        this.tipoDoVeiculo = dados.tipo();
        this.marca = dados.marca();
        this.modelo = dados.modelo();
        this.ano = dados.ano();
        this.cor = dados.cor();
        this.preco = dados.preco();
        this.quilometragem = dados.quilometragem();
        this.combustivel = dados.combustivel();
        this.cambio = dados.cambio();
        this.motor = dados.motor();

    }

    public Veiculo() {}

    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", tipoDoVeiculo='" + tipoDoVeiculo + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", cor='" + cor + '\'' +
                ", preco=" + preco +
                ", quilometragem=" + quilometragem +
                ", combustivel='" + combustivel + '\'' +
                ", cambio='" + cambio + '\'' +
                ", motor=" + motor +
                '}';
    }

    public String getTipoDoVeiculo() {
        return tipoDoVeiculo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public String getCor() {
        return cor;
    }

    public Double getPreco() {
        return preco;
    }

    public Long getId() {
        return id;
    }

    public Double getQuilometragem() {
        return quilometragem;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public String getCambio() {
        return cambio;
    }

    public Double getMotor() {
        return motor;
    }

    public void atualizaDados(DadosAlteraVeiculo dados) {
        this.tipoDoVeiculo = dados.tipo();
        this.marca = dados.marca();
        this.modelo = dados.modelo();
        this.ano = dados.ano();
        this.cor = dados.cor();
        this.preco = dados.preco();
        this.quilometragem = dados.quilometragem();
        this.combustivel = dados.combustivel();
        this.cambio = dados.cambio();
        this.motor = dados.motor();
    }
}
