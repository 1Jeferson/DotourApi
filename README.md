# Início da Aplicação

Para começar a utilizar a aplicação, acesse [Swagger UI](http://localhost:8080/swagger-ui/index.html#/) e explore interativamente os endpoints da API.

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
```
GET /client/{id}
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `number` | Informar o Id do client que deseja buscar |


### Atualizar um Cliente
```
PUT /client/{id}
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `nome` | `string` | Informe um novo nome |
| `email` | `string` | Informe um novo email |
| `senha` | `string` | Informe uma nova senha |

### Deletar um Cliente
```
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


## Buscar um Destino
```
GET /destiny/{id}
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `number` | Informar o Id do destino que deseja buscar |


## Atualizar um Destino
```
PUT /destiny/{id}
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `destiny` | `string` | Informe um novo nome do destino |
| `location` | `string` | Informe um novo nome do local do destino |
| `description` | `string` | Informe uma nova descrição sobre o destino |
| `price` | `number` | Informe um novo preço |


## Deletar um Destino
```
DELETE /destiny/{id}
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `number` | Informar o Id do destino que deseja excluir |

## PurshaceController

A classe `PurshaceController` é responsável por lidar com as solicitações HTTP relacionadas às operações de compra na aplicação. Ela tem relações com cliente e destino.

## Comprar uma passagem

```http
POST /purshace/savepurshace
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `datePurshace` | `date` | Data da compra |
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
```
GET /purshace/{id}
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `number` | Informar o Id da compra que deseja buscar |


### Atualizar uma Compra
```
PUT /purshace/{id}
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `datePurshace` | `date` | Data da compra que será atualizada |
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


### Deletar uma Compra
```
DELETE /purshace/{id}
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `number` | Informar o Id da compra que deseja excluir |