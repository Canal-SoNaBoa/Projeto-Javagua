
# 💧 Sistema de Vendas e Gerenciamento - Distribuidora de Água

Este projeto é um sistema web em Java com Spring Boot para controle de vendas, clientes e estoque de uma **distribuidora de água**. Começando com funcionalidades básicas de 
**CRUD** e banco de dados em memória (**H2**), a aplicação será evoluída com recursos mais avançados ao longo do tempo, como **mensageria**, **funções personalizadas**, e muito mais!

## 🚀 Objetivo do Projeto

Desenvolver um sistema completo para facilitar o dia a dia de uma distribuidora de água, desde o cadastro de clientes até o controle de pedidos e entregas.

## 🛠️ Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Lombok
- Maven
- Postman (para testes)

## ✅ Funcionalidades Atuais

- [x] Cadastro de clientes
- [x] Cadastro de produtos (galões de água)
- [x] Registro de pedidos
- [x] Banco de dados em memória com H2
- [x] Validações com Bean Validation
- [x] Tratamento global de erros

## 🧪 Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/sistema-distribuidora-agua.git

2. Acesse o sistema:

API: http://localhost:8080

H2 Console: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:testdb

Username: sa

Password: (em branco)


🧠 Conceitos Aplicados
Arquitetura MVC (Model-View-Controller)

Boas práticas de programação com Java

Clean Code e SOLID

Validação de dados e tratamento de exceções

 ***************************
  CONFIGURAÇÃO DO BANCO H2
***************************

*Define a URL do banco H2 em memória (será apagado ao desligar a aplicação)

spring.datasource.url=jdbc:h2:mem:testdb

*Define o driver do banco H2

spring.datasource.driverClassName=org.h2.Driver

*Usuário padrão do H2 (por padrão, o H2 usa 'sa' como usuário)

spring.datasource.username=sa

*Senha do banco (vazia por padrão no H2)

spring.datasource.password=


*Habilitar Console do H2

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

*Configuração do Hibernate (JPA)

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update

***************************************************************



🤝 Contribuições
Este projeto está em constante evolução. Sinta-se à vontade para contribuir com sugestões
