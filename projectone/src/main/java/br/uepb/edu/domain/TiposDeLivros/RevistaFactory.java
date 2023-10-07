public class RevistaFactory implements LivroFactory{
    @Override
    public Livro criarLivro() {
        return new revista();
    }
}