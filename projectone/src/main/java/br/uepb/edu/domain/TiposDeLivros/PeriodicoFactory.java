public class PeriodicoFactory implements LivroFactory{
    @Override
    public Livro criarLivro() {
        return new periodico();
    }
}