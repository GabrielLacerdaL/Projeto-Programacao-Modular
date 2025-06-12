package br.edu.hackathon.model;

import java.util.HashMap;
import java.util.Map;

public class Banca implements IAvaliavel {
    private Projeto projetoAvaliado;
    private Map<Jurado, Integer> jurados = new HashMap<>();

    public Banca(Projeto projetoAvaliado) {
        if (projetoAvaliado == null) {
            throw new IllegalArgumentException("O projeto avaliado não pode ser nulo");
        }
        this.projetoAvaliado = projetoAvaliado;
    }

    @Override
    public void adicionarNota(Jurado jurado, int nota) {
        if (jurado == null) {
            throw new IllegalArgumentException("O jurado não pode ser nulo");
        }
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 10");
        }
        jurados.put(jurado, nota);
    }

    @Override
    public int calcularNotaFinal() {
        if (jurados.isEmpty()) {
            return 0;
        }
        int soma = jurados.values().stream().mapToInt(Integer::intValue).sum();
        return (int) soma / jurados.size();
    }

    public Projeto getProjetoAvaliado() {
        return projetoAvaliado;
    }

    public Map<Jurado, Integer> getJurados() {
        return jurados;
    }
}
