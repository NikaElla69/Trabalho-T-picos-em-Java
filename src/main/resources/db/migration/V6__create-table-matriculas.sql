create table matriculas (
    id int not null primary key auto_increment,
    aluno_id int,
    FOREIGN KEY (aluno_id) REFERENCES aluno(id),
    turma_id int,
    FOREIGN KEY (turma_id) REFERENCES turma(id)
);