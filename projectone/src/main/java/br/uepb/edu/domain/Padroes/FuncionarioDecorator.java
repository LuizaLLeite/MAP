package br.uepb.edu.domain.Padroes;

import br.uepb.edu.domain.Interfaces.Funcionario;

public class FuncionarioDecorator implements Funcionario {
    private Funcionario funcionarioBase;

    public FuncionarioDecorator(Funcionario funcionarioBase) {
        this.funcionarioBase = funcionarioBase;
    }

    @Override
    public void realizarAtendimento() {
        System.out.println("Atendente realizando atendimento padrão.");
    }
}
