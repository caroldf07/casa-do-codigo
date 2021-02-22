<h1>Desafio 01 - Casa do Código</h1> 

<p align="center">
  <img src="https://img.shields.io/static/v1?label=spring&message=framework&color=GREEN&style=for-the-badge&logo=SPRING"/> <img src="http://img.shields.io/static/v1?label=License&message=MIT&color=orange&style=for-the-badge"/> <img src="http://img.shields.io/static/v1?label=STATUS&message=CONCLUIDO&color=GREEN&style=for-the-badge"/>
</p>

> Status do Projeto: :heavy_check_mark: (concluido)

### Tópicos 

:small_orange_diamond: [Descrição do projeto](#descrição-do-projeto)

:small_orange_diamond: [Funcionalidades](#funcionalidades)

:small_orange_diamond: [Casos de Uso](#casos-de-uso)

:small_orange_diamond: [Linguagens, dependencias e libs utilizadas](#linguagens-dependencias-e-libs-utilizadas)


## Descrição do desafio 

<p align="justify">
  Neste desafio você precisa desenvolver uma api para suportar parte do funcionamento da casa do código. Temos várias funcionalidades de dificuldade progressiva e com uma regra de negócio que eu imagino que seja de um entendimento mais direto.
</p>

## Funcionalidades

:heavy_check_mark: Funcionalidade : Cadastro de novo Autor  

:heavy_check_mark: Funcionalidade 2: Cadastro de nova Categoria 

:heavy_check_mark: Funcionalidade 3: Validator Genérico (UniqueValue para e-mail do autor e nome da categoria)

:heavy_check_mark: Funcionalidade 4: Cadastro de novo Livro

:heavy_check_mark: Funcionalidade 5: Listagem de todos os Livros apenas com id e nome

:heavy_check_mark: Funcionalidade 6: Página de detalhes de um Livro de acordo com o Id

:heavy_check_mark: Funcionalidade 7: Cadastro de País e Estado (com validação de País não ter Estado duplicado)

:heavy_check_mark: Funcionalidade 8: Início de fluxo de pagamento (com validação de País, Estado existirem e, caso o País tenha Estado cadastrado, ele ser obrigatório)


## Casos de Uso
![País possui Estados cadastrados, mas não foi indicado o Id do Estado](https://imgur.com/kdPqVQZ.gif "País possui Estados cadastrados, mas não foi indicado o Id do Estado")
País possui Estados cadastrados, mas não foi indicado o Id do Estado

![País não possui Estado pendente e foi cadastrado com sucesso](https://imgur.com/RzJEiqG.gif "País não possui Estado pendente e foi cadastrado com sucesso")
País não possui Estado pendente e foi cadastrado com sucesso

![Tentativa de cadastrar cliente com e-mail e documento duplicados](https://imgur.com/NGzeC1y.gif "Tentativa de cadastrar cliente com e-mail e documento duplicados")
Tentativa de cadastrar cliente com e-mail e documento duplicados

## Linguagens, dependencias e libs utilizadas :books:

- [Java](https://docs.oracle.com/en/java/javase/11/index.html)
- [Spring Framework](https://docs.spring.io/spring-framework/docs/current/reference/html/)
- [MariaDB](https://mariadb.org/)
- [Hibernate](https://hibernate.org/)

## Licença 

The [MIT License]() (MIT)

Copyright :copyright: 2021 - Desafio Casa do Código
