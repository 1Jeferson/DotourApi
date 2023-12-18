# Configurando o Ambiente de Desenvolvimento

- ![SDK](https://img.shields.io/badge/SDK-JDK%2017-blue)
- ![IDE](https://img.shields.io/badge/IDE-Spring%20Tools-green)
- ![Banco de Dados](https://img.shields.io/badge/Banco%20de%20Dados-MySQL-orange)


# Início da Aplicação

Para começar a utilizar , dê start na aplicação no Spring Tools e acesse [Swagger UI](http://localhost:8080/swagger-ui/index.html#/) e explore os endpoints da API.

## ClientController

A classe `ClientController` é responsável por lidar com as solicitações HTTP relacionadas às operações de clientes na aplicação. Ela utiliza o framework Spring e integra-se com a ferramenta de documentação de API Swagger.

## Documentação da API

### Cadastrar um Novo Cliente

```http
POST /client/saveclient
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `nome` | `string` | Nome do cliente |
| `email` | `string` | Email do cliente |
| `senha` | `string` | Senha do cliente |


### Buscar um Cliente
```http
GET /client/{id}
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `number` | Informar o Id do client que deseja buscar |


### Atualizar um Cliente
```http
PUT /client/{id}
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `nome` | `string` | Informe um novo nome |
| `email` | `string` | Informe um novo email |
| `senha` | `string` | Informe uma nova senha |

### Deletar um Cliente
```http
DELETE /client/{id}
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `number` | Informar o Id do cliente que deseja excluir |


## DestinyController

A classe `DestinyController` é responsável por lidar com as solicitações HTTP relacionadas às operações de destinos na aplicação. Ela utiliza o framework Spring e integra-se com a ferramenta de documentação de API Swagger.

### Cadastrar um Destino

```http
POST /destiny/savedestiny
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `destiny` | `string` | Nome do destino |
| `location` | `string` | Nome do local do destino |
| `description` | `string` | Uma descrição sobre o destino |
| `price` | `number` | Preço do destino |


### Buscar um Destino
```http
GET /destiny/{id}
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `number` | Informar o Id do destino que deseja buscar |


### Atualizar um Destino
```http
PUT /destiny/{id}
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `destiny` | `string` | Informe um novo nome do destino |
| `location` | `string` | Informe um novo nome do local do destino |
| `description` | `string` | Informe uma nova descrição sobre o destino |
| `price` | `number` | Informe um novo preço |


### Deletar um Destino
```http
DELETE /destiny/{id}
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `number` | Informar o Id do destino que deseja excluir |

## PurshaceController

A classe `PurshaceController` é responsável por lidar com as solicitações HTTP relacionadas às operações de compra na aplicação. Ela tem relações com cliente e destino.

### Comprar uma passagem

```http
POST /purshace/savepurshace
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `datePurshace` | `date` | Data da compra |
| `dateDeparture` | `date` | Data de Ida |
| `numReturn` | `date` | Data de Volta |
| `numOrder` | `number` | Número do pedido da compra |
| `id_client` | `number` |  **Obrigatório**. Número do id do cliente já existente |
| `nome` | `string` | **Obrigatório**. Nome do cliente já existente |
| `email` | `string` | **Obrigatório**. Email do cliente já existente |
| `senha` | `string` | **Obrigatório**. Senha do cliente já existente |
| `id_destiny` | `number` |  **Obrigatório**. Número do id do destino já existente |
| `destiny` | `string` |  **Obrigatório**. Informe o nome do destino já existente|
| `location` | `string` |  **Obrigatório**. Informe o nome do local do destino já existente |
| `description` | `string` |  **Obrigatório**. Informe uma descrição sobre o destino já existente |
| `price` | `number` |  **Obrigatório**. Informe um preço já existente |


### Buscar um Destino
```http
GET /purshace/{id}
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `number` | Informar o Id da compra que deseja buscar |


### Atualizar uma Compra
```http
PUT /purshace/{id}
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `datePurshace` | `date` | Data da compra que será atualizada |
| `dateDeparture` | `date` | Data de Ida |
| `numReturn` | `date` | Data de Volta |
| `numOrder` | `number` | Número do pedido da compra que será atualizado |
| `id_client` | `number` |  **Obrigatório**. Número do id do cliente já existente |
| `nome` | `string` | **Obrigatório**. Nome do cliente já existente |
| `email` | `string` | **Obrigatório**. Email do cliente já existente |
| `senha` | `string` | **Obrigatório**. Senha do cliente já existente |
| `id_destiny` | `number` |  **Obrigatório**. Número do id do destino já existente |
| `destiny` | `string` |  **Obrigatório**. Informe o nome do destino já existente|
| `location` | `string` |  **Obrigatório**. Informe o nome do local do destino já existente |
| `description` | `string` |  **Obrigatório**. Informe uma descrição sobre o destino já existente |
| `price` | `number` |  **Obrigatório**. Informe um preço já existente |


### Cancelar uma Compra
```http
DELETE /purshace/{id}
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `number` | Informar o Id da compra que deseja excluir |