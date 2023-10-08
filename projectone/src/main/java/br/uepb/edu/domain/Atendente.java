package br.uepb.edu.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Atendente {
    private String nome;
    private List<Livro> catalogo = new ArrayList<>();

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

    public void adicionarLivroAoCatalogo(Livro livro) {
        catalogo.add(livro);
    }

    public void removerLivroDoCatalogo(Livro livro) {
        catalogo.remove(livro);
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

    public CopiaDoLivroSituacao verificarStatusLivro(Livro livro) {
        return livro.getCopiaDoLivro().getSituacao();
    }

    public List<Livro> pesquisarLivros(String termoDePesquisa) {
        List<Livro> resultados = new ArrayList<>();
        for (Livro livro : catalogo) {
            if (livro.getTitulo().contains(termoDePesquisa) || livro.getAutor().contains(termoDePesquisa)) {
                resultados.add(livro);
            }
        }
        return resultados;
    }

    public String getNome() {
        return nome;
    }

    public List<Livro> getCatalogo() {
        return catalogo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCatalogo(List<Livro> catalogo) {
        this.catalogo = catalogo;
    }
}