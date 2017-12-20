# stockmonitor

## Executando a aplicação

- clonar este repositório.
- verificar as propriedade em application.properties e alterá-las de necessário.
- na raíz do projeto, executar comando mvn spring-boot:run

## Framework

### Spring Boot

O framework utilizado é o Spring Boot, juntamente com outas dependências. Seu mecanismo de auto-configuração e gerenciamento de dependências agiliza enormemente o desenvolvimento para este tipo de aplicação (prototipagem).

## REST endpoints

### Spring Data REST

Spring Data REST cria automaticamente endpoints REST e controllers para inserção, exclusão e atualização de registros a partir dos repositórios JPA (Jparepository) anotados com @RepositoryRestResource.

Acessando localhost:8080 é retornado um texto em formado JSON com os endereços para acessar as entidades.

Para verificar os endpoints, basta usar um cliente REST como no exemplo da imagem a seguir, onde é adicionada uma conta.

[REST Client](https://github.com/diasdev/stockmonitor/blob/master/src/main/resources/documentation/images/rest_endpoint.png)

## Banco de dados e persistência

### H2 e JPA/Hibernate

Para facilitar a criação e testes, foi utilizado o banco embarcado H2 configurado para persistir os dados em arquivo.
A configuração atual para a propriedade **_ddl-auto_** é **_create_**. A base é recriada a cada inicialização da aplicação, ocasição onde o script data-h2.sql é executado para popular a base. Isso pode ser facilmante alterado para *ddl-auto=update*.

## Design

As classes foram separados, ao máximo, por especialidades, e injetadas nas interfaces de seus dependentes através do mecanismo de DI do Spring.
Algumas classes terminaram por fazer tarefas além da sua especialização, como por exemplo a classe de transações, que busca o diretório onde o arquivo de relatório deve ser salvo. Isso foi necessário para manter a classe de escrita em arquivo como estática (sem precisar injetar o Spring Environment). O ideal seria um serviço para inicializar estas propriedades que estão em application.properties.

Para a geração de preços, optou-se por gerar um serviço que apenas capta e retorna uma lista de preços (neste caso, gera-os aleatoriamente). Isso torna mais fácil a substituição por outro serviço que implementa outro mecanismo de preços.
Os límites mínimos e máximos de preço de ações são lidos do application.properties (stockmonitor.minprice e stockmonitor.minprice).

Assim como o número de transações para gerar um relatório (stockmonitor.report.threshold) e o caminho para gerar o arquivo do relatório (stockmonitor.reportfile). Abaixo encontra-se uma nota de melhoria para esse item.

## melhorias necessárias

- refatoração do serviço de transações. Esse serviço deveria ser apenas proxy para o repositório JPA (e assim tornar-se apto a ser mockado). Refatorar a lógica de transações para uma classe de negócio e criar um novo package para essas classes de BO.

- serviço de notificação por email.
- testes unitários com mocks do serviço de geração de preços randômicos.
Basicamente é o único serviço com possibilidade de teste unitário, como explicado abaixo.

-teste de integração
Não é possível fazer mock dos repositórios JPA. De acordo com um membro do time do Spring Framework:
o make it short - there's no way to unit test Spring Data JPA repositories reasonably for a simple reason: it's way to cumbersome to mock all the parts of the JPA API we invoke to bootstrap the repositories. Unit tests don't make too much sense here anyway, as you're usually not writing any implementation code yourself so that integration testing is the most reasonable approach.

Testes de integração são indicados.

**_nota_**: já há alguns serviços intermediários entre os componentes de negócio e os repositórios. Para criar testes unitários, seria preciso terminar esses serviços, expondo judiciosamente os métodos necessários da interface dos repositórios, assim é possível fazer mock desses serviços ao invés dos repositórios.

- criação de uma camada de negócio (BOs), contendo as implementações específicas para as operações de venda e compra, e uma interface (Tradable, por ex) para estipular o contrato entre essas classes e o serviço de transação.
- Manter a geração de relatório a cada passagem pelo limite definido em stockmonitor.report.threshold, e não apenas na primeira passagem.
