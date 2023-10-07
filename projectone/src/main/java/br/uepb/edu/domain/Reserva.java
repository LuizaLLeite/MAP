package br.uepb.edu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {
    private int periodo;
    private ReservaSituacao situacao;
    private CopiaDoLivro copiaDoLivro;

    public void ativarReserva() {
        this.situacao = ReservaSituacao.ATIVO;
    }

    public void desativarReserva() {
        this.situacao = ReservaSituacao.INATIVO;
    }
}