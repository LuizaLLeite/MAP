public abstract class LivroBuilder{

    protected Livro livro;
    public LivroBuilder(){
        livro = new Livro();
    }
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