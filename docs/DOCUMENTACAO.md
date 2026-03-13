# Documentacao Tecnica

## Visao Geral

O projeto `GestaoFuncionarios` e uma API REST para gerenciamento de funcionarios. A arquitetura segue o padrao em camadas:

- `Controller`: recebe requisicoes HTTP e devolve respostas
- `Service`: aplica regras de negocio
- `Repository`: faz acesso a dados com Spring Data JPA
- `Entity`: mapeia a tabela do banco

## Stack e Dependencias

Dependencias principais em `pom.xml`:

- `spring-boot-starter-webmvc`
- `spring-boot-starter-data-jpa`
- `spring-boot-h2console`
- `h2` (runtime)

Dependencias de teste:

- `spring-boot-starter-data-jpa-test`
- `spring-boot-starter-webmvc-test`

## Configuracao

Arquivo: `src/main/resources/application.properties`

- `spring.application.name=GestaoFuncionarios`
- `spring.h2.console.enabled=true`
- `spring.h2.console.path=/h2-console`

## Modelo de Dominio

### Entidade `Funcionario`

Arquivo: `src/main/java/_lucas/co/GestaoFuncionarios/Funcionario/Funcionario.java`

Campos:

- `id: Long` (chave primaria, gerada automaticamente)
- `nome: String`
- `cargo: String`
- `departamento: DepartamentoEnum` (persistido como texto)
- `salario: Double`
- `dataAdmissao: String`

### Enum `DepartamentoEnum`

Arquivo: `src/main/java/_lucas/co/GestaoFuncionarios/DepartamentoEnum.java`

Valores permitidos:

- `TI`
- `RH`
- `VENDAS`
- `MARKETING`
- `FINANCEIRO`
- `OPERACOES`

## Camadas da Aplicacao

### Repository

Arquivo: `src/main/java/_lucas/co/GestaoFuncionarios/Funcionario/FuncionarioRepository.java`

Interface que herda `JpaRepository<Funcionario, Long>`, fornecendo CRUD e consultas basicas.

### Service

Arquivo: `src/main/java/_lucas/co/GestaoFuncionarios/Funcionario/FuncionarioService.java`

Metodos:

- `create(FuncionarioCreateDTO createDTO)`
- `getById(Long id)`
- `getAllFuncionarios()`
- `update(FuncionarioCreateDTO updateDTO, Long id)`
- `delete(Long id)`

Regras observadas:

- Conversao de departamento via `DepartamentoEnum.valueOf(...)`.
- Atualizacao parcial no `update(...)`: so troca campos quando nao vazios (ou `salario` nao-NaN).
- Quando `id` nao existe, `getById` lancara excecao de ausencia (`orElseThrow()`).

### Controller

Arquivo: `src/main/java/_lucas/co/GestaoFuncionarios/Funcionario/FuncionarioController.java`

Anotacoes relevantes:

- `@RestController`
- `@RequestMapping("/funcionarios")`
- `@CrossOrigin(origins = "*")`

## API REST

### `POST /funcionarios`

Cria um funcionario.

Request body (`FuncionarioCreateDTO`):

```json
{
  "nome": "Lucas",
  "cargo": "Analista",
  "departamento": "TI",
  "salario": 4200.0,
  "dataAdmissao": "2026-03-13"
}
```

### `GET /funcionarios`

Retorna lista de funcionarios.

### `GET /funcionarios/{id}`

Retorna funcionario por id.

### `PUT /funcionarios/{id}`

Atualiza dados do funcionario.

Utiliza o mesmo body do `POST`.

### `DELETE /funcionarios/{id}`

Remove funcionario por id.

## Execucao

Subir aplicacao:

```bash
./mvnw spring-boot:run
```

Rodar testes:

```bash
./mvnw test
```

## Observacoes Importantes

- O projeto usa nome de pacote `_lucas.co.GestaoFuncionarios` porque `710lucas...` seria invalido em Java.
- O construtor de `Funcionario` possui ordem de parametros diferente da ordem usada no metodo `create(...)` do service. Isso pode causar atribuicao incorreta entre `nome` e `dataAdmissao` durante criacao. Se desejar, esse ponto pode ser corrigido em uma proxima etapa.
- `dataAdmissao` esta como `String`; para validacao mais forte, pode evoluir para `LocalDate`.
