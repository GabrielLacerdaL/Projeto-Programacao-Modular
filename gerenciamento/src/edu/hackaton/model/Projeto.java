package br.edu.hackathon.model;

public class Projeto {
    private String nome;
    private Profissional orientador;
    private Equipe equipe;
    private int notaFinal;

    public Projeto(String nome, Profissional orientador, Equipe equipe) {
        if (nome == null || orientador == null || equipe == null) {
            throw new IllegalArgumentException("Nenhum dos parâmetros pode ser nulo");
        }
        this.nome = nome;
        this.orientador = orientador;
        this.equipe = equipe;
        this.notaFinal = -1;
        equipe.setProjeto(this);
    }

    public void setNotaFinal(int notaFinal) {
        if (notaFinal < 0 || notaFinal > 10) {
            throw new IllegalArgumentException("A nota final deve estar entre 0 e 10");
        }
        this.notaFinal = notaFinal;
    }

    public int getNotaFinal() {
        return notaFinal;
    }

    public String getNome() {
        return nome;
    }

    public Profissional getOrientador() {
        return orientador;
    }

    public Equipe getEquipe() {
        return equipe;
    }
}
