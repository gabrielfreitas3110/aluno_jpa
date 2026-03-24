package com.example.aluno.controller;

import com.example.aluno.model.Aluno;
import com.example.aluno.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> buscarAlunos() {
        List<Aluno> alunos = alunoService.getAllAlunos();
        return alunos;
    }

    @PostMapping
    public void inserirAluno(@RequestBody Aluno aluno) {
        alunoService.createAluno(aluno);
    }
}
