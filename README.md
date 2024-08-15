
# Como executar o projeto?

## Abrindo o projeto

Primeiramente você deve fazer um fork do projeto e abri-lo em sua IDE - eu te recomendo visualizá-lo no IntelliJ.

## Criando o banco de dados local

Após isso, como o projeto utiliza banco de dados local, você deve criar um banco de dados no MYSQL WorkBench chamado escola

## Executando o projeto

Agora é só clicar em iniciar aplicação, no arquivo EscolaAPIApplication, aqui:
```java
	@SpringBootApplication
public class EscolaApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(EscolaApiApplication.class, args);
        System.out.println("A aplicação está rodando...");
        System.out.println("Clique aqui para acessar o projeto: http://localhost:8080/login"); // clique aqui depois no console, quando tudo rodar tranquilo sem nenhum erro.
        System.out.println("Feito por Raul U. Matarazo");
    }
}

```

## Visualizando o projeto

Faça testes e force erros, se quiser atualizar alguma coisa me mande por aqui, obrigado!

## Autores
- [@raulmatarazo](https://www.linkedin.com/in/raulmatarazo/)
