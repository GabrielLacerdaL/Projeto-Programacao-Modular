package br.edu.hackathon.model;

public interface IAvaliavel {
    void adicionarNota(Jurado jurado, int nota);
    int calcularNotaFinal();
}
