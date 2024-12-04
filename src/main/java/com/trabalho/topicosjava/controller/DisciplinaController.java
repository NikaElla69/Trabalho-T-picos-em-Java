package com.trabalho.topicosjava.controller;

import com.trabalho.topicosjava.dto.TurmaRequestDTO;
import com.trabalho.topicosjava.model.Curso;
import com.trabalho.topicosjava.model.Disciplina;
import com.trabalho.topicosjava.model.Professor;
import com.trabalho.topicosjava.model.Turma;
import com.trabalho.topicosjava.repository.CursoRepository;
import com.trabalho.topicosjava.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaController repository;

    @Autowired
    private CursoRepository repository;

    @Autowired
    private ProfessorRepository repository;

    @GetMapping
    public ResponseEntity<List<Disciplina>> findAll(){
        return ResponseEntity.ok(this.repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> findById(@PathVariable Integer id) {
        Disciplina disciplina = this.disciplinaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Disciplina não encontrada"));

        return ResponseEntity.ok(disciplina);
    }

    @PostMapping
    public Disciplina save(@RequestBody DisciplinaRequestDTO dto) {
        Disciplina disciplina = new Disciplina();

        disciplina.setNome(dto.nome());
        disciplina.setCodigo(dto.codigo());

        Curso curso = this.cursoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado"));
        disciplina.setCurso(curso);

        Professor professor = this.cursoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Professor não encontrado"));
        disciplina.setProfessor(Professor);

        return this.repository.save(disciplina);
    }

    @PutMapping("/{id}")
    public Disciplina update(@PathVariable Integer id, @RequestBody DisciplinaRequestDTO dto) {
        Disciplina disciplina = this.disciplinaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Disciplina não encontrada"));

        disciplina.setNome(dto.nome());
        disciplina.setCodigo(dto.codigo());

        Curso curso = this.cursoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado"));
        disciplina.setCurso(curso);

        Professor professor = this.cursoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Professor não encontrado"));
        disciplina.setProfessor(Professor);

        return this.repository.save(disciplina);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<void> delete(@PathVariable Integer id) {
        Disciplina disciplina = this.disciplinaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Disciplina não encontrada"));

        this.repository.delete(disciplina);

        return ResponseEntity.noContent().build();
}
