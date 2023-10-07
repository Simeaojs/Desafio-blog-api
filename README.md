# Desafio-blog-api

## Objetivo

O objetivo deste projeto Foi desenvolver uma API REST usando o Spring Boot para um sistema de Blog que inclui três tipos de entidades: "Post", "Comentário" e "Usuário". A API é projetada para gerenciar postagens, comentários e autores em um blog.
#
## ⚒️Tecnologias Utilizadas

- Java
- Spring Data JPA
- Banco de Dados (MySQL)
- Gerenciador de Dependências Maven
- Postman Para Requisições
- IDE Visual Studio Code

## 🪛Configuração 

1. Clone o repositório para o seu ambiente local.
2. git clone ```https://github.com/Simeaojs/Desafio-blog-api```
3. Configure as dependências do projeto (Maven).
4. Configure as informações do banco de dados no arquivo de configuração (`application.properties` ou `application.yml`).
5. Execute a aplicação.
#

## 📋Funcionalidades

### Postagens
- `GET` /posts: Retorna a lista de todas as postagens com seus detalhes, incluindo os comentários associados e os detalhes do autor.
- `GET /posts/{id}`: Retorna os detalhes de uma postagem específica com base no ID, incluindo os comentários associados e os detalhes do autor.
- `POST /posts`: Permite criar uma nova postagem.
- `PUT /posts/{id}`: Permite atualizar os detalhes de uma postagem existente com base no ID.
- `DELETE /posts/{id}`: Permite excluir uma postagem com base no ID, incluindo os comentários associados à postagem excluída.

### Comentários
- `POST /posts/{postId}/comentarios`: Permite adicionar um novo comentário a uma postagem existente.
- `PUT /comments/{id}`: Permite atualizar o texto de um comentário existente.
- `DELETE /comments/{id}`: Permite excluir um comentário com base no ID.

### Autores
- `GET /authors`: Retorna a lista de todos os autores com seus detalhes, incluindo as postagens associadas.
- `GET /authors/{id}`: Retorna os detalhes de um autor específico com base no ID, incluindo as postagens associadas.
- `POST /authors`: Permite criar um novo autor.
- `PUT /authors/{id}`: Permite atualizar os detalhes de um autor existente com base no ID.
- `DELETE /authors/{id}`: Permite excluir um autor com base no ID.



## Documentação
### Não clique aqui!

[Documentação](https://documenter.getpostman.com/view/28267689/2s9YJgSfEp)

## Licença 

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)


