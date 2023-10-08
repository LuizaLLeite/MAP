package br.uepb.edu.domain.TiposDeLivros;

import br.uepb.edu.domain.Livro;
import br.uepb.edu.domain.LivroFactory;
import br.uepb.edu.domain.LivroTipo;


public class RevistaFactory implements LivroFactory {
    @Override
    public Livro criarLivro() {
        return new Livro(LivroTipo.REVISTA);
    }
}