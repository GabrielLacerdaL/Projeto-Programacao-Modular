# 🎓 Sistema de Gerenciamento de Hackathons Universitários

Este projeto simula um sistema para gerenciar hackathons promovidos anualmente por universidades. Ele foi desenvolvido com foco em gerenciar **equipes**, **projetos**, **apresentações** e **bancas avaliadoras**, utilizando uma estrutura de classes bem definida e boas práticas de orientação a objetos, como o uso do padrão Singleton.

## 📌 Objetivo

O sistema gerencia:

- Equipes compostas por estudantes universitários;
- Projetos apresentados por essas equipes;
- Bancas formadas por jurados que avaliam os projetos;
- Apresentações dos projetos com nota final calculada pela média das notas dos jurados.

## 🛠️ Tecnologias Utilizadas

- Java 17+
- Paradigma Orientado a Objetos (POO)
- Padrão de Projeto Singleton
- Java Stream API

---

## ℹ️ Sobre a Entrada e Saída de Dados

Este projeto **não possui entrada de dados via usuário (console, menus ou interfaces)**. Todos os dados necessários (equipes, projetos, jurados, notas, etc.) são criados diretamente no código, dentro do método `main()`. 

O foco está na simulação do funcionamento do sistema, por meio de **saídas formatadas no console**, conforme exigido no enunciado da atividade.



## 📂 Estrutura de Pastas

```bash
src/
└── edu/
    └── hackaton/
        ├── Main.java
        ├── model/
        │   ├── Apresentacao.java
        │   ├── Banca.java
        │   ├── Equipe.java
        │   ├── Estudante.java
        │   ├── IAvaliavel.java
        │   ├── Jurado.java
        │   ├── Pessoa.java
        │   ├── Profissional.java
        │   ├── Projeto.java
        │   ├── Sala.java
        │   └── instituicao/
        │       ├── Empresa.java
        │       ├── Instituicao.java
        │       └── Universidade.java
        └── repository/
            ├── Apresentacoes.java
            └── Equipes.java
