package br.edu.hackathon.repository;

import br.edu.hackathon.model.Equipe;
import java.util.*;

public class Equipes {
    private static Equipes instance;
    private List<Equipe> equipes = new ArrayList<>();

    private Equipes() {}

    public static synchronized Equipes getInstance() {
        if (instance == null) {
            instance = new Equipes();
        }
        return instance;
    }

    public void adicionarEquipe(Equipe equipe) {
        equipes.add(equipe);
    }

    public List<Equipe> getEquipes() {
        return Collections.unmodifiableList(equipes);
    }
}