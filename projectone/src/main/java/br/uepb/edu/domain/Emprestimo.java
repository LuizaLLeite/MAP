package br.uepb.edu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emprestimo {
    private LocalDateTime date;
    private EmprestimoSituacao situacao;
    private List<LinhaDoEmprestimo> linhasDoEmprestimo;

    public void adicionarLinhaDoEmprestimo(LinhaDoEmprestimo linhaDoEmprestimo) {
        if (linhasDoEmprestimo == null) {
            linhasDoEmprestimo = new ArrayList<>();
        }
        linhasDoEmprestimo.add(linhaDoEmprestimo);
    }
    public void marcarComoConcluido() {
        this.situacao = EmprestimoSituacao.CONCLUIDO;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public EmprestimoSituacao getSituacao() {
        return situacao;
    }

    public void setSituacao(EmprestimoSituacao situacao) {
        this.situacao = situacao;
    }

    public List<LinhaDoEmprestimo> getLinhasDoEmprestimo() {
        return linhasDoEmprestimo;
    }

    public void setLinhasDoEmprestimo(List<LinhaDoEmprestimo> linhasDoEmprestimo) {
        this.linhasDoEmprestimo = linhasDoEmprestimo;
    }
}




