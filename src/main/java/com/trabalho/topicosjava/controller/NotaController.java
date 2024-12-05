package com.trabalho.topicosjava.controller;

import com.trabalho.topicosjava.model.*;
import com.trabalho.topicosjava.repository.DisciplinaRepository;
import com.trabalho.topicosjava.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Notas")
public class NotaController {

    @Autowired
    private NotaController repository;

    @Autowired
    private MatriculaRepository repository;

    @Autowired
    private DisciplinaRepository repository;

    @GetMapping
    public ResponseEntity<List<Nota>> findAll(){
        return ResponseEntity.ok(this.repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nota> findById(@PathVariable Integer id) {
        Nota nota = this.notaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nota não encontrada"));

        return ResponseEntity.ok(Nota);
    }

    @PostMapping
    public Nota save(@RequestBody NotaRequestDTO dto) {
        Nota nota = new nota();

        Matricula matricula = this.matriculaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Matricula não encontrada"));
        nota.setMatricula(Matricula);

        Disciplina disciplina = this.disciplinaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Disciplina não encontrada"));
        nota.setDisciplina(Disciplina);

        return this.repository.save(Nota);
    }

    @PutMapping("/{id}")
    public Matricula update(@PathVariable Integer id, @RequestBody MatriculaRequestDTO dto) {
        Nota nota = this.notaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nota não encontrada"));

        Matricula matricula = this.matriculaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Matricula não encontrada"));
        nota.setMatricula(Matricula);

        Disciplina disciplina = this.disciplinaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Disciplina não encontrada"));
        nota.setDisciplina(Disciplina);


        return this.repository.save(nota);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<void> delete(@PathVariable Integer id) {
        Nota nota = this.notaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nota não encontrada"));

        this.repository.delete(nota);

        return ResponseEntity.noContent().build();


    }
