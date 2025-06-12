package br.edu.hackathon.model;

import java.time.LocalDateTime;

public class Apresentacao {
    private Projeto projeto;
    private Banca avaliavel;
    private Sala sala;
    private LocalDateTime horario;

    public Apresentacao(Projeto projeto, Banca banca, Sala sala, LocalDateTime horario) {
        this.projeto = projeto;
        this.avaliavel = banca;
        this.sala = sala;
        this.horario = horario;
    }

    public void avaliar() {
        int media = avaliavel.calcularNotaFinal();
        projeto.setNotaFinal(media);
    }
}