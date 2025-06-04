# soat-tech-challenge-fast-food

## Executando o Projeto com Docker Compose

Certifique-se de que você tenha o Docker e o Docker Compose instalados em sua máquina. Siga os passos abaixo para executar o projeto:

1. **Construa e inicie os containers**:
   No diretório raiz do projeto (onde o arquivo `docker-compose.yml` está localizado), execute o seguinte comando:
   ```bash
   docker-compose up --build

2. Acesse a API: Após os containers serem iniciados, a API estará disponível em:
   http://localhost:8080

3. Banco de Dados: O banco de dados PostgreSQL estará disponível na porta 5432. Você pode acessá-lo usando as seguintes credenciais:

Host: localhost
Porta:<vscode_annotation details='%5B%7B%22title%22%3A%22hardcoded-credentials%22%2C%22description%22%3A%22Embedding%20credentials%20in%20source%20code%20risks%20unauthorized%20access%22%7D%5D'> </vscode_annotation>5432
Usuário: restuser
Senha: restpass
Banco de Dados: restdb

4. Parar os containers: Para parar os containers, pressione Ctrl+C no terminal onde o comando foi executado ou use:

docker-compose down

5. Remover volumes (opcional): Se você quiser limpar os dados persistidos no volume do banco de dados, execute:

docker-compose down -v