# 🧾 Fluxo de Fornecedor - Projeto Javagua

Implementa o fluxo de cadastro de **Fornecedores** seguindo o padrão arquitetural **MVC (Model-View-Controller)**.

---

## 🧱 Estrutura do Projeto

Abaixo estão os principais componentes utilizados no fluxo de Fornecedor:

### 📦 FornecedorModel

Classe responsável por representar a entidade **Fornecedor**. Contém os atributos essenciais do modelo e pode incluir anotações JPA para mapeamento com o banco de dados.

---

### 💾 FornecedorRepository

Interface que estende `JpaRepository`, permitindo realizar operações com o banco de dados de forma simples e eficiente.

---

### 🎮 FornecedorController

Classe responsável por receber as requisições HTTP e direcioná-las para a camada de serviço ou repositório. Nela, o CRUD completo foi implementado com os seguintes métodos:

---

## ✨ Funcionalidades do Controller

- **`cadastrarFornecedor`**  
  Endpoint que recebe os dados de um novo fornecedor e realiza o cadastro no sistema.
  (`POST /fornecedores`)

  ```json
  {
    "nome": "Fornecedor Exemplo",
    "cnpj": "12.345.678/0001-99",
    "email": "fornecedor@exemplo.com",
    "telefone": "11999999999"
  }



- **`listarFornecedores`**  
 (GET /fornecedores)
  Retorna uma lista com todos os fornecedores cadastrados.
  ```json
  [
  {
    "id": 1,
    "nome": "Fornecedor Exemplo",
    "cnpj": "12.345.678/0001-99",
    "email": "fornecedor@exemplo.com",
    "telefone": "11999999999"
  },
  {
    "id": 2,
    "nome": "Outro Fornecedor",
    "cnpj": "98.765.432/0001-00",
    "email": "outro@fornecedor.com",
    "telefone": "11888888888"
  }
]
  

- **`editarFornecedor`**  
  Permite atualizar as informações de um fornecedor existente.
(PUT /fornecedores/{id})
  ```json
  {
  "nome": "Fornecedor Atualizado",
  "cnpj": "12.345.678/0001-99",
  "email": "atualizado@fornecedor.com",
  "telefone": "11777777777"
  }



- **`deletarFornecedor`**  
  Remove um fornecedor do sistema com base no ID informado.
(DELETE /fornecedores/{id})
DELETE http://localhost:8080/fornecedores/1


---

## 🗂️ Exemplo de Endpoints

| Método HTTP | Rota                         | Ação                  |
|-------------|------------------------------|------------------------|
| POST        | `/fornecedores`              | Cadastrar fornecedor   |
| GET         | `/fornecedores`              | Listar fornecedores    |
| PUT         | `/fornecedores/{id}`         | Editar fornecedor      |
| DELETE      | `/fornecedores/{id}`         | Deletar fornecedor     |

---

## 📌 Observações

- O projeto está preparado para uso com banco **H2 em memória**.
- Pode ser facilmente adaptado para MySQL, PostgreSQL ou outro banco relacional.
- Segue boas práticas com separação de responsabilidades e padronização de código.

---

Se quiser, posso complementar esse `README` com exemplos de JSON para request/response ou explicar como testar cada rota com o Postman. Quer incluir isso também? 😊








## ⚙️ Configuração do Banco H2

Abaixo estão as configurações utilizadas no `application.properties` para ativar e acessar o banco de dados H2:

```properties
# ==========================
# CONFIGURAÇÃO DO BANCO H2
# ==========================

# Define a URL do banco H2 em memória (será apagado ao desligar a aplicação)
spring.datasource.url=jdbc:h2:mem:testdb

# Define o driver do banco H2
spring.datasource.driverClassName=org.h2.Driver

# Usuário padrão do H2 (por padrão, o H2 usa 'sa' como usuário)
spring.datasource.username=sa

# Senha do banco (vazia por padrão no H2)
spring.datasource.password=

# Habilitar Console do H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Configuração do Hibernate (JPA)
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update

#Acessar:
# localhost:8080/h2-console


