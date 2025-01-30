# Locadora API

Este projeto é uma API para gerenciar filmes em uma locadora. A API permite adicionar, listar, atualizar e remover filmes, além de listar filmes disponíveis para locação.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Spring Boot**: Framework para criação de aplicações Java.
- **Maven**: Gerenciador de dependências.
- **Postman**: Ferramenta para testes de API.

## Requisitos

- **JDK 17** ou superior
- **Maven** instalado
- Uma IDE
- Postman (ou similar) para testar as rotas da API

---

## Passo a Passo para Rodar o Projeto

### 1. Clone o Repositório

Faça o clone do repositório para sua máquina local:


https://github.com/tnnoixd/API-DOOB-


Entre no diretório do projeto:


cd %USERPROFILE%\Desktop\locadora-gerenciamento




### 2. Compile e Rode o Projeto

Para compilar e rodar a API, use os seguintes comandos:

#### 2.1 Compile o Projeto:


mvn clean install


#### 2.2 Execute a Aplicação:


mvn spring-boot:run


A aplicação estará rodando na porta **8080** por padrão.

---

### 3. Teste as Rotas da API

Use o **Postman** para realizar os testes da API.

#### 3.1 Adicionar um Filme

- **Método:** POST
- **URL:** http://localhost:8080/filmes
- **Headers:**
  - Content-Type: application/json
- **Body:**

  {
      "nome": "Inception",
      "rating": 8.8,
      "sinopse": "Um ladrão rouba segredos dos sonhos."
  }


#### 3.2 Listar Todos os Filmes

- **Método:** GET
- **URL:** http://localhost:8080/filmes

#### 3.3 Listar Filmes Disponíveis

- **Método:** GET
- **URL:** http://localhost:8080/filmes/disponiveis

#### 3.4 Atualizar um Filme

- **Método:** PATCH
- **URL:** http://localhost:8080/filmes/{id}
- **Headers:**
  - Content-Type: application/json
- **Body:**

  {
      "nome": "Interstellar",
      "rating": 9.0,
      "sinopse": "Uma viagem para salvar a humanidade."
  }


#### 3.5 Remover um Filme

- **Método:** DELETE
- **URL:** http://localhost:8080/filmes/{id}

Substitua {id} pelo ID do filme que deseja remover.


#### 3.6 Buscar um Filme pelo ID
- **Método:** GET
- **URL:** http://localhost:8080/filmes/{id}
Substitua {id} pelo ID do filme que deseja buscar.
**Exemplo:**
GET http://localhost:8080/filmes/1 → Retorna o filme com ID 1.


#### 4 Rotas de usuário

#### 4.1 Criar um Usuário

- **Método:** POST
- **URL:** http://localhost:8080/usuarios
- **Headers:**
 - Content-Type: application/json
- **Body:**

{
    "nome": "Antonio Marcatto"
}

#### 4.2 Listar Todos os Usuários

- **Método:** GET
- **URL:** http://localhost:8080/usuarios

#### 4.3 Buscar Usuário por ID

- **Método:** GET
- **URL:** http://localhost:8080/usuarios/{id}
Substitua {id} pelo ID do usuário que deseja buscar.
- **Exemplo:**
GET http://localhost:8080/usuarios/1 → Retorna o usuário com ID 1.

#### 4.4 Remover um usuário

- **Método:** DELETE
- **URL:** http://localhost:8080/usuarios/{id}

Substitua {id} pelo ID do filme que deseja remover.

## Estrutura do Projeto

- **Controller:** Contém os endpoints para as operações da API.
- **Service:** Contém a lógica de negócios.
- **Model:** Define a estrutura dos dados (classe Filme).


