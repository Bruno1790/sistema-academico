package br.edu.faex.academico;

import br.edu.faex.academico.model.Aluno;
import br.edu.faex.academico.service.AlunoService;

public class Main {
    public static void main(String[] args) {

        Aluno aluno1 = new Aluno("Aleandro Ribeiro de Lima", "aleandro.lima@faex.edu.br");
        Aluno aluno2 = new Aluno("Maria Souza Silva", "maria.silva@faex.edu.br");

        AlunoService alunoService = new AlunoService();
        alunoService.cadastrar(aluno1);
        alunoService.cadastrar(aluno2);

        for (Aluno aluno : alunoService.listar()) {
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("E-mail: " + aluno.getEmail());
            System.out.println("Ativo: " + aluno.isAtivo());
        }
    }
}
