package br.uepb.edu.domain;

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