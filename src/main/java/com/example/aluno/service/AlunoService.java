package com.example.aluno.service;

import com.example.aluno.model.Aluno;
import com.example.aluno.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    public Long createAluno(Aluno aluno) {
        aluno = alunoRepository.save(aluno);
        return aluno.getId();
    }

    public void updateAluno(Long id, Aluno aluno) {
        Aluno alunoBanco = alunoRepository.findById(id).get();
        alunoBanco.setNome(aluno.getNome());
        alunoBanco.setMatricula(aluno.getMatricula());
        alunoBanco.setDataNascimento(aluno.getDataNascimento());

        alunoRepository.save(alunoBanco);
    }

    public void deleteAluno(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if(aluno.isEmpty()) {
            System.out.println("Aluno não encontrado");
        } else {
            alunoRepository.deleteById(id);
        }

    }

    public Aluno getAlunoById(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if(aluno.isEmpty()) {
            System.out.println("Aluno não encontrado");
            return null;
        }
        return aluno.get();
    }
}
