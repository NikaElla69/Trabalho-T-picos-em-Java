package com.trabalho.topicosjava.repository;

import com.trabalho.topicosjava.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
