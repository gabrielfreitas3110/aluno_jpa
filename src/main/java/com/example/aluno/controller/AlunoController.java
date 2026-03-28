package com.example.aluno.controller;

import com.example.aluno.model.Aluno;
import com.example.aluno.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> buscarAlunos() { //ResponseEntity< >
        List<Aluno> alunos = alunoService.getAllAlunos();
        return ResponseEntity.ok(alunos);  //ResponseEntity.ok(objeto que estava retornando já)
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarAlunoPorId(@PathVariable("id") Long id) {
        Aluno aluno = alunoService.getAlunoById(id);
        return ResponseEntity.ok().body(aluno);
    }

    @PostMapping
    public ResponseEntity<?> inserirAluno(@RequestBody Aluno aluno) {
        Long id = alunoService.createAluno(aluno);
        try {
            URI location = new URI("http://localhost:8080/aluno/" + id);
            return ResponseEntity.created(location).build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarAluno(
            @PathVariable("id") Long id,
            @RequestBody Aluno aluno) {
        alunoService.updateAluno(id, aluno);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAluno(@PathVariable("id") Long id) {
        alunoService.deleteAluno(id);
        return ResponseEntity.noContent().build();
    }
}
