package br.uepb.edu.domain;

import br.uepb.edu.domain.Interfaces.OperacaoDeEmprestimo;

public class OperacaoDeEmprestimoReal implements OperacaoDeEmprestimo {
    @Override
    public void realizarEmprestimo(Leitor leitor, Livro livro) {
        System.out.println("Empréstimo realizado: " + livro.getTitulo() + " para " + leitor.getNome());
    }
}