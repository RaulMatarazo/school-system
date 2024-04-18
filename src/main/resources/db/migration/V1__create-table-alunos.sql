-- Criando a tabela alunos
CREATE TABLE alunos (
    aluno_id INT AUTO_INCREMENT PRIMARY KEY,
    primeiro_nome VARCHAR(100) NOT NULL,
    sobrenome VARCHAR(100) NOT NULL,
    data_nascimento DATE NOT NULL,
    serie VARCHAR(50) NOT NULL,
    curso VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefone VARCHAR(50) UNIQUE NOT NULL,
    ativo INT NOT NULL
);