# Fast Food API

API para gerenciamento de pedidos de fast food, desenvolvida como parte do Tech Challenge da FIAP.

## Vídeo de Apresentação

[![Vídeo de Apresentação](https://img.youtube.com/vi/brByCx_4ksk/0.jpg)](https://youtu.be/brByCx_4ksk)

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.5.0
- Spring Data JPA
- PostgreSQL
- Docker
- Maven
- Swagger/OpenAPI

## Estrutura do Projeto

```
/src
 |__/main
    |__/java
       |__/com/postechfiap_group130/techchallenge_fastfood
          |__/domain 			# Nucleo: entidades, interfaces das portas, regras de negócio
          |  |__/model
          |  |__/ports
          |     |__/in  		# Interfaces de entrada (casos de uso)
          |     |__/out			# Interfaces de saída (repositórios, gateways)
          |
          |__/application 		# Mapeamento e orquestração de serviços
          |
          |__/adapters 			# Adapters (entrada e saída)
          |  |__/in			# Adapters de entrada (controllers)
          |  |__/out			# Adapters de saída (JpaRepositories, APIs externas)
          |
          |__/config 			# Beans, configurações, injeções de dependencias
```

## Funcionalidades

- Cadastro e gerenciamento de produtos
- Cadastro e gerenciamento de clientes
- Criação e acompanhamento de pedidos
- Checkout de pedidos

## Endpoints

### Produtos
- `GET /api/produtos/category/{category}` - Lista produtos por categoria
- `POST /api/produtos` - Cadastra novo produto
- `PUT /api/produtos` - Atualiza produto existente
- `DELETE /api/produtos` - Remove produto

### Pedidos
- `POST /orders/fake-checkout` - Realiza checkout de pedido
- `GET /orders` - Lista todos os pedidos

## Como Executar

1. Clone o repositório 
https://github.com/deferreira/soat-tech-challenge-fast-food
2. Execute o Docker Compose:
```bash
docker-compose up --build
```

3. Acesse a documentação Swagger:
- http://localhost:8080/swagger-ui.html
- http://localhost:8080/swagger-ui/index.html

## Status do Pedido

Os pedidos podem ter os seguintes status:
- RECEBIDO
- EM_PREPARACAO
- PRONTO
- FINALIZADO

## Arquitetura de negócio

1. Order
- Fluxo de Checkout (Criar Pedido)
Order
![Checkout](https://drive.google.com/uc?export=view&id=1ZAsgklCNTtMHvifKypVWJNK0ymMNUyeD&filename=imagem.png)

- Fluxo de Busca de Pedidos
![New Get Orders](https://drive.google.com/file/d/11VQyMhUNWZEysEv7EYRwc35LxrDL9PFo/view?usp=drivesdk)

- Fluxo de Busca de Pedidos por ID
![Get Order by Id](https://drive.google.com/file/d/1AVUn7FVVSxTvVErpMYOPMTCxWK4TFCOa/view?usp=drivesdk)

- Fluxo de Atualização de Status de Pedido
![New Update Order Status](https://drive.google.com/file/d/1YwpVu4ZQ799VdKtlhcTsnvnXMT2pcdZ0/view?usp=drivesdk)

2. Customer
- Fluxo de Criação de Cliente
![Create Customer](https://drive.google.com/file/d/19nWQRlb4ebtrKKRJMqDq_M3-DsPX_NXr/view?usp=drivesdk)

- Fluxo de Consulta de Cliente por CPF
![Get Customer By Cpf](https://drive.google.com/file/d/10PtT35LG6ur5nFVfKPrtiLmNI8-GmZEN/view?usp=drivesdk)

3. Product
- Fluxo de Consulta de Produto por Categoria
![GetProduct By Category](https://drive.google.com/file/d/17xTgt2EN_NEtQc0EKIYYBUukU5fvncul/view?usp=drivesdk)

- Fluxo de Criação de Produto
![Create Product](https://drive.google.com/file/d/1HCYbOEUTX0zsV7IGiEHdt_B_aQymnfzK/view?usp=drivesdk)

- Fluxo de Atualização de Produto
![Update Product](https://drive.google.com/file/d/1FM-kZDMAkWiPJJXAi2mpIm2nb5pi-L2Y/view?usp=drivesdk)

4. Payment
- Fluxo de Consulta de Status de Pagamento
![Get payment Status](https://drive.google.com/file/d/15cMtUxSZovchB5_MfogsawedBxB2Qwj8/view?usp=drivesdk)

- Fluxo de Criação de Pagamento
![New Create Payment](https://drive.google.com/file/d/1XEut1e-fDMsPKG198Wh0k3SgpHaByY-L/view?usp=drivesdk)

- Recebe notificação e Atualiza Status de Pagamento e da Ordem
![New Update Status](https://drive.google.com/file/d/15USTvFBMc8RK9K7a2pyOigPc-jUCHfkB/view?usp=drivesdk)