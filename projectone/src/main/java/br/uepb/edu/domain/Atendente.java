package br.uepb.edu.domain;

import java.time.LocalDateTime;
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

    public void registrarEmprestimo(Leitor leitor, Livro livro) {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDate(LocalDateTime.now());
        emprestimo.setSituacao(EmprestimoSituacao.ATIVO);
        LinhaDoEmprestimo linha = new LinhaDoEmprestimo();
        linha.setDataPrevistaDevolucao(LocalDateTime.now().plusDays(7));
        List<LinhaDoEmprestimo> linhasDoEmprestimo = new ArrayList<>();
        linhasDoEmprestimo.add(linha);
        emprestimo.setLinhasDoEmprestimo(linhasDoEmprestimo);

        leitor.getEmprestimos().add(emprestimo);
        livro.getCopiaDoLivro().setSituacao(CopiaDoLivroSituacao.INDISPONIVEL);
    }

    public void registrarDevolucao(Leitor leitor, Livro livro) {
        Emprestimo emprestimo = null;
        for (Emprestimo emp : leitor.getEmprestimos()) {
            if (emp.getSituacao() == EmprestimoSituacao.ATIVO) {
                emprestimo = emp;
                break;
            }
        }

        if (emprestimo != null) {
            LinhaDoEmprestimo linha = emprestimo.getLinhasDoEmprestimo().get(0);
            linha.setDataRealDevolucao(LocalDateTime.now());
            emprestimo.setSituacao(EmprestimoSituacao.CONCLUIDO);
            livro.getCopiaDoLivro().setSituacao(CopiaDoLivroSituacao.DISPONIVEL);
        }
    }

    public void criarReserva(Leitor leitor, Livro livro) {
        Reserva reserva = new Reserva();
        reserva.setPeriodo(30);
        reserva.setSituacao(ReservaSituacao.ATIVO);
        CopiaDoLivro copiaDoLivro = livro.getCopiaDoLivro();
        reserva.setCopiaDoLivro(copiaDoLivro);

        leitor.getReservas().add(reserva);
    }

    public void cancelarReserva(Leitor leitor, Livro livro) {
        List<Reserva> reservas = leitor.getReservas();
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getCopiaDoLivro() == livro.getCopiaDoLivro()) {
                reservas.remove(i);
                i--;
            }
        }
    }
    public List<Livro> pesquisarLivros(String termoDePesquisa) {
        List<Livro> resultados = new ArrayList<>();
        for (Livro livro : estoque) {
            if (livro.getTitulo().contains(termoDePesquisa) || livro.getAutor().contains(termoDePesquisa)) {
                resultados.add(livro);
            }
        }
        return resultados;
    }

    public CopiaDoLivroSituacao verificarStatusLivro(Livro livro) {

        return livro.getCopiaDoLivro().getSituacao();
    }
    public void adicionarLivroAoEstoque(Livro livro) {
        estoque.add(livro);
    }

    public void removerLivroDoEstoque(Livro livro) {
        estoque.remove(livro);}
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Livro> getEstoque() {
        return estoque;
    }

    public void setEstoque(List<Livro> Estoque) {
        this.estoque = estoque;
    }

    @Override
    public void realizarAtendimento() {
        System.out.println("Atendente realizando atendimento padrão.");
    }
}