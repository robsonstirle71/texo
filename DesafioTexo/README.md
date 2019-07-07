# Desafio Desenvolvedor TEXO
Desenvolva uma API RESTful para possibilitar a leitura da lista de indicados e vencedores da categoria Pior Filme do Golden Raspberry Awards.

Requisito do sistema:
* Ler o arquivo CSV dos filmes e inserir os dados em uma base de dados ao inciar a aplicação;

Requisitos da API:
* Obter o produtor com maior intervalo entre dois prêmios, e o que obteve dois prêmios mais rápido

## Instruções de execução
A API foi desenvolvida utilizando Maven. Para rodar a aplicação através do console basta executar o comando abaixo na raiz do projeto:
```
mvn spring-boot:run
```
Para este comando funcionar é necessário ter o Maven e o JDK 8 configurados nas variáveis de ambiente do sistema operacional.
Também é possível rodar a aplicação em alguma IDE que possua suporte ao Maven.

## Documentação da API
A documentação foi criada utilizando a ferramenta Swagger. Para visualizar é necessário acessar o endereço a seguir com o projeto rodando.
```
http://localhost:8080/swagger-ui.html#
```

## Bibliotecas e frameworks utilizados
* Spring Boot 2.1.6.RELEASE
* Swagger 2.9.2

## Instruções de uso da API
A seguir serão mostrado os endpoints e alguns exemplos de como fazer a solicitação. Recomendo usar o aplicativo Postman para realizar as requisições.

#### Obter o produtor com maior intervalo entre dois prêmios, e o que obteve dois prêmios mais rápido
_Endpoint_: GET `http://localhost:8080/producers/`

## Conectar no gerenciador do banco de dados em memória
Acessar o endereço `http://localhost:8080/h2`

Informações de login:
```
Saved Settings: Generic H2 (Embedded)
Setting Name: Generic H2 (Embedded)

Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password:
```
