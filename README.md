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

# Docker Compose
1. Clone o repositório 
https://github.com/deferreira/soat-tech-challenge-fast-food
2. Execute o Docker Compose:
```bash
docker-compose up --build
```

3. Acesse a documentação Swagger:
- http://localhost:8080/swagger-ui.html
- http://localhost:8080/swagger-ui/index.html

# Kubernetes
1. Clone o repositório 
https://github.com/deferreira/soat-tech-challenge-fast-food
2. subir o banco de dados postgres 
   2.1 - kubectl apply -f db/1_db_namespace.yml
   2.2 - kubectl apply -f db/2_db_secret.yml
   2.3 - kubectl apply -f db/3_db_configmap.yml
   2.4 - kubectl apply -f db/4_db_deployment.yml
   2.5 - kubectl apply -f db/5_db_service.yml
   2.6 - kubectl apply -f db/6_db_hpa.yml
3. subir a api
   3.1 - kubectl apply -f app/1_app_namespace.yml
   3.2 - kubectl apply -f app/2_app_secret.yml
   3.3 - kubectl apply -f app/3_app_configmap.yml
   3.4 - kubectl apply -f app/4_app_deployment.yml
   3.5 - kubectl apply -f app/5_app_service.yml
   3.6 - kubectl apply -f app/6_app_hpa.yml

4. Acesse a documentação Swagger:
- http://localhost:30080/swagger-ui.html
- http://localhost:30080/swagger-ui/index.html


## Status do Pedido

Os pedidos podem ter os seguintes status:
- RECEBIDO
- EM_PREPARACAO
- PRONTO
- FINALIZADO

## Arquitetura de Kubernetes

![Desenho Aquitetura Kubernetes](Arquitetura_Kubernetes.png)

## Arquitetura de negócio

1. Order
- Fluxo de Checkout (Criar Pedido)
Order
![Checkout](https://drive.google.com/uc?export=view&id=1ZAsgklCNTtMHvifKypVWJNK0ymMNUyeD&filename=imagem.png)

- Fluxo de Busca de Pedidos
![New Get Orders](https://drive.google.com/uc?export=view&id=11VQyMhUNWZEysEv7EYRwc35LxrDL9PFo&filename=imagem.png)

- Fluxo de Busca de Pedidos por ID
![Get Order by Id](https://drive.google.com/uc?export=view&id=1AVUn7FVVSxTvVErpMYOPMTCxWK4TFCOa&filename=imagem.png)

- Fluxo de Atualização de Status de Pedido
![New Update Order Status](https://drive.google.com/uc?export=view&id=1YwpVu4ZQ799VdKtlhcTsnvnXMT2pcdZ0&filename=imagem.png)

2. Customer
- Fluxo de Criação de Cliente
![Create Customer](https://drive.google.com/uc?export=view&id=19nWQRlb4ebtrKKRJMqDq_M3-DsPX_NXr&filename=imagem.png)

- Fluxo de Consulta de Cliente por CPF
![Get Customer By Cpf](https://drive.google.com/uc?export=view&id=10PtT35LG6ur5nFVfKPrtiLmNI8-GmZEN&filename=imagem.png)

3. Product
- Fluxo de Consulta de Produto por Categoria
![GetProduct By Category](https://drive.google.com/uc?export=view&id=17xTgt2EN_NEtQc0EKIYYBUukU5fvncul&filename=imagem.png)

- Fluxo de Criação de Produto
![Create Product](https://drive.google.com/uc?export=view&id=1HCYbOEUTX0zsV7IGiEHdt_B_aQymnfzK&filename=imagem.png)

- Fluxo de Atualização de Produto
![Update Product](https://drive.google.com/uc?export=view&id=1FM-kZDMAkWiPJJXAi2mpIm2nb5pi-L2Y&filename=imagem.png)

4. Payment
- Fluxo de Consulta de Status de Pagamento
![Get payment Status](https://drive.google.com/uc?export=view&id=15cMtUxSZovchB5_MfogsawedBxB2Qwj8&filename=imagem.png)

- Fluxo de Criação de Pagamento
![New Create Payment](https://drive.google.com/uc?export=view&id=1XEut1e-fDMsPKG198Wh0k3SgpHaByY-L&filename=imagem.png)

- Recebe notificação e Atualiza Status de Pagamento e da Ordem
![New Update Status](https://drive.google.com/uc?export=view&id=15USTvFBMc8RK9K7a2pyOigPc-jUCHfkB&filename=imagem.png)