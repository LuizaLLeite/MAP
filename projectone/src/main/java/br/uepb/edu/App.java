package br.uepb.edu;

import br.uepb.edu.domain.*;
import br.uepb.edu.domain.Interfaces.OperacaoDeEmprestimo;
import br.uepb.edu.domain.Padroes.AtendenteFacade;
import br.uepb.edu.domain.Padroes.LivroBuilder;
import br.uepb.edu.domain.Padroes.ProxyDeEmprestimo;


import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Livro livro = new LivroBuilder()
                .withTitulo("Título do Livro")
                .withAutor("Autor do Livro")
                .withAno(2020)
                .withISBN("1234567890")
                .withEditora("Editora do Livro")
                .withCopiaDoLivro(new CopiaDoLivro())
                .withTipo(LivroTipo.DIDATICO)
                .build();

        // Imprima informações do livro
        System.out.println("Informações do Livro:");
        System.out.println("Título: " + livro.getTitulo());
        System.out.println("Autor: " + livro.getAutor());
        System.out.println("Ano de Publicação: " + livro.getAno());
        System.out.println("ISBN: " + livro.getIsbn());
        System.out.println("Cópia: " + livro.getCopiaDoLivro());
        System.out.println("Editora: " + livro.getEditora());
        System.out.println("Tipo: " + livro.getTipo());
    }
}