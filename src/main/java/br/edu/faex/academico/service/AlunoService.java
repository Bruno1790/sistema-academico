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
}
