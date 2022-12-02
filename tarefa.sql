CREATE TABLE tarefa
(
    ID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    titulo   varchar(30),
    urgencia varchar(1),
    concluido    int(1)
)