package com.example.aluno.service;

import com.example.aluno.model.Aluno;
import com.example.aluno.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    public void createAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public void updateAluno(Long id, Aluno aluno) {
        Aluno alunoBanco = alunoRepository.findById(id).get();
        alunoBanco.setNome(aluno.getNome());
        alunoBanco.setMatricula(aluno.getMatricula());
        alunoBanco.setDataNascimento(aluno.getDataNascimento());

        alunoRepository.save(alunoBanco);
    }
}
