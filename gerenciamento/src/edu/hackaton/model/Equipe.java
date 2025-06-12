package br.edu.hackathon.model;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private String nome;
    private List<Estudante> membros;
    private Projeto projeto;

    public Equipe(String nome) {
        this.nome = nome;
        this.membros = new ArrayList<>();
    }

    public void adicionarMembro(Estudante estudante) {
        membros.add(estudante);
    }

    public List<Estudante> getMembros() {
        return membros;
    }

    public String getNome() {
        return nome;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Projeto getProjeto() {
        return projeto;
    }
}
