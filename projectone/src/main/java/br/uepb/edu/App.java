package br.uepb.edu;

import br.uepb.edu.domain.*;
import br.uepb.edu.domain.Interfaces.OperacaoDeEmprestimo;
import br.uepb.edu.domain.Padroes.AtendenteFacade;
import br.uepb.edu.domain.Padroes.ProxyDeEmprestimo;


import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {

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


        atendente.adicionarLivroAoCatalogo(livro1);


        atendente.registrarEmprestimo(leitor1, livro1);


        CopiaDoLivroSituacao statusLivro = atendente.verificarStatusLivro(livro1);
        System.out.println("Status do livro após o empréstimo: " + statusLivro);


        atendente.registrarDevolucao(leitor1, livro1);


        statusLivro = atendente.verificarStatusLivro(livro1);
        System.out.println("Status do livro após a devolução: " + statusLivro);


        List<Livro> resultadosPesquisa = atendente.pesquisarLivros("Java");
        System.out.println("Livros encontrados na pesquisa:");
        for (Livro livro : resultadosPesquisa) {
            System.out.println(livro.getTitulo() + " - " + livro.getAutor());
        }


        Leitor leitor2 = new Leitor();
        leitor2.setNome("Alice");
        leitor2.setTipo(LeitorTipo.PROFESSOR);

        Leitor leitor3 = new Leitor();
        leitor3.setNome("Maria");
        leitor3.setTipo(LeitorTipo.FUNCIONARIO);


        List<String> usuariosAutorizados = Arrays.asList("João", "Alice");


        OperacaoDeEmprestimo proxy = new ProxyDeEmprestimo(new OperacaoDeEmprestimoReal(), usuariosAutorizados);


        proxy.realizarEmprestimo(leitor2, livro1);
        proxy.realizarEmprestimo(leitor3, livro1);


        AtendenteFacade atendenteFacade = new AtendenteFacade(atendente);


        Leitor leitor = new Leitor();
        leitor.setNome("Nome do Leitor");
        leitor.setTipo(LeitorTipo.ALUNO);

        Livro livro = new Livro();
        livro.setTitulo("Título do Livro");
        livro.setAutor("Autor do Livro");
        livro.setAno(2022);
        livro.setIsbn("ISBN do Livro");
        livro.setEditora("Editora do Livro");
        livro.setTipo(LivroTipo.DIDATICO);
        livro.inicializarCopiaDoLivro();


        atendenteFacade.emprestarLivro(leitor, livro);
        System.out.println("Empréstimo realizado com sucesso.");

        atendenteFacade.registrarDevolucao(leitor, livro);
        System.out.println("Devolução registrada com sucesso.");

        atendenteFacade.adicionarLivroAoCatalogo(livro);
        System.out.println("Livro adicionado ao catálogo com sucesso.");

        atendenteFacade.removerLivroDoCatalogo(livro);
        System.out.println("Livro removido do catálogo com sucesso.");

        atendenteFacade.criarReserva(leitor, livro);
        System.out.println("Reserva criada com sucesso.");

        atendenteFacade.cancelarReserva(leitor, livro);
        System.out.println("Reserva cancelada com sucesso.");

        CopiaDoLivroSituacao statusLivro2 = atendenteFacade.verificarStatusLivro(livro);
        System.out.println("Status do livro após operações: " + statusLivro2);

        List<Livro> resultadosPesquisa2 = atendenteFacade.pesquisarLivros("Java");
        System.out.println("Resultados da pesquisa: ");
        for (Livro resultado : resultadosPesquisa2) {
            System.out.println(resultado.getTitulo() + " - " + resultado.getAutor());
        }
    }
}