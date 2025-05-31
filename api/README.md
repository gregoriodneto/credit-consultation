# 📋 Desafio Técnico – API de Consulta de Créditos
Este projeto consiste em uma API RESTful desenvolvida em Java Spring Boot para consulta de créditos constituídos, com persistência em banco de dados PostgreSQL.

A API permite:
#### ✅ Listar todos os créditos
#### ✅ Consultar créditos por número de NFS-e
#### ✅ Consultar crédito por número de crédito constituído

Documentação interativa disponível via ***Swagger***.

## 🚀 Tecnologias utilizadas
- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Docker
- Swagger/OpenAPI 3
- JUnit, Mockito (para testes)

## 🛠️ Configuração e execução
### ✅ Pré-requisitos
- Docker e Docker Compose instalados
ou
- Java 21+ e Maven instalados
- PostgreSQL instalado (em caso de execução local)

## 📦 Como executar com Docker
1. Clone o repositório:
```bash
git clone https://github.com/seuusuario/seuprojeto.git
cd seuprojeto
```

2. Configure o application.properties com base no exemplo:
```bash
cp src/main/resources/application-example.properties src/main/resources/application.properties
```

3. Execute o Docker Compose:
```bash
docker-compose up --build
```

4. A API estará disponível em:
```bash
http://localhost:8080/api/creditos
```

5. A API estará disponível em:
```bash
http://localhost:8080/swagger-ui.html
```
ou
```bash
http://localhost:8080/swagger-ui/index.html
```

## 📖 Endpoints disponíveis
| Método | Rota                                    | Descrição                             |
| ------ | --------------------------------------- | ------------------------------------- |
| GET    | `/api/creditos`                         | Retorna todos os créditos             |
| GET    | `/api/creditos/{numeroNfse}`            | Retorna créditos por número da NFS-e  |
| GET    | `/api/creditos/credito/{numeroCredito}` | Retorna crédito por número de crédito |


## 🐳 Estrutura Docker Compose
- PostgreSQL: Banco de dados local
- API: Serviço Spring Boot exposto na porta 8080

## ✅ Como criar application.properties
Crie um arquivo application.properties na pasta src/main/resources com o seguinte conteúdo ajustado:
```bash
spring.application.name=api
spring.datasource.url=jdbc:postgresql://localhost:5432/creditdb
spring.datasource.username=credit
spring.datasource.password=pass123
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=none

spring.sql.init.mode=always
spring.sql.init.schema-locations=classpath:schema.sql
spring.sql.init.data-locations=classpath:data.sql

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
```