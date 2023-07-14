CREATE TABLE TAREFAS(
    id_tarefa SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(300) NOT NULL,
    realizado CHAR(1) NOT NULL,
    prioridade VARCHAR(20) NOT NULL
)