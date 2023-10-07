public class ReferenciaFactory implements LivroFactory{
    @Override
    public Livro criarLivro() {
        return new referencia();
    }
}