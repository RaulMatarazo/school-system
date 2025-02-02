CREATE TABLE funcionarios(
    funcionario_id INT AUTO_INCREMENT PRIMARY KEY,
    primeiro_nome VARCHAR(100) NOT NULL,
    sobrenome VARCHAR(100) NOT NULL,
    senha VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefone VARCHAR(50) UNIQUE NOT NULL,
    data_nascimento DATE NOT NULL,
    salario DECIMAL NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    ativo INT NOT NULL
)