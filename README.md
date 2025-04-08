# 🌱 Branch `develop`

Esta branch representa o **ambiente de desenvolvimento** do projeto. É aqui que novas funcionalidades, melhorias e correções são desenvolvidas antes de irem para produção.

## 📌 O que é a `develop`?

A `develop` é a linha do tempo principal do projeto enquanto ele está em construção. Todas as novas funcionalidades devem ser criadas a partir dela e depois, quando testadas e
validadas, serão integradas à branch `main` (produção).

## 🧪 Quando usar?

- Criou uma nova funcionalidade? Crie uma branch a partir da `develop` (ex: `feature/cadastro-cliente`)  
- Terminou de desenvolver e testar? Faça um merge da sua feature na `develop`
- A branch `develop` **sempre deve estar funcional** (mesmo em desenvolvimento)

## 🔁 Fluxo Simples

```bash
# 1. Atualize a develop localmente
git checkout develop
git pull origin develop

# 2. Crie sua branch de funcionalidade
git checkout -b feature/nome-da-sua-feature

# 3. Após o desenvolvimento e testes
git checkout develop
git merge feature/nome-da-sua-feature
git push origin develop
