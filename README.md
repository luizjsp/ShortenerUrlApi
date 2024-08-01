# Encurtador de URL

Um serviço de encurtamento de URLs desenvolvido em Spring Boot. Esta API permite criar URLs curtas para URLs longas, redirecionar para URLs longas usando URLs curtas e visualizar estatísticas de uso.

## Funcionalidades

- **Criar URLs Curtas**: Gera uma URL curta para uma URL longa fornecida.
- **Redirecionar**: Redireciona uma URL curta para a URL longa correspondente.
- **Visualizar Estatísticas**: Obtém uma lista de todas as URLs encurtadas com seus respectivos contadores de acesso.

## Tecnologias

- Java 17
- Spring Boot 3.3.2
- Spring Data JPA
- MySQL (para produção)
- Swagger

## Pré-requisitos

- Java 17
- Maven
- (Opcional) MySQL para produção

## Instalação

1. **Clone o repositório:**

    ```bash
    git clone https://github.com/luizjsp/ShortenerUrlApi.git
    ```

2. **Navegue até o diretório do projeto:**

    ```bash
    cd Shortener-Url-Api
    ```

3. **Instale as dependências:**

    ```bash
    mvn install
    ```

4. **Configure o banco de dados (opcional):**

    Se estiver usando MySQL, configure as propriedades do banco de dados no arquivo `application.properties` ou `application.yml`.

5. **Execute a aplicação:**

    ```bash
    mvn spring-boot:run
    ```

## Uso

- **Criar URL Curta**

    Faça uma solicitação POST para `/api/v1/urls` com o corpo da solicitação no formato JSON:

    ```json
    {
      "originalUrl": "http://www.uol.com.br"
    }
    ```

    A resposta incluirá a URL curta gerada.

- **Redirecionar URL Curta**

    Faça uma solicitação GET para `/api/v1/urls/{shortUrl}`, substituindo `{shortUrl}` pela URL curta. Você será redirecionado para a URL longa correspondente.

- **Visualizar Estatísticas**

    Faça uma solicitação GET para `/api/v1/urls/stats` para obter uma lista de todas as URLs encurtadas e suas estatísticas de acesso.

## Documentação da API

A documentação da API está disponível no Swagger UI. Após iniciar a aplicação, você pode acessá-la no seguinte endereço:

[Swagger UI](http://localhost:8080/swagger-ui/index.html)  

## Testes

### Descrição dos Testes

O projeto inclui um conjunto de testes para garantir que a aplicação funcione corretamente e para prevenir regressões. Os testes cobrem aspectos como controle de URLs, encurtamento e gerenciamento de URLs.

### Pré-requisitos

Certifique-se de ter o ambiente configurado corretamente com as seguintes dependências:

- [JUnit](https://junit.org/junit4/) (para testes unitários)
- [Mockito](https://site.mockito.org/) (para mocks e testes de integração)

### Como Executar os Testes

Para executar os testes, você pode usar o comando abaixo ou clicando com o botão direito na classe de teste e selecionando "Run".. Certifique-se de estar na raiz do projeto:

#### Usando Maven:

```bash
mvn test
```

## Contribuição

Contribuições são bem-vindas! Se você deseja contribuir para este projeto, por favor siga estas etapas:

1. Faça um fork do repositório.
2. Crie uma nova branch para sua modificação.
3. Faça suas alterações e adicione testes, se necessário.
4. Envie um pull request descrevendo suas alterações.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).

## Contato

Para mais informações, entre em contato:

- **Autor:** Luiz Carvalhêdo de Castro Neto
- **Email:** luizjsp@yahoo.com.br
- **GitHub:** [github.com/luizjsp](https://github.com/luizjsp)
