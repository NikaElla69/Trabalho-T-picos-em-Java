package com.trabalho.topicosjava.repository;

import com.trabalho.topicosjava.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
