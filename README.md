# Desafio Técnico - Simulador de Financiamentos

## Objetivo
API backend para simulação de financiamentos com cálculo de juros compostos, geração de memória de cálculo mês a mês e persistência em base H2.

## Tecnologias utilizadas
- Java 25
- Quarkus
- Maven Wrapper
- H2 Database
- Hibernate ORM Panache
- OpenAPI / Swagger
- JUnit 5
- Rest Assured
- JaCoCo

## Estrutura do projeto
- `resource` → endpoints da API
- `service` → regras de negócio e cálculo
- `repository` → persistência
- `entity` → entidades JPA

## Pré-requisitos
- Java 25 instalado
- Terminal no Windows (PowerShell ou CMD)

## Como compilar e executar os testes
Na raiz do projeto, execute:

```powershell
.\mvnw.cmd verify