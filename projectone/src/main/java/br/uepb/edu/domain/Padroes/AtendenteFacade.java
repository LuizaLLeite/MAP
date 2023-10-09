package br.uepb.edu.domain.Padroes;

import br.uepb.edu.domain.*;

import java.util.List;

public class AtendenteFacade {
    private Atendente atendente;

    public AtendenteFacade(Atendente atendente) {
        this.atendente = atendente;
    }
    public void adicionarLivro(Livro livro) {
        atendente.adicionarLivroAoEstoque(livro);
    }

    public void removerLivro(Livro livro) {
        atendente.removerLivroDoEstoque(livro);
    }
    public CopiaDoLivroSituacao verificarStatusLivro(Livro livro) {
        return atendente.verificarStatusLivro(livro);
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