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


    public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void setSituacao(CopiaDoLivroSituacao situacao) {
        this.situacao = situacao;
    }

    public void setLiberacaoEmprestimo(LiberacaoEmprestimo liberacaoEmprestimo) {
        this.liberacaoEmprestimo = liberacaoEmprestimo;
    }

    public int getSequencial() {
        return sequencial;
    }

    public Livro getLivro() {
        return livro;
    }

    public CopiaDoLivroSituacao getSituacao() {
        return situacao;
    }

    public LiberacaoEmprestimo getLiberacaoEmprestimo() {
        return liberacaoEmprestimo;
    }


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