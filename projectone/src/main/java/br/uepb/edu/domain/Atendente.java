package br.uepb.edu.domain;

import java.util.ArrayList;
import java.util.List;
import br.uepb.edu.domain.Interfaces.Funcionario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Atendente implements Funcionario {
    private String nome;
    private List<Livro> estoque = new ArrayList<>();

    public CopiaDoLivroSituacao verificarStatusLivro(Livro livro) {
        return livro.getCopiaDoLivro().getSituacao();
    }

    public void adicionarLivroAoEstoque(Livro livro) {
        estoque.add(livro);
    }

    public void removerLivroDoEstoque(Livro livro) {
        estoque.remove(livro);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Livro> getEstoque() {
        return estoque;
    }

    public void setEstoque(List<Livro> estoque) {
        this.estoque = estoque;
    }

    @Override
    public void realizarAtendimento() {
    }
}