create table turmas (
    id int not null primary key auto_increment,
    ano int,
    semestre int enum('1','2'),
    curso_id int,
    FOREIGN KEY (curso_id) REFERENCES curso(id)
);