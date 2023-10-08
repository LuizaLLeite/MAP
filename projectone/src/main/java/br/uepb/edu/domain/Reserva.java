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

    public int getPeriodo() {
        return periodo;
    }

    public ReservaSituacao getSituacao() {
        return situacao;
    }

    public CopiaDoLivro getCopiaDoLivro() {
        return copiaDoLivro;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public void setSituacao(ReservaSituacao situacao) {
        this.situacao = situacao;
    }

    public void setCopiaDoLivro(CopiaDoLivro copiaDoLivro) {
        this.copiaDoLivro = copiaDoLivro;
    }
}