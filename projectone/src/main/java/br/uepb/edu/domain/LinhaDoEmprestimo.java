package br.uepb.edu.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinhaDoEmprestimo {
    private LocalDateTime dataPrevistaDevolucao;
    private LocalDateTime dataRealDevolucao;

    public LocalDateTime getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(LocalDateTime dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }
    public LocalDateTime getDataRealDevolucao() {
        return dataRealDevolucao;
    }
    public void setDataRealDevolucao(LocalDateTime dataRealDevolucao) {
        this.dataRealDevolucao = dataRealDevolucao;
    }

    public void registrarDataRealDevolucao(LocalDateTime dataRealDevolucao) {
        this.dataRealDevolucao = dataRealDevolucao;
    }
}