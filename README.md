# Cliente-API (v1.0)

## Resumo

Aplicação feita para Cadastrar clientes,  permitindo que seu endereço seja consultado através de um FeingClient. A presistência dos dados é realizada por meio do o banco relacional H2.

## Descrição da implementação

A API foi desenvolvida em java 11 e possui um endpoint:
 - http://localhost:8080/api/v1/clientes


Desenvolvi um tratamento de erros personalizado através de annotation @ControlerAdvice, permitindo melhor compreensão dos erros mostrados na tela do usuário.

Para acessar a documentação swagger da aplicação basta utilizar a seguinte url:

 - http://localhost:8080/swagger-cliente-emprestimo-api.html
