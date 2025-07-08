# 💳 crédito-service

API RESTful desenvolvida em Java com Spring Boot para consulta de créditos constituídos a partir de notas fiscais de serviços eletrônicas (NFS-e).

---

## 📌 Funcionalidades

- 🔍 Consultar créditos por número da NFS-e
- 🔍 Consultar crédito específico por número do crédito
- 📥 Criar novos créditos (em desenvolvimento)
- 📦 Persistência em banco de dados PostgreSQL
- 🐳 Containerização com Docker
- 📄 Documentação via Swagger/OpenAPI

---

## 🧱 Tecnologias Utilizadas

| Camada          | Tecnologia                     |
|-----------------|--------------------------------|
| Backend         | Java 11, Spring Boot 2.7.4     |
| Banco de dados  | PostgreSQL 15                  |
| ORM             | Spring Data JPA, Hibernate     |
| Validação       | Bean Validation                |
| Documentação    | springdoc-openapi-ui (Swagger) |
| Containerização | Docker, Docker Compose         |
| Testes          | JUnit 5, Mockito               |

---

## ⚙️ Requisitos

- Java 11
- [Docker + Docker Compose](https://www.docker.com/products/docker-desktop/)
- Gradle (opcional, se quiser rodar sem container)

---

## 🚀 Executando com Docker

### 1. Compile o projeto

```bash
./gradlew clean build
````

###### ou para ignorar testes temporariamente:
```bash
./gradlew clean build -x test
````


### 2. Suba a aplicação com Docker Compose

```
docker-compose up --build
```


#### Isso iniciará:
A API na porta http://localhost:8080

Um banco PostgreSQL com dados pré-populados


## 📘 Swagger / OpenAPI
Após subir a aplicação, acesse:
#### http://localhost:8080/swagger-ui.html



## 🔗 Endpoints

### GET /api/creditos/{numeroNfse}
Retorna lista de créditos associados à NFS-e.

### GET /api/creditos/credito/{numeroCredito}
Retorna os dados detalhados de um crédito específico.

### POST /api/creditos (em desenvolvimento)
Cria um novo crédito com base nos dados fornecidos.



## 👨‍💻 Autor
### Rodrigo Paixão Neves
#### Desenvolvedor Sênior Backend Java
#### [GitHub]() | [LinkedIn](https://www.linkedin.com/in/rodrigo-paix%C3%A3o-neves-23395214a/)


## ✅ Observações finais
Este projeto foi desenvolvido como parte de um desafio técnico.
A estrutura, documentação e containerização foram elaboradas com foco em clareza, reprodutibilidade e boas práticas.