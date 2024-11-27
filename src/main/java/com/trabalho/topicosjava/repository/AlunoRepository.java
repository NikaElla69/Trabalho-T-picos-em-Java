package com.trabalho.topicosjava.repository;

import com.trabalho.topicosjava.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
