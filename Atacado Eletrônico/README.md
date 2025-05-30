# 🛒 Atacado Eletrônico - Sistema Completo

Bem-vindo ao **Atacado Eletrônico**, um sistema completo de gerenciamento para um atacado de produtos eletrônicos. Este projeto simula a operação de uma empresa com duas áreas principais: **clientes** e **colaboradores** (administradores), com funcionalidades como cadastro de produtos, login seguro, relacionamento com fabricantes, catálogo público e painel administrativo.

## 🔧 Tecnologias Utilizadas

### 🚀 Front-end
- ![React](https://img.shields.io/badge/React-20232A?style=flat&logo=react&logoColor=61DAFB) `React.js`
- ![Axios](https://img.shields.io/badge/Axios-5A29E4?style=flat&logo=axios&logoColor=white) `Axios`
- ![Vite](https://img.shields.io/badge/Vite-646CFF?style=flat&logo=vite&logoColor=white) `Vite`
- ![HTML](https://img.shields.io/badge/HTML5-E34F26?style=flat&logo=html5&logoColor=white)
- ![CSS](https://img.shields.io/badge/CSS3-1572B6?style=flat&logo=css3&logoColor=white)

### 💻 Back-end
- ![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white) `Java 17`
- ![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=flat&logo=spring-boot&logoColor=white) `Spring Boot`
- ![Spring Data JPA](https://img.shields.io/badge/JPA-59666C?style=flat&logo=hibernate&logoColor=white) `Spring Data JPA`

### 🛢 Banco de Dados
- ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=mysql&logoColor=white)

### Modelo DER 
![image](https://github.com/user-attachments/assets/b8269861-ef04-41b7-9fea-25922e134d9e)


### ☁️ Outros
- ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=flat&logo=postman&logoColor=white) para testar APIs REST
- ![Git](https://img.shields.io/badge/Git-F05032?style=flat&logo=git&logoColor=white) + ![GitHub](https://img.shields.io/badge/GitHub-181717?style=flat&logo=github&logoColor=white) para versionamento

## 🧩 Funcionalidades

- 📦 Cadastro e gerenciamento de produtos (nome, preço, estoque, descrição, etc.)
- 🏭 Relação com fabricantes (via chave estrangeira)
- 🛒 Catálogo público para clientes visualizarem produtos
- 🔐 Login com validação de senha (criptografada com BCrypt)
- 🧑‍💼 Painel administrativo para colaboradores com navegação entre páginas
- 🔍 Consulta de produtos, fabricantes e clientes

## 📁 Estrutura do Projeto

```
backend/
├── model/
├── dto/
├── repository/
├── service/
└── controller/

frontend/
├── pages/
├── components/
└── App.jsx
```

## ⚙️ Como Rodar o Projeto

1. Clone o repositório
```bash
git clone https://github.com/seu-usuario/atacado-eletronico.git
```
2. Configure o `application.properties` com seus dados MySQL
3. Rode o back-end (Spring Boot)
4. Rode o front-end (React + Vite)
```bash
npm install
npm run dev
```

---

# ! ! ! ESTÁ EM DESENVOLVIMENTO E SUJEITO A ADIÇÃO DE FUNCIONALIDADES ! ! !
