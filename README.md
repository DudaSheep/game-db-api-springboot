# 🎮 Projeto de Gerenciamento de Jogos



## 🚀 Descrição do Projeto

Este projeto é uma API RESTful desenvolvida em Spring Boot para gerenciar informações sobre jogos. Ele permite criar, listar, atualizar e buscar jogos por status. Podendo ser sua agenda pessoal de jogos.

## ✨ Funcionalidades

-   **➕ Criação de Jogos:** Permite cadastrar novos jogos com nome, descrição e status.
-   **➕ Listagem de Jogos:** Retorna todos os jogos cadastrados.
-   **➕ Busca por Status:** Permite buscar jogos por status (FINISHED, ONGOING, ONHOLD).
-   **➕ Atualização de Status:** Permite atualizar o status de um jogo específico.

## ️✨ Tecnologias Utilizadas

-   **Spring Boot:** Framework Java para desenvolvimento rápido de aplicações web.
-   **Spring Data JPA:** Facilita o acesso a dados e a persistência em bancos de dados relacionais.
-   **H2 Database:** Banco de dados em memória para desenvolvimento e testes.
-   **Swagger:** Ferramenta para documentação e teste de APIs RESTful.
-   **Java 17 (ou versão superior):** ☕ Linguagem de programação utilizada no projeto.
-   **Maven (ou Gradle):** Ferramenta de build e gerenciamento de dependências.

## ⚙️ Configuração do Projeto

1.  **Clone o repositório:**

    ```bash
    git clone https://github.com/DudaSheep/game-db-api-springboot.git
    ```

2.  **Navegue até o diretório do projeto:**

    ```bash
    cd game-db-api-springboot
    ```

3.  **Execute a aplicação:**

    ```bash
    ./mvnw spring-boot:run
    ```

    ou

    ```bash
    Botão play vscode ▶️
    ```

4.  **Acesse a documentação do Swagger:**

    Abra o navegador e acesse `http://localhost:8080/swagger-ui/index.html`.

##  Endpoints da API

-   `POST /games`: Cadastra um novo jogo.
-   `GET /games`: Retorna todos os jogos cadastrados.
-   `GET /games/status/{status}`: Retorna jogos por status.
-   `PATCH /games/{id}/status`: Atualiza o status de um jogo.

## ️ Imagem do Projeto

[![Swagger](/src/main/resources/static/img1.PNG)](link_para_o_repositório_aqui)