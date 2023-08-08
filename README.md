# Aplicação CRUD usando API REST e banco de dados em memória

A aplicação consiste em realizar login de usuario, inserir, atualizar, acessar e apagar dados em um banco de dados em memória (H2) usando autenticacao JWT com endpoints com API REST e Spring Boot.


### Dependencias:
* JDK 11;
* Maven 3.8.4

O arquivo data.sql é responsáveis por adicionar dados pré setados no banco H2 quando a aplicação é executada.

Já o arquivo schema.sql é responsável por criar a tabela no banco de dados em memória.

Além disso, ao executar a aplicação, pode-se inserir mais dados usando a Interface IPersonRepository

### End points Person:

#### 🚨 Os end points de Person necessitam realizar Login antes de fazer requisicoes

* ``` find-all-person ```

Busca por todos os usuarios cadastrados

* ``` find/{id} ```

Busca por um usuario cadastardo em especifico

* ``` save-person ```

Salva um usuario no banco de dados

* ``` update-person/{id} ```

Atualiza os dados de um usuario em especifico

* ``` delete/{id} ```

Deleta um usuario em especifico.

### End point Authenticator:

* ``` login ```


#### 🚨 Para fazer login, e necessario ter um usuario previamente cadastrado

