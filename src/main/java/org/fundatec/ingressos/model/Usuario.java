package org.fundatec.ingressos.model;

import java.time.LocalDate;
import java.util.Objects;

public class Usuario {
    private String nome;
    private LocalDate dataNascimento;
    private boolean isEstudante;

    public Usuario(String nome, LocalDate dataNascimento, boolean isEstudante) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.isEstudante = isEstudante;
    }

    public String getNome() {
        return nome;
    }


    public LocalDate getDataNascimento() {
        return dataNascimento;
    }


    public boolean isEstudante() {
        return isEstudante;
    }


    public void verificarIdadeParaDesconto(Usuario usuario) {
        LocalDate dataNascimento = usuario.getDataNascimento();
        int anoDeNascimento = dataNascimento.getYear();
        int anoAtual = LocalDate.now().getYear();
        int idade = anoDeNascimento - anoAtual;
        if (idade < 60) {
            throw new RuntimeException("Usuario" + usuario.getNome() + "não possui" +
                    "idade para comprar o ingresso Pista com desconto de 50%");
        }
    }

    public boolean isEtudante(Usuario usuario) {
        if (usuario.isEstudante() == true) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return isEstudante == usuario.isEstudante && Objects.equals(nome, usuario.nome)
                && Objects.equals(dataNascimento, usuario.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataNascimento, isEstudante);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", isEstudante=" + isEstudante +
                '}';
    }
}

