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

    public CopiaDoLivro getCopiaDoLivro() {
        return copiaDoLivro;
    }
    public Livro(LivroTipo tipo) {
        this.tipo = tipo;
    }
}
