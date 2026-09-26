package br.edu.faex.academico.service;

import br.edu.faex.academico.model.Aluno;
import br.edu.faex.academico.repository.AlunoRepository;

import java.util.List;

public class AlunoService {
    private AlunoRepository repository = new AlunoRepository();

    public void cadastrar(Aluno aluno) {
        this.repository.salvar(aluno);
    }

    public List<Aluno> listar() {
        return this.repository.listar();
    }

    public Aluno buscarPorId(Long id) {
        Aluno aluno = repository.buscarPorId(id);
        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return null;
        }
        return aluno;
    }

    public void excluir(Long id){
        Aluno aluno = repository.buscarPorId(id);
        if (aluno == null){
            System.out.println("Aluno não encontrado");
            return;
        }
        repository.excluir(id);
    }

    public void atualizar(Aluno alunoEditado){
        Aluno aluno = repository.buscarPorId(alunoEditado.getId());

        if (aluno == null){
            System.out.println("Aluno não encontrado");
            return;
        }

        if (alunoEditado.getNome() == null || alunoEditado.getNome().isBlank()){
            System.out.println("O nome do aluno é obrigatório.");
            return;
        }

        if (alunoEditado.getEmail() == null || alunoEditado.getEmail().isBlank()){
            System.out.println("O e-mail do aluno é obrigatório.");
            return;
        }

        if (alunoEditado.getEmail().contains("@")){
            System.out.println("E-mail inválido.");
            return;
        }

        repository.atualizar(alunoEditado);
        System.out.println("Aluno atualizado com sucesso!");
    }
}
