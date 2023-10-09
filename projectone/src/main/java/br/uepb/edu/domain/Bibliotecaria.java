package br.uepb.edu.domain;

import br.uepb.edu.domain.Interfaces.Funcionario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bibliotecaria implements Funcionario {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void marcarLivroComoDisponivel(CopiaDoLivro copiaDoLivro) {
        copiaDoLivro.marcarComoDisponivel();
    }


    public void marcarLivroComoIndisponivel(CopiaDoLivro copiaDoLivro) {
        copiaDoLivro.marcarComoIndisponivel();
    }


    public void liberarCopiaParaEmprestimo(CopiaDoLivro copiaDoLivro) {
        copiaDoLivro.liberarParaEmprestimo();
    }


    public void bloquearCopiaParaEmprestimo(CopiaDoLivro copiaDoLivro) {
        copiaDoLivro.bloquearParaEmprestimo();
    }

    @Override
    public void realizarAtendimento() {
    }
}