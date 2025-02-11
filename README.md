# Projeto Java Spring Boot REST API

## Visão Geral
Este projeto Java Spring Boot é uma aplicação RESTful avançada que incorpora uma ampla gama de temas e tecnologias essenciais para o desenvolvimento moderno de APIs. 
Desde a configuração inicial até o deploy na nuvem da Amazon:

-------------
## Entidades Principais

### Cozinha
- Representa os tipos de culinária oferecidos pelos restaurantes. Exemplo: "Italiana", "Japonesa", "Brasileira".
- Cada restaurante está associado a uma cozinha, definindo o tipo de culinária que ele serve.

### Restaurante
- É a entidade central que representa um restaurante no sistema.
- Relaciona-se com:
    - **Cozinha**: Define o tipo de culinária.
    - **Formas de Pagamento**: Lista de métodos de pagamento aceitos.
    - **Produtos**: Pratos ou itens oferecidos pelo restaurante.
    - **Endereço**: Localização do restaurante.
    - **Usuários (Responsáveis)**: Usuários que gerenciam o restaurante.

### Produto
- Representa os itens ou pratos oferecidos pelo restaurante.
- Contém informações como nome, descrição, preço e status (ativo ou inativo).
- Relaciona-se com:
    - **FotoProduto**: Imagens ilustrativas do produto.

### Pedido
- Representa uma compra feita por um cliente.
- Relaciona-se com:
    - **Restaurante**: O restaurante que está atendendo o pedido.
    - **Forma de Pagamento**: Método escolhido para pagar.
    - **Itens do Pedido**: Detalhes sobre os produtos incluídos.
    - **Cliente (Usuário)**: Quem fez o pedido.
    - **Endereço de Entrega**: Onde o pedido será entregue.

### Usuário
- Representa uma pessoa que interage com o sistema, seja como cliente ou responsável por um restaurante.
- Relaciona-se com:
    - **Grupos e Permissões**: Controle de acesso no sistema.

---

### Relação entre Cozinha e Restaurante
- A entidade **"Cozinha"** não representa uma cozinha física, mas sim o **tipo de culinária** do restaurante.
- Exemplos:
    - Um restaurante com o nome "La Bella Itália" pode estar associado a uma "Cozinha" com o nome "Italiana".
    - Outro restaurante, "Sushi House", pode estar associado a uma "Cozinha" com o nome "Japonesa".
- Essa relação permite classificar os restaurantes pelo estilo de comida que oferecem.

---

### Resumo da Lógica
1. **Cozinha**: Tipo de culinária oferecido pelo restaurante.
2. **Restaurante**: É um estabelecimento associado a uma cozinha, produtos, métodos de pagamento e responsáveis.
3. **Produtos**: Itens servidos pelo restaurante.
4. **Pedidos**: Registro das compras feitas pelos clientes, com todos os detalhes (itens, valores, status e forma de pagamento).


-------------
## Temas e Técnologias utilizadas na construção do projeto:

*  Spring e Injeção de Dependências: | _Compreensão profunda do ecossistema Spring e seu papel na construção de aplicativos robustos._

* JPA, Hibernate e Flyway: | _Utilização eficiente de tecnologias de persistência de dados, garantindo consistência e escalabilidade._

* Spring Data JPA: _Exploração das capacidades do Spring Data JPA para simplificar o acesso e manipulação de dados._

* Domain-Driven Design (DDD): _Aplicação de princípios de design que refletem a lógica de negócios no código._

* Fundamentos Avançados de REST com Spring: _Exploração de conceitos avançados para criar APIs RESTful poderosas._

* Validações com Bean Validation: _Garantia da integridade dos dados através de validações eficazes._

* Tratamento e Modelagem de Erros da API: _Implementação de estratégias robustas para lidar com erros e exceções._

* Testes de Integração: _Desenvolvimento de testes para garantir a estabilidade e confiabilidade da aplicação._

* Modelagem Avançada de APIs: _Abordagem detalhada para a criação de APIs flexíveis e escaláveis._

* Modelagem de Projeções, Pesquisas e Relatórios: _Exploração de técnicas avançadas para moldar dados conforme as necessidades._

* Upload e Download de Arquivos: _Implementação de funcionalidades para manipulação segura de arquivos._

* Envio de E-mails Transacionais: _Integração de serviços de e-mail para comunicação eficaz._

* Cache de HTTP: _Otimização de desempenho por meio de estratégias eficientes de cache._

* Documentação com OpenAPI (Swagger): _Criação de documentação interativa para facilitar o entendimento e uso da API._

* HATEOAS e Discoverability: _Adoção de práticas que facilitam a descoberta e navegação nas APIs._

* CORS e Consumo de APIs com Java e JavaScript: _Gerenciamento de segurança e integração com diferentes plataformas._

* Spring Security, OAuth2 e JWT: _Implementação de camadas robustas de segurança para proteger a aplicação._

* Cloud-Native APIs: _Adaptação para ambientes nativos da nuvem, garantindo escalabilidade e flexibilidade._
  
* Dockerização da Aplicação: _Empacotamento da aplicação em contêineres para fácil distribuição e escalabilidade._

* Configuração e Gerenciamento de Logs: _Implementação de práticas eficazes para rastreamento e solução de problemas._

* Deploy em Produção na Nuvem da Amazon: _Estratégias para implantar a aplicação de forma segura e eficiente._
  
