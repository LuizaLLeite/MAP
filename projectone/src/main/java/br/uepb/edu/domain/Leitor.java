package br.uepb.edu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Leitor {
    private String nome;
    private LeitorTipo tipo;
    private List<Reserva> reservas = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Leitor(String nome, LeitorTipo leitorTipo) {
        this.nome = nome;
        this.tipo = leitorTipo;
    }

    public LeitorTipo getTipo() {
        return tipo;
    }
    public void setTipo(LeitorTipo tipo) {
        this.tipo = tipo;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void adicionarReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }
    public void removerReserva(Reserva reserva) {
        this.reservas.remove(reserva);
    }
    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }
}
