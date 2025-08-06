# Fast Food API

API para gerenciamento de pedidos de fast food, desenvolvida como parte do Tech Challenge da FIAP.

## Vídeo de Apresentação


## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.5.0
- Spring Data JPA
- PostgreSQL
- Docker
- Maven
- Swagger/OpenAPI

## 🏗️ Estrutura do Projeto

```
src/main/java/com/postechfiap_group130/techchallenge_fastfood/
├── api/                            # Camada de Interface
│   └── rest/                       # Controladores REST
│       ├── controller/             # Endpoints da API
│       └── dto/                    # DTOs da API
│
├── application/                     # Camada de Aplicação
│   ├── exceptions/                 # Exceções personalizadas
│   ├── validation/                 # Validações de aplicação
│   └── config/                     # Configurações da aplicação
│
├── core/                           # Núcleo do Domínio (Domain Layer)
│   ├── controllers/                # Controladores de negócio
│   ├── dtos/                       # Objetos de Transferência
│   ├── entities/                   # Entidades de Domínio
│   │   ├── model/                  # Modelos de domínio
│   │   └── valueobjects/           # Objetos de Valor
│   │
│   ├── enums/                      # Enums do Domínio
│   │   ├── OrderStatusEnum.java
│   │   ├── PaymentStatusEnum.java
│   │   └── ProductCategoryEnum.java
│   │
│   ├── interfaces/                 # Portas (interfaces)
│   │   ├── gateway/                # Portas de saída (Gateways)
│   │   └── usecases/               # Casos de Uso (Portas de entrada)
│   │
│   └── usecases/                   # Implementações dos Casos de Uso
│       ├── impl/                   
│       └── ports/                  # Interfaces dos Casos de Uso
│
├── infrastructure/                 # Infraestrutura
│   ├── config/                     # Configurações de infraestrutura
│   ├── persistence/                # Implementações de persistência
│   └── web/                        # Configurações web
│
├── mock_payment/                   # Simulação de pagamento
└── webhook/                        # Webhooks externos
```

### Camadas da Aplicação

1. **API Layer**
   - Expõe os endpoints REST
   - Converte entre DTOs e objetos de domínio
   - Tratamento de erros HTTP

2. **Application Layer**
   - Orquestra o fluxo de casos de uso
   - Gerencia transações
   - Implementa validações de negócio

3. **Domain Layer**
   - Contém a lógica de negócio central
   - Define entidades, agregados e objetos de valor
   - Especifica interfaces (portas) para serviços externos

4. **Infrastructure Layer**
   - Implementa adaptadores para serviços externos
   - Configurações do Spring
   - Acesso a banco de dados

## Funcionalidades

- Cadastro e gerenciamento de produtos
- Cadastro e gerenciamento de clientes
- Criação e acompanhamento de pedidos
- Checkout de pedidos
- Pagamento

## Como Executar

1. Clone o repositório 
https://github.com/deferreira/soat-tech-challenge-fast-food
2. Execute o Docker Compose:
```bash
docker-compose up --build
```

3. Acesse o Swagger ou utilize a Collection:
- http://localhost:8080/swagger-ui.html
- http://localhost:8080/swagger-ui/index.html
- [Uploadi{
	"info": {
		"_postman_id": "171bd94b-d540-4226-8230-5bc68401496c",
		"name": "FastFood",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "45299891",
		"_collection_link": "https://deniseferreira-2135244.postman.co/workspace/Denise-Ferreira's-Workspace~a1562173-fdc7-4b70-8b1f-20c596e4a671/collection/45299891-171bd94b-d540-4226-8230-5bc68401496c?action=share&source=collection_link&creator=45299891"
	},
	"item": [
		{
			"name": "Customer",
			"item": [
				{
					"name": "Create Customer",
					"request": {
						"method": "POST",
						"header": [
							{
								"key": "Accept",
								"value": "application/json"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"name\": \"Fulano de Tal da Silva\",\r\n    \"email\": \"email@email.com\",\r\n    \"password\": \"res74589\",\r\n    \"cpf\": \"763.349.200-73\"\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/customers/create",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"customers",
								"create"
							]
						}
					},
					"response": []
				},
				{
					"name": "Find Customer by CPF",
					"request": {
						"method": "GET",
						"header": [
							{
								"key": "Accept",
								"value": "application/json"
							}
						],
						"url": {
							"raw": "http://localhost:8080/customers/763.349.200-73",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"customers",
								"763.349.200-73"
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "Product",
			"item": [
				{
					"name": "Create Product",
					"request": {
						"method": "POST",
						"header": [
							{
								"key": "Content-Type",
								"value": "application/json"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "{\n  \"name\": \"coca cola\",\n  \"description\": \"coca cola lata 350ml\",\n  \"price\": 6.90,\n  \"category\": \"BEBIDA\"\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "localhost:8080/products/create",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"products",
								"create"
							]
						}
					},
					"response": []
				},
				{
					"name": "Get Product by Category",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "localhost:8080/products/category/BEBIDA",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"products",
								"category",
								"BEBIDA"
							]
						}
					},
					"response": []
				},
				{
					"name": "Update product",
					"request": {
						"method": "PUT",
						"header": [
							{
								"key": "Content-Type",
								"value": "application/json"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "{\n    \"id\": 4,\n    \"name\": \"Picole uva\",\n    \"description\": \"picole recheado sabor uva\",\n    \"price\": 13.90,\n    \"category\": \"SOBREMESA\",\n    \"avaliable\": true\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "localhost:8080/products/update",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"products",
								"update"
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "Orders",
			"item": [
				{
					"name": "Order Checkout",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"items\":[\r\n        {\r\n            \"productId\": 2,\r\n            \"quantity\": 1,\r\n            \"price\": 12.50\r\n        }\r\n    ]\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/orders/checkout",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"orders",
								"checkout"
							]
						}
					},
					"response": []
				},
				{
					"name": "Get Order by ID",
					"request": {
						"method": "GET",
						"header": [
							{
								"key": "Accept",
								"value": "application/json"
							}
						],
						"url": {
							"raw": "http://localhost:8080/orders/2",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"orders",
								"2"
							]
						}
					},
					"response": []
				},
				{
					"name": "Get Orders",
					"request": {
						"method": "GET",
						"header": [
							{
								"key": "Accept",
								"value": "application/json"
							}
						],
						"url": {
							"raw": "http://localhost:8080/orders",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"orders"
							]
						}
					},
					"response": []
				},
				{
					"name": "Update Order Status",
					"request": {
						"method": "PATCH",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"items\":[\r\n        {\r\n            \"product_id\": 2,\r\n            \"quantity\": 1,\r\n            \"price\": 15\r\n        },\r\n        {\r\n            \"product_id\": 7,\r\n            \"quantity\": 1,\r\n            \"price\": 30\r\n        }\r\n    ]\r\n}"
						},
						"url": {
							"raw": "http://localhost:8080/orders/1/status/FINALIZADO",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"orders",
								"1",
								"status",
								"FINALIZADO"
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "Payments",
			"item": [
				{
					"name": "Create payment",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"orderId\": 1,\r\n    \"amount\": 127\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/payments/create",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"payments",
								"create"
							]
						}
					},
					"response": []
				},
				{
					"name": "Get Payment Status",
					"request": {
						"method": "GET",
						"header": [
							{
								"key": "Accept",
								"value": "application/json"
							}
						],
						"url": {
							"raw": "http://localhost:8080/payments/1/status",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"payments",
								"1",
								"status"
							]
						}
					},
					"response": []
				},
				{
					"name": "Update PaymentStatus",
					"request": {
						"method": "POST",
						"header": [
							{
								"key": "Accept",
								"value": "application/json"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"status\": \"APPROVED\"\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/payments/1/status",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"payments",
								"1",
								"status"
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "Webhook (notification)",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Accept",
						"value": "application/json"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"payment_id\": \"1\",\r\n    \"status\": \"REJECTED\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/webhook/payments",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"webhook",
						"payments"
					]
				}
			},
			"response": []
		},
		{
			"name": "Mock Update Status (notification)",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n   \"paymentId\": 1\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/mock/payments",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"mock",
						"payments"
					]
				}
			},
			"response": []
		}
	]
}ng FastFood233.postman_collection…]()


## 🚀 Ordem para Execução das APIs

### 1. Configuração Inicial
```http
# Verificar saúde da API
GET /actuator/health
```

### 2. Gerenciamento de Produtos
```http
# 2.1 Criar um novo produto
POST /products/create
Content-Type: application/json

{
  "name": "X-Burger",
  "description": "Hambúrguer com queijo",
  "price": 25.90,
  "category": "LANCHE"
}

# 2.2 Listar produtos por categoria
GET /products/category/LANCHE

# 2.3 Atualizar um produto existente
PUT /products/update
Content-Type: application/json

{
  "id": 1,
  "name": "X-Burger Especial",
  "description": "Hambúrguer com queijo e bacon",
  "price": 29.90,
  "category": "LANCHE",
  "available": true
}
```

### 3. Gerenciamento de Clientes
```http
# 3.1 Cadastrar um novo cliente
POST /customers/create
Content-Type: application/json

{
  "name": "João Silva",
  "email": "joao@email.com",
  "password": "senha123",
  "cpf": "123.456.789-09"
}

# 3.2 Buscar cliente por CPF
GET /customers/123.456.789-09
```

### 4. Gerenciamento de Pedidos
```http
# 4.1 Criar um novo pedido (checkout)
POST /orders/checkout
Content-Type: application/json

{
  "customerCpf": "123.456.789-09",
  "items": [
    {
      "productId": 1,
      "quantity": 2
    }
  ]
}

# 4.2 Listar todos os pedidos
GET /orders

# 4.3 Buscar pedido por ID
GET /orders/1

# 4.4 Atualizar status do pedido
PATCH /orders/1/status/EM_PREPARACAO
```

### 5. Processamento de Pagamentos
```http
# 5.1 Criar pagamento
POST /payments/create
Content-Type: application/json

{
  "orderId": 1,
  "amount": 51.80
}

# 5.2 Verificar status do pagamento
GET /payments/1/status

# 5.3 Atualizar status do pagamento (simulação)
POST /payments/1/status
Content-Type: application/json

{
  "status": "APROVADO"
}
```

### 6. Webhook (Notificações)
```http
# 6.1 Receber notificação de pagamento
POST /webhook/payments
Content-Type: application/json

{
  "payment_id": 1,
  "status": "APROVADO"
}
```

### 7. Mock de Pagamento (Para testes)
```http
# 7.1 Simular atualização de status de pagamento
POST /mock/payments
Content-Type: application/json

{
  "paymentId": 1
}
```

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
