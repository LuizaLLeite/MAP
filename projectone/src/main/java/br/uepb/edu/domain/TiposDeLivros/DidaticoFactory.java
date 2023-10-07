public class DidaticoFactory implements LivroFactory{
    @Override
    public Livro criarLivro() {
        return new didatico();
    }
}