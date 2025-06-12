package br.edu.hackathon;

import br.edu.hackathon.model.*;
import br.edu.hackathon.model.instituicao.Empresa;
import br.edu.hackathon.model.instituicao.Universidade;
import br.edu.hackathon.repository.Apresentacoes;
import br.edu.hackathon.repository.Equipes;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        Universidade u1 = new Universidade("UFABC");
        Universidade u2 = new Universidade("USP");
        Empresa emp1 = new Empresa("Google");
        Empresa emp2 = new Empresa("Meta");

        Profissional orientador1 = new Profissional("Carlos", emp1);
        Profissional orientador2 = new Profissional("Ana", emp2);

        Equipe equipe1 = new Equipe("Equipe Inovação");
        for (int i = 1; i <= 5; i++) {
            equipe1.adicionarMembro(new Estudante("Aluno" + i, u1));
        }
        Projeto projeto1 = new Projeto("Sistema IoT", orientador1, equipe1);

        Equipe equipe2 = new Equipe("Equipe Tecnologia");
        for (int i = 6; i <= 10; i++) {
            equipe2.adicionarMembro(new Estudante("Aluno" + i, u2));
        }
        Projeto projeto2 = new Projeto("App Mobile", orientador2, equipe2);

        Equipes equipesRepo = Equipes.getInstance();
        equipesRepo.adicionarEquipe(equipe1);
        equipesRepo.adicionarEquipe(equipe2);

        Banca banca1 = new Banca(projeto1);
        banca1.adicionarNota(new Jurado("Jurado 1", emp1), 8);
        banca1.adicionarNota(new Jurado("Jurado 2", emp1), 7);
        banca1.adicionarNota(new Jurado("Jurado 3", emp2), 9);
        banca1.adicionarNota(new Jurado("Jurado 4", emp2), 8);

        Banca banca2 = new Banca(projeto2);
        banca2.adicionarNota(new Jurado("Jurado 5", emp2), 6);
        banca2.adicionarNota(new Jurado("Jurado 6", emp1), 3);
        banca2.adicionarNota(new Jurado("Jurado 7", emp1), 6);
        banca2.adicionarNota(new Jurado("Jurado 8", emp2), 5);

        Apresentacao ap1 = new Apresentacao(
                projeto1,
                banca1,
                new Sala("Auditório Principal"),
                LocalDateTime.now()
        );
        ap1.avaliar();

        Apresentacao ap2 = new Apresentacao(
                projeto2,
                banca2,
                new Sala("Sala 205"),
                LocalDateTime.now()
        );
        ap2.avaliar();

        Apresentacoes apresentacoesRepo = Apresentacoes.getInstance();
        apresentacoesRepo.adicionar(ap1);
        apresentacoesRepo.adicionar(ap2);

        System.out.println("====================================");
        System.out.println("PROJETOS APROVADOS (NOTA >= 7)");
        System.out.println("====================================");

        equipesRepo.getEquipes().stream()
                .filter(e -> e.getProjeto().getNotaFinal() >= 7)
                .forEach(e -> {
                    Projeto p = e.getProjeto();
                    System.out.printf(
                            "» %s - Nota: %d%n" +
                                    "  Orientador: %s%n" +
                                    "  Equipe: %s (%d membros)%n%n",
                            p.getNome(),
                            p.getNotaFinal(),
                            p.getOrientador().getNome(),
                            e.getNome(),
                            e.getMembros().size()
                    );
                });

        System.out.println("====================================");
        System.out.println("PROJETOS REPROVADOS (NOTA < 7)");
        System.out.println("====================================");

        equipesRepo.getEquipes().stream()
                .filter(e -> e.getProjeto().getNotaFinal() < 7)
                .forEach(e -> {
                    Projeto p = e.getProjeto();
                    System.out.printf(
                            "» %s - Nota: %d%n" +
                                    "  Motivo: Nota insuficiente%n%n",
                            p.getNome(),
                            p.getNotaFinal()
                    );
                });

    }
}