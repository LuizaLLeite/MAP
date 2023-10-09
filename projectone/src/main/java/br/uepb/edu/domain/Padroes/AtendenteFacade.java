package br.uepb.edu.domain.Padroes;

import br.uepb.edu.domain.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AtendenteFacade {
    private Atendente atendente;

    public AtendenteFacade(Atendente atendente) {
        this.atendente = atendente;
    }

    public void emprestarLivro(Leitor leitor, Livro livro) {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDate(LocalDateTime.now());
        emprestimo.setSituacao(EmprestimoSituacao.ATIVO);
        LinhaDoEmprestimo linha = new LinhaDoEmprestimo();
        linha.setDataPrevistaDevolucao(LocalDateTime.now().plusDays(7));
        List<LinhaDoEmprestimo> linhasDoEmprestimo = new ArrayList<>();
        linhasDoEmprestimo.add(linha);
        emprestimo.setLinhasDoEmprestimo(linhasDoEmprestimo);

        leitor.getEmprestimos().add(emprestimo);
        livro.getCopiaDoLivro().setSituacao(CopiaDoLivroSituacao.INDISPONIVEL);
    }

    public void registrarDevolucao(Leitor leitor, Livro livro) {
        atendente.registrarDevolucao(leitor, livro);
    }

    public void adicionarLivro(Livro livro) {
        atendente.adicionarLivroAoEstoque(livro);
    }

    public void removerLivro(Livro livro) {
        atendente.removerLivroDoEstoque(livro);
    }

    public void criarReserva(Leitor leitor, Livro livro) {
        atendente.criarReserva(leitor, livro);
    }

    public void cancelarReserva(Leitor leitor, Livro livro) {
        atendente.cancelarReserva(leitor, livro);
    }

    public CopiaDoLivroSituacao verificarStatusLivro(Livro livro) {
        return atendente.verificarStatusLivro(livro);
    }

    public List<Livro> pesquisarLivros(String termoDePesquisa) {
        return atendente.pesquisarLivros(termoDePesquisa);
    }

    public String getNomeAtendente() {
        return atendente.getNome();
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }
    public List<Livro> getEstoque() {
        return atendente.getEstoque();
    }
}