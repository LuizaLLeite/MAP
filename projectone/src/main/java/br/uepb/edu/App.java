package br.uepb.edu;

import br.uepb.edu.domain.Livro;
import br.uepb.edu.domain.LivroFactory;
import br.uepb.edu.domain.TiposDeLivros.DidaticoFactory;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        LivroFactory factory = new DidaticoFactory();
        Livro livro = factory.criarLivro();

        System.out.println("Livro Tipo: " + livro.getTipo());

    }
}
