package br.edu.faex.academico;

import br.edu.faex.academico.model.Aluno;
import br.edu.faex.academico.repository.AlunoRepository;

public class Main {
    static void main() {

        Aluno aluno1 = new Aluno("Aleandro Ribeiro de Lima", "aleandro.lima@faex.edu.br");
        Aluno aluno2 = new Aluno("Maria Souza Silva", "maria.silva@faex.edu.br");

        AlunoRepository repository = new AlunoRepository();
        repository.salvar(aluno1);
        repository.salvar(aluno2);

        for (Aluno aluno : repository.listar()) {
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("E-mail: " + aluno.getEmail());
            System.out.println("Ativo: " + aluno.isAtivo());
        }
    }
}
