package com.trabalho.topicosjava.controller;

import com.trabalho.topicosjava.dto.CursoRequestDTO;
import com.trabalho.topicosjava.dto.TurmaRequestDTO;
import com.trabalho.topicosjava.model.Curso;
import com.trabalho.topicosjava.model.Turma;
import com.trabalho.topicosjava.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Turma")
public class TurmaController {

    @Autowired
    private TurmaController repository;

    @Autowired
    private CursoRepository repository;

    @GetMapping
    public ResponseEntity<List<Turma>> findAll(){
        return ResponseEntity.ok(this.repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> findById(@PathVariable Integer id) {
        Turma turma = this.turmaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada"));

        return ResponseEntity.ok(turma);
    }

    @PostMapping
    public Turma save(@RequestBody TurmaRequestDTO dto) {
        Turma turma = new Turma();

        turma.setAno(dto.ano());
        turma.setSemestre(dto.semestre());

        Curso curso = this.cursoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado"));
        turma.setCurso(curso);

        return this.repository.save(turma);
    }

    @PutMapping("/{id}")
    public Turma update(@PathVariable Integer id, @RequestBody TurmaRequestDTO dto) {
        Turma turma = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada"));

        turma.setAno(dto.ano());
        turma.setSemestre(dto.semestre());

        Curso curso = this.cursoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado"));
        turma.setCurso(curso);

        return this.repository.save(turma);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<void> delete(@PathVariable Integer id) {
        Turma turma = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada"));

        this.repository.delete(turma);

        return ResponseEntity.noContent().build();
}
