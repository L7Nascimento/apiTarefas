# API de Lista de Tarefas

Esta é uma API para gerenciar uma lista de tarefas, construída com Spring Boot. A API permite adicionar, atualizar, listar e deletar tarefas, além de contar com autenticação básica.

## Índice

- [Introdução](#introdução)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Instalação](#instalação)
- [Configuração](#configuração)
- [Endpoints da API](#endpoints-da-api)
- [Autenticação](#autenticação)
- [Contribuindo](#contribuindo)
- [Licença](#licença)

## Introdução

Esta API permite que você gerencie uma lista de tarefas, incluindo operações de CRUD (Create, Read, Update, Delete). A aplicação foi desenvolvida usando Spring Boot e inclui autenticação básica.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.3.5
- Maven
- H2 Database
- Spring Security

## Instalação

Para clonar e rodar esta aplicação, você precisará do [Git](https://git-scm.com) e do [Maven](https://maven.apache.org) instalados em seu computador.

```sh
# Clone este repositório
$ git clone https://github.com/L7Nascimento/apiTarefas.git

# Entre na pasta do projeto
$ cd apiTarefas

# Execute o projeto
$ mvn spring-boot:run
```

## Configuração
Configure estes parametros no arquivo properties

```sh
 spring.application.name=tarefas
 spring.jmx.enabled=true
 spring.datasource.url=jdbc:h2:mem:testdb
 spring.datasource.driverClassName=org.h2.Driver
 spring.datasource.username=sa
 spring.datasource.password=password
 spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
 spring.h2.console.enabled=true
```
## Dependencias Mavin
Estas dependencias estão no arquivo pom do projeto.
```
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-rest</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```
# endpoints-da-api

## HTTP - GET
```
GET "/tarefas"
```
Retorna uma lista de tarefas
```
GET /tarefas/{id}
```
Obter detalhes de um item da tabela especifico pelo ID

## HTTP - POST
```
POST /tarefas
Content-Type: application/json

{
  "description": "Nova tarefa de teste",
  "status": false
}
```
## UPDATE
```
PUT /tarefas/{id}
Content-Type: application/json

{
  "description": "Tarefa de teste atualizada",
  "status": true
}
```
Atualiza uma item da lista de tarefas

## DELETE
```
DELETE /tarefas/{id}
```
Deleta um ítem específico da lista
```
@DeleteMapping
DELETE /tarefas
}

```
Deleta toda a lista

## Autenticação
Esta aplicação usa autenticação básica. Para acessar os endpoints /tarefas/**, você precisará de um nome de usuário e senha.

## Credenciais Padrão
```
Username: user
Password: password
```
## Contribuindo
Se quiser contribuir para este projeto, siga os passos abaixo:
Faça um fork deste repositório.

Crie uma branch para sua feature (git checkout -b feature/AmazingFeature).

Faça o commit das suas mudanças (git commit -m 'Add some AmazingFeature').

Envie para a branch (git push origin feature/AmazingFeature).

Abra um Pull Request.

## Licença
Distribuído sob a licença MIT. Veja LICENSE para mais informações.





