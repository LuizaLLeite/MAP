public class ParadidaticoFactory implements LivroFactory{
    @Override
    public Livro criarLivro() {
        return new paradidatico();
    }
}