package br.uepb.edu.domain.Padroes;

import br.uepb.edu.domain.CopiaDoLivro;
import br.uepb.edu.domain.Livro;
import br.uepb.edu.domain.LivroTipo;

public class LivroBuilder {
    private String titulo;
    private String autor;
    private int ano;
    private String isbn;
    private String editora;
    private LivroTipo tipo;
    private CopiaDoLivro copiaDoLivro;

    public LivroBuilder withTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public LivroBuilder withAutor(String autor) {
        this.autor = autor;
        return this;
    }

    public LivroBuilder withAno(int ano) {
        this.ano = ano;
        return this;
    }

    public LivroBuilder withISBN(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public LivroBuilder withEditora(String editora) {
        this.editora = editora;
        return this;
    }

    public LivroBuilder withTipo(LivroTipo tipo) {
        this.tipo = tipo;
        return this;
    }

    public LivroBuilder withCopiaDoLivro(CopiaDoLivro copiaDoLivro) {
        this.copiaDoLivro = copiaDoLivro;
        return this;
    }

    public Livro build() {
        return new Livro(titulo, autor, ano, isbn, editora, tipo, copiaDoLivro);
    }
}