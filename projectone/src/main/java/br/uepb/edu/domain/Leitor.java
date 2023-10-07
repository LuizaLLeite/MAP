package br.uepb.edu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Leitor {
    private String nome;
    private LeitorTipo tipo;
    private List<Reserva> reservas = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();


    public void adicionarReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }


    public void removerReserva(Reserva reserva) {
        this.reservas.remove(reserva);
    }
    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }


    public void removerEmprestimo(Emprestimo emprestimo) {
        Iterator<Emprestimo> iterator = emprestimos.iterator();
        while (iterator.hasNext()) {
            Emprestimo e = iterator.next();
            if (e.equals(emprestimo)) {
                iterator.remove();
                break;
            }
        }
    }


    public List<Emprestimo> getEmprestimosAtivos() {
        List<Emprestimo> emprestimosAtivos = new ArrayList<>();
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getSituacao() == EmprestimoSituacao.ATIVO) {
                emprestimosAtivos.add(emprestimo);
            }
        }
        return emprestimosAtivos;
    }

}
