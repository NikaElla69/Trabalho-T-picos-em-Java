package com.trabalho.topicosjava.controller;


import com.trabalho.topicosjava.dto.TurmaRequestDTO;
import com.trabalho.topicosjava.model.Aluno;
import com.trabalho.topicosjava.model.Curso;
import com.trabalho.topicosjava.model.Matricula;
import com.trabalho.topicosjava.model.Turma;
import com.trabalho.topicosjava.repository.AlunoRepository;
import com.trabalho.topicosjava.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaController repository;

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private TurmaRepository repository;

    @GetMapping
    public ResponseEntity<List<Matricula>> findAll(){
        return ResponseEntity.ok(this.repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> findById(@PathVariable Integer id) {
        Matricula matricula = this.matriculaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Matricula não encontrada"));

        return ResponseEntity.ok(matricula);
    }

    @PostMapping
    public Matricula save(@RequestBody MatriculaRequestDTO dto) {
        Matricula matricula = new Matricula();

        Aluno aluno = this.cursoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));
        matricula.setAluno(Aluno);

        Turma turma = this.turmaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada"));
        matricula.setAluno(Aluno);

        return this.repository.save(Matricula);
    }

    @PutMapping("/{id}")
    public Matricula update(@PathVariable Integer id, @RequestBody MatriculaRequestDTO dto) {
        Matricula matricula = this.matriculaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Matricula não encontrada"));

        Aluno aluno = this.cursoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));
        matricula.setAluno(Aluno);

        Turma turma = this.turmaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada"));
        matricula.setAluno(Aluno);


        return this.repository.save(turma);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<void> delete(@PathVariable Integer id) {
        Matricula matricula = this.matriculaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Matricula não encontrada"));

        this.repository.delete(matricula);

        return ResponseEntity.noContent().build();

}
