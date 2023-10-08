package br.uepb.edu;

import br.uepb.edu.domain.*;


import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Criação de alguns objetos para testar o sistema
        Leitor leitor1 = new Leitor();
        leitor1.setNome("João");
        leitor1.setTipo(LeitorTipo.ALUNO);

        Livro livro1 = new Livro();
        livro1.setTitulo("Java Programming");
        livro1.setAutor("John Doe");
        livro1.setAno(2022);
        livro1.setIsbn("1234567890");
        livro1.setEditora("Editora A");
        livro1.setTipo(LivroTipo.DIDATICO);
        livro1.inicializarCopiaDoLivro();

        Atendente atendente = new Atendente();
        atendente.setNome("Maria");

        // Adiciona o livro ao catálogo da biblioteca
        atendente.adicionarLivroAoCatalogo(livro1);

        // Realiza um empréstimo
        atendente.registrarEmprestimo(leitor1, livro1);

        // Verifica o status do livro
        CopiaDoLivroSituacao statusLivro = atendente.verificarStatusLivro(livro1);
        System.out.println("Status do livro após o empréstimo: " + statusLivro);

        // Realiza a devolução
        atendente.registrarDevolucao(leitor1, livro1);

        // Verifica o status do livro novamente
        statusLivro = atendente.verificarStatusLivro(livro1);
        System.out.println("Status do livro após a devolução: " + statusLivro);

        // Pesquisa por livros no catálogo
        List<Livro> resultadosPesquisa = atendente.pesquisarLivros("Java");
        System.out.println("Livros encontrados na pesquisa:");
        for (Livro livro : resultadosPesquisa) {
            System.out.println(livro.getTitulo() + " - " + livro.getAutor());
        }

        // Criação de outros leitores
        Leitor leitor2 = new Leitor();
        leitor2.setNome("Alice");
        leitor2.setTipo(LeitorTipo.PROFESSOR);

        Leitor leitor3 = new Leitor();
        leitor3.setNome("Maria");
        leitor3.setTipo(LeitorTipo.FUNCIONARIO);

        // Lista de usuários autorizados para empréstimo
        List<String> usuariosAutorizados = Arrays.asList("João", "Alice");

        // Criação do Proxy de empréstimo
        OperacaoDeEmprestimo proxy = new ProxyDeEmprestimo(new OperacaoDeEmprestimoReal(), usuariosAutorizados);

        // Tentativa de empréstimo por leitores
        proxy.realizarEmprestimo(leitor2, livro1); // Permitido
        proxy.realizarEmprestimo(leitor3, livro1); // Negado
    }
}