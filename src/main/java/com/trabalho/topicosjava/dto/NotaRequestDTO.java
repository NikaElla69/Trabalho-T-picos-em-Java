package com.trabalho.topicosjava.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record NotaRequestDTO(Integer matricula_id, Integer disciplina_id, BigDecimal nota, LocalDate data_lancamento) {
}
