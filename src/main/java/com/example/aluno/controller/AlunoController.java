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

    @GetMapping("/{id}")
    public Aluno buscarAlunoPorId(@PathVariable("id") Long id) {
        Aluno aluno = alunoService.getAlunoById(id);
        return aluno;
    }

    @PostMapping
    public void inserirAluno(@RequestBody Aluno aluno) {
        alunoService.createAluno(aluno);
    }

    @PutMapping("/{id}")
    public void atualizarAluno(
            @PathVariable("id") Long id,
            @RequestBody Aluno aluno) {
        alunoService.updateAluno(id, aluno);
    }

    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable("id") Long id) {
        alunoService.deleteAluno(id);
    }
}
