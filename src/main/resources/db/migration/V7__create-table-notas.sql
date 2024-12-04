create table notas (
    id int not null primary key auto_increment,
    matricula_id int,
    FOREIGN KEY (matricula_id) REFERENCES matricula(id),
    disciplina_id int,
    FOREIGN KEY (disciplina_id) REFERENCES disciplina(id),
    nota DECIMAL (5,2),
    data_lancamento date
);