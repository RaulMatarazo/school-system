
# Como executar o projeto?

## Abrindo o projeto

Primeiramente você deve fazer um fork do projeto e abri-lo em sua IDE - eu te recomendo visualizá-lo no IntelliJ.

## Criando o banco de dados local

Após isso, como o projeto utiliza banco de dados local, você deve criar um banco de dados no MYSQL WorkBench chamado 'escola'

## Crie um usuário para acessar o sistema

Após executar o projeto note que foram criadas três tabelas no seu MySQL WorkBench. Crie um novo funcionário utilizando o comando abaixo:
```sql
INSERT INTO funcionarios (primeiro_nome, sobrenome, senha, email, telefone, data_nascimento, salario, tipo, ativo)
VALUES ('Raul', 'Matarazo', 'raul123', 'raul@gmail.com', '000000000', '2000-01-01', 1000, 'ADMIN', 1)
```

## Executando o projeto

Agora é só clicar em iniciar aplicação, no arquivo EscolaAPIApplication. No console note a seguinte URL:
http://localhost:8080/login
Clique na URL mostrada, você abrirá a tela de login do projeto.

## Autores
- [@raulmatarazo](https://www.linkedin.com/in/raulmatarazo/)
