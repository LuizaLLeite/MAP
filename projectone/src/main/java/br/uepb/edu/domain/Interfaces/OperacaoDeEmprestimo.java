package br.uepb.edu.domain.Interfaces;

import br.uepb.edu.domain.Leitor;
import br.uepb.edu.domain.Livro;

public interface OperacaoDeEmprestimo {
    void realizarEmprestimo(Leitor leitor, Livro livro);
}
