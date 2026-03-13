# Gestao de Funcionarios

API REST para cadastro e manutencao de funcionarios, feita com Spring Boot, Spring Web MVC, Spring Data JPA e banco H2.

## Objetivo

Este projeto implementa um CRUD de funcionarios com os seguintes recursos:

- criar funcionario
- listar funcionarios
- buscar funcionario por id
- atualizar funcionario
- remover funcionario

## Tecnologias

- Java 25
- Spring Boot 4.0.3
- Spring Web MVC
- Spring Data JPA
- H2 Database
- Maven Wrapper (`./mvnw`)

## Estrutura do Projeto

- `src/main/java/_lucas/co/GestaoFuncionarios/GestaoFuncionariosApplication.java`: classe principal
- `src/main/java/_lucas/co/GestaoFuncionarios/DepartamentoEnum.java`: enum de departamentos
- `src/main/java/_lucas/co/GestaoFuncionarios/Funcionario/Funcionario.java`: entidade JPA
- `src/main/java/_lucas/co/GestaoFuncionarios/Funcionario/FuncionarioCreateDTO.java`: DTO de entrada
- `src/main/java/_lucas/co/GestaoFuncionarios/Funcionario/FuncionarioRepository.java`: repositorio JPA
- `src/main/java/_lucas/co/GestaoFuncionarios/Funcionario/FuncionarioService.java`: regra de negocio
- `src/main/java/_lucas/co/GestaoFuncionarios/Funcionario/FuncionarioController.java`: endpoints REST
- `src/main/resources/application.properties`: configuracao da aplicacao

## Como Executar

1. Garantir JDK 25 instalado.
2. Na raiz do projeto, executar:

```bash
./mvnw spring-boot:run
```

3. API disponivel em `http://localhost:8080`.

## Console do H2

- Habilitado em `src/main/resources/application.properties`.
- URL: `http://localhost:8080/h2-console`
- Path configurado: `/h2-console`

## Endpoints Principais

Base URL: `/funcionarios`

- `POST /funcionarios`
- `GET /funcionarios`
- `GET /funcionarios/{id}`
- `PUT /funcionarios/{id}`
- `DELETE /funcionarios/{id}`

Exemplo de payload (`POST` e `PUT`):

```json
{
  "nome": "Lucas",
  "cargo": "Desenvolvedor",
  "departamento": "TI",
  "salario": 4500.0,
  "dataAdmissao": "2026-03-13"
}
```

Departamentos aceitos:

- `TI`
- `RH`
- `VENDAS`
- `MARKETING`
- `FINANCEIRO`
- `OPERACOES`

## Testes

Para rodar os testes:

```bash
./mvnw test
```

Atualmente existe um teste basico de contexto da aplicacao.

## Documentacao Tecnica

Detalhes tecnicos completos em `docs/DOCUMENTACAO.md`.
