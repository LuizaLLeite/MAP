package br.uepb.edu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livro {
    private String titulo;
    private String autor;
    private int ano;
    private String isbn;
    private String editora;
    private LivroTipo tipo;
    private CopiaDoLivro copiaDoLivro;

    public void inicializarCopiaDoLivro() {
        copiaDoLivro = new CopiaDoLivro();
        copiaDoLivro.setSituacao(CopiaDoLivroSituacao.DISPONIVEL);
    }


    public Livro(String autor){this.autor=autor;}

    public Livro(int ano) {this.ano = ano;}

    public CopiaDoLivro getCopiaDoLivro() {
        return copiaDoLivro;
    }
    public Livro(LivroTipo tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    public String getIsbn() {return isbn;}

    public String getEditora() {
        return editora;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setTipo(LivroTipo tipo) {this.tipo = tipo;
    }
    public LivroTipo getTipo() {
        return tipo;
    }

}