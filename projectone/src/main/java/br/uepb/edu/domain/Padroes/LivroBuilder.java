package br.uepb.edu.domain.Padroes;

import br.uepb.edu.domain.Livro;

public abstract class LivroBuilder{

    protected Livro livro;

    public abstract void buildTitulo();
    public abstract void buildAutor();
    public abstract void buildAno();
    public abstract void buildIsbn();
    public abstract void buildEditora();
    public abstract void buildTipo();

    public Livro getLivro(){
        return livro;
    }

}