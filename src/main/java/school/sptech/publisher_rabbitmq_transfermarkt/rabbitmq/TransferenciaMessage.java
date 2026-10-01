package school.sptech.publisher_rabbitmq_transfermarkt.rabbitmq;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransferenciaMessage {

    private Long jogadorId;
    private String jogadorNome;
    private String clubeOrigem;
    private String clubeDestino;
    private BigDecimal valorTransferencia;
    private LocalDate dataTransferencia;

    public TransferenciaMessage() {
    }

    public TransferenciaMessage(Long jogadorId, String jogadorNome, String clubeOrigem,
                                String clubeDestino, BigDecimal valorTransferencia,
                                LocalDate dataTransferencia) {
        this.jogadorId = jogadorId;
        this.jogadorNome = jogadorNome;
        this.clubeOrigem = clubeOrigem;
        this.clubeDestino = clubeDestino;
        this.valorTransferencia = valorTransferencia;
        this.dataTransferencia = dataTransferencia;
    }

    public Long getJogadorId() {
        return jogadorId;
    }

    public void setJogadorId(Long jogadorId) {
        this.jogadorId = jogadorId;
    }

    public String getJogadorNome() {
        return jogadorNome;
    }

    public void setJogadorNome(String jogadorNome) {
        this.jogadorNome = jogadorNome;
    }

    public String getClubeOrigem() {
        return clubeOrigem;
    }

    public void setClubeOrigem(String clubeOrigem) {
        this.clubeOrigem = clubeOrigem;
    }

    public String getClubeDestino() {
        return clubeDestino;
    }

    public void setClubeDestino(String clubeDestino) {
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
