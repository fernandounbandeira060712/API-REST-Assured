# Testes Automatizados com RestAssured em Java para reqres.in

Este repositório contém testes automatizados desenvolvidos em Java utilizando a biblioteca RestAssured para testar as APIs disponíveis em [reqres.in](https://reqres.in/).

## Métodos Testados

### GET /api/users/{id}
Este método é utilizado para obter detalhes de um usuário específico pelo seu ID.

#### Teste:
- Testa se o status de resposta é 200 (OK).
- Verifica se o schema da resposta está de acordo com o esperado para um usuário.

### POST /api/users
Este método é utilizado para criar um novo usuário.

#### Teste:
- Testa se o status de resposta é 201 (Created).
- Verifica se o schema da resposta está de acordo com o esperado para a criação de um usuário.

### PUT /api/users/{id}
Este método é utilizado para atualizar os detalhes de um usuário existente pelo seu ID.

#### Teste:
- Testa se o status de resposta é 200 (OK).
- Verifica se o schema da resposta está de acordo com o esperado para a atualização de um usuário.

### DELETE /api/users/{id}
Este método é utilizado para excluir um usuário pelo seu ID.

#### Teste:
- Testa se o status de resposta é 204 (No Content), indicando que o usuário foi excluído com sucesso.

## Validação de Schema
Para assegurar a integridade dos dados recebidos das APIs, todos os testes realizam a validação do schema da resposta. Isso garante que os dados estejam formatados corretamente de acordo com o modelo especificado.

## Pré-requisitos
- Java JDK instalado
- Maven instalado

## Como Executar os Testes
1. Clone o repositório para sua máquina local.
2. Navegue até o diretório raiz do projeto.
3. Execute o comando `mvn test` para executar todos os testes.
4. Os resultados dos testes serão exibidos no console.

## Observações
- Certifique-se de que sua conexão com a internet está funcionando corretamente para acessar a API reqres.in.
- Os testes foram desenvolvidos e executados utilizando o IntelliJ IDEA, mas também podem ser executados em outros ambientes de desenvolvimento Java."# API-REST-Assured" 
