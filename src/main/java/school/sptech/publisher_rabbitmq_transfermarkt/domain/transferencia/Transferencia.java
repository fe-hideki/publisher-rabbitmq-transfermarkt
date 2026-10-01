package school.sptech.publisher_rabbitmq_transfermarkt.domain.transferencia;

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
import java.time.LocalDate;
import school.sptech.publisher_rabbitmq_transfermarkt.domain.clube.Clube;
import school.sptech.publisher_rabbitmq_transfermarkt.domain.jogador.Jogador;

@Entity
@Table(name = "transferencias")
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jogador_id", nullable = false)
    private Jogador jogador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clube_origem_id", nullable = false)
    private Clube clubeOrigem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clube_destino_id", nullable = false)
    private Clube clubeDestino;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal valorTransferencia;

    @Column(nullable = false)
    private LocalDate dataTransferencia;

    public Transferencia() {
    }

    public Transferencia(Jogador jogador, Clube clubeOrigem, Clube clubeDestino,
                        BigDecimal valorTransferencia, LocalDate dataTransferencia) {
        this.jogador = jogador;
        this.clubeOrigem = clubeOrigem;
        this.clubeDestino = clubeDestino;
        this.valorTransferencia = valorTransferencia;
        this.dataTransferencia = dataTransferencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Clube getClubeOrigem() {
        return clubeOrigem;
    }

    public void setClubeOrigem(Clube clubeOrigem) {
        this.clubeOrigem = clubeOrigem;
    }

    public Clube getClubeDestino() {
        return clubeDestino;
    }

    public void setClubeDestino(Clube clubeDestino) {
        this.clubeDestino = clubeDestino;
    }

    public BigDecimal getValorTransferencia() {
        return valorTransferencia;
    }

    public void setValorTransferencia(BigDecimal valorTransferencia) {
        this.valorTransferencia = valorTransferencia;
    }

    public LocalDate getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(LocalDate dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }
}
