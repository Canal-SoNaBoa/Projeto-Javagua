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
