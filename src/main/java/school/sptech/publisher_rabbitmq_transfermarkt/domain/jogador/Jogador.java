package school.sptech.publisher_rabbitmq_transfermarkt.domain.jogador;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import school.sptech.publisher_rabbitmq_transfermarkt.domain.clube.Clube;

@Entity
@Table(name = "jogadores")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String posicao;

    @Column(nullable = false)
    private Integer idade;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal valorMercado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clube_id", nullable = false)
    @JsonBackReference
    private Clube clube;

    public Jogador() {
    }

    public Jogador(String nome, String posicao, Integer idade, BigDecimal valorMercado, Clube clube) {
        this.nome = nome;
        this.posicao = posicao;
        this.idade = idade;
        this.valorMercado = valorMercado;
        this.clube = clube;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public BigDecimal getValorMercado() {
        return valorMercado;
    }

    public void setValorMercado(BigDecimal valorMercado) {
        this.valorMercado = valorMercado;
    }

    public Clube getClube() {
        return clube;
    }

    public void setClube(Clube clube) {
        this.clube = clube;
    }
}
