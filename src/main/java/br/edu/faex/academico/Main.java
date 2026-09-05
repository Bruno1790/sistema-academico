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

        Aluno aluno1 = new Aluno("Aleandro Ribeiro de Lima", "aleandro.lima@faex.edu.br");
        Aluno aluno2 = new Aluno("Maria Souza Silva", "maria.silva@faex.edu.br");

        alunoController.cadastrar(aluno1);
        alunoController.cadastrar(aluno2);

        for (Aluno aluno : alunoController.listar()) {
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("E-mail: " + aluno.getEmail());
            System.out.println("Ativo: " + aluno.isAtivo());
        }

        Aluno aluno = alunoController.buscarPorId(2L);
        if (aluno != null) {
            System.out.println("Aluno encontrado!");
            System.out.println("ID: " + aluno.getId());
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("E-mail: " + aluno.getEmail());
        } else {
            System.out.println("Aluno não encontrado.");
        }

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
}
