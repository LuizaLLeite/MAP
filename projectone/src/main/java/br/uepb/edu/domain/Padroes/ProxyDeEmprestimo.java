package br.uepb.edu.domain.Padroes;

import br.uepb.edu.domain.Interfaces.OperacaoDeEmprestimo;
import br.uepb.edu.domain.Leitor;
import br.uepb.edu.domain.Livro;

import java.util.List;

public class ProxyDeEmprestimo implements OperacaoDeEmprestimo {
    private OperacaoDeEmprestimo operacaoReal;
    private List<String> usuariosAutorizados;

    public ProxyDeEmprestimo(OperacaoDeEmprestimo operacaoReal, List<String> usuariosAutorizados) {
        this.operacaoReal = operacaoReal;
        this.usuariosAutorizados = usuariosAutorizados;
    }

    @Override
    public void realizarEmprestimo(Leitor leitor, Livro livro) {
        if (usuariosAutorizados.contains(leitor.getNome())) {
            operacaoReal.realizarEmprestimo(leitor, livro);
        } else {
            System.out.println("Acesso negado para " + leitor.getNome());
        }
    }
}