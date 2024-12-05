package com.trabalho.topicosjava.repository;

import com.trabalho.topicosjava.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Integer> {
}
