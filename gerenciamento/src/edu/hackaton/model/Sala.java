package br.edu.hackathon.model;

public class Sala {
    private String nome;

    public Sala(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome da sala não pode ser nulo ou vazio");
        }
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
