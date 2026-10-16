package br.edu.faex.academico;

import br.edu.faex.academico.controller.AlunoController;
import br.edu.faex.academico.controller.ProfessorController;
import br.edu.faex.academico.model.Aluno;
import br.edu.faex.academico.model.Professor;
import br.edu.faex.academico.service.AlunoService;
import br.edu.faex.academico.service.ProfessorService;

public class Main {
    public static void main(String[] args) {

        AlunoService alunoService = new AlunoService();
        AlunoController alunoController = new AlunoController(alunoService);

        System.out.println("===== TESTE 1: Cadastro de dois alunos com e-mails diferentes =====");
        Aluno aluno1 = new Aluno("Aleandro Ribeiro de Lima", "aleandro.lima@faex.edu.br");
        Aluno aluno2 = new Aluno("Maria Souza Silva", "maria.silva@faex.edu.br");
        alunoController.cadastrar(aluno1);
        alunoController.cadastrar(aluno2);
        listarAlunos(alunoController);

        System.out.println("\n===== TESTE 2: Cadastro com e-mail já existente =====");
        Aluno aluno3 = new Aluno("João Pedro Alves", "aleandro.lima@faex.edu.br");
        alunoController.cadastrar(aluno3);
        listarAlunos(alunoController);

        System.out.println("\n===== TESTE 3: Atualizar o nome de um aluno mantendo o próprio e-mail =====");
        Aluno aluno1NomeAtualizado = new Aluno("Aleandro Ribeiro de Lima Junior", "aleandro.lima@faex.edu.br");
        aluno1NomeAtualizado.setId(aluno1.getId());
        alunoController.atualizar(aluno1NomeAtualizado);
        listarAlunos(alunoController);

        System.out.println("\n===== TESTE 4: Atualizar e-mail de um aluno para um já usado por outro =====");
        Aluno aluno1EmailDuplicado = new Aluno("Aleandro Ribeiro de Lima Junior", "MARIA.SILVA@faex.edu.br");
        aluno1EmailDuplicado.setId(aluno1.getId());
        alunoController.atualizar(aluno1EmailDuplicado);
        listarAlunos(alunoController);

        System.out.println("\n===== TESTE 5: Atualizar aluno com e-mail inválido =====");
        Aluno aluno1EmailInvalido = new Aluno("Aleandro Ribeiro de Lima Junior", "aleandro.lima-faex.edu.br");
        aluno1EmailInvalido.setId(aluno1.getId());
        alunoController.atualizar(aluno1EmailInvalido);
        listarAlunos(alunoController);

        System.out.println("\n===== TESTE 6: Atualizar aluno com ID inexistente =====");
        Aluno alunoInexistente = new Aluno("Fulano de Tal", "fulano@faex.edu.br");
        alunoInexistente.setId(999L);
        alunoController.atualizar(alunoInexistente);

        System.out.println("\n===== LISTA FINAL DE ALUNOS =====");
        listarAlunos(alunoController);

        System.out.println("\n===== TESTE: Busca de aluno por ID =====");
        Aluno aluno = alunoController.buscarPorId(2L);
        if (aluno != null) {
            System.out.println("Aluno encontrado!");
            System.out.println("ID: " + aluno.getId());
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("E-mail: " + aluno.getEmail());
        } else {
            System.out.println("Aluno não encontrado.");
        }

        System.out.println("\n===== TESTE: Exclusão de aluno =====");
        alunoController.excluir(2L);
        listarAlunos(alunoController);

        System.out.println("\n===== TESTE: Cadastro e busca de professor =====");
        ProfessorService professorService = new ProfessorService();
        ProfessorController professorController = new ProfessorController(professorService);

        Professor professor1 = new Professor("Carlos Eduardo Santos", "carlos.santos@faex.edu.br");
        professorController.cadastrar(professor1);

        Professor professor = professorController.buscarPorId(1L);
        if (professor != null) {
            System.out.println("Professor encontrado!");
            System.out.println("ID: " + professor.getId());
            System.out.println("Nome: " + professor.getNome());
            System.out.println("E-mail: " + professor.getEmail());
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    private static void listarAlunos(AlunoController alunoController) {
        for (Aluno aluno : alunoController.listar()) {
            System.out.println("ID: " + aluno.getId() + " | Nome: " + aluno.getNome() + " | E-mail: " + aluno.getEmail());
        }
    }
}
