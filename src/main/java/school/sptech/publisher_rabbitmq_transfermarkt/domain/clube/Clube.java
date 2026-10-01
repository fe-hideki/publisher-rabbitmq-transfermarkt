package school.sptech.publisher_rabbitmq_transfermarkt.domain.clube;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import school.sptech.publisher_rabbitmq_transfermarkt.domain.jogador.Jogador;

@Entity
@Table(name = "clubes")
public class Clube {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String pais;

    @Column(nullable = false)
    private Integer fundacao;

    @OneToMany(mappedBy = "clube", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Jogador> jogadores = new ArrayList<>();

    public Clube() {
    }

    public Clube(String nome, String cidade, String pais, Integer fundacao) {
        this.nome = nome;
        this.cidade = cidade;
        this.pais = pais;
        this.fundacao = fundacao;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getFundacao() {
        return fundacao;
    }

    public void setFundacao(Integer fundacao) {
        this.fundacao = fundacao;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public void adicionarJogador(Jogador jogador) {
        jogadores.add(jogador);
        jogador.setClube(this);
    }
}
