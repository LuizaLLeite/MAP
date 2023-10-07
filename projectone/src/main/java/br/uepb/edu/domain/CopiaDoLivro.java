package br.uepb.edu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CopiaDoLivro {
    private int sequencial;
    private Livro livro;
    private CopiaDoLivroSituacao situacao;
    private LiberacaoEmprestimo liberacaoEmprestimo;


    public void marcarComoDisponivel() {
        this.situacao = CopiaDoLivroSituacao.DISPONIVEL;
    }

    public void marcarComoIndisponivel() {
        this.situacao = CopiaDoLivroSituacao.INDISPONIVEL;
    }


    public void liberarParaEmprestimo() {
        this.liberacaoEmprestimo = LiberacaoEmprestimo.LIBERADO;
    }


    public void bloquearParaEmprestimo() {
        this.liberacaoEmprestimo = LiberacaoEmprestimo.NAO_LIBERADO;
    }
}