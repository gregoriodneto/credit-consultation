# Desafio Técnico - Sistema de Consulta de Créditos
Este repositório contém a solução para o desafio técnico, composta por dois projetos principais: API e Frontend.

## 📌 API - Consulta de Créditos
### Descrição
API RESTful desenvolvida em Java 17 com Spring Boot, responsável pela consulta de créditos constituídos. Ela oferece três endpoints principais:
- ```GET /api/creditos``` — Lista todos os créditos cadastrados.
- ```GET /api/creditos/{numeroNfse}``` — Retorna todos os créditos vinculados a uma NFS-e específica.
- ```GET /api/creditos/credito/{numeroCredito}``` — Retorna os detalhes de um crédito específico.
A API também está documentada com Swagger para facilitar a visualização e o teste dos endpoints.

### Tecnologias
- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Swagger (OpenAPI)
- Docker

## 📌 Frontend - Consulta de Créditos
### Descrição
Aplicação web desenvolvida com Angular, responsável por consumir a API e exibir os dados de forma clara e responsiva.
- Funcionalidades principais:
- Busca de créditos pelo número da NFS-e.
- Busca de crédito pelo número do crédito.
- Exibição dos resultados em tabela.
- Layout responsivo para dispositivos móveis.

### Tecnologias
- Angular
- TypeScript
- Bootstrap ou Angular Material
- Docker

## 🐳 Containerização
Tanto a API quanto o Frontend são containerizados com Docker, facilitando a execução local e a implantação em ambientes diversos.

O banco de dados PostgreSQL também é provisionado via Docker para simplificar o setup.

## ✅ Observação
Cada projeto possui seu próprio README.md com instruções detalhadas sobre como:

- Executar localmente.
- Subir com Docker.
- Configurar variáveis de ambiente.
- Executar testes.