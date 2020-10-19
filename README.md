![magalu](https://user-images.githubusercontent.com/7126514/96477917-757e0500-120d-11eb-87f2-fac8390d8ccd.jpg)


# API Pesquisa CEP

## Como Excutar
Para executar o projeto basta _startar_ a classe MagaluApplication

![application_start](https://user-images.githubusercontent.com/7126514/96477507-f7b9f980-120c-11eb-8cd7-8d5cdaa700fb.png)

## Swagger
Caso tenha necessidade de saber os _endpoints_, _requests_ e _responses_ que a aplicação pode retornar, acesse o swagger da aplicação em:

http://localhost:8090/swagger-ui.html

![swagger](https://user-images.githubusercontent.com/7126514/96514173-a6742f00-1239-11eb-9146-8761e38fc6bc.png)

Token de Autenticação: Bearer eyJhbGciOiJIUzUxMiJ9.eyJyb2xlIjpbIlJPTEVfVVNFUiJdLCJzdWIiOiJhZG1pbiIsImlhdCI6MTYwMzExOTM4MywiZXhwIjoxNjA0MTE5MzgzfQ.-WphXqOJPA-ngJtDD3_aM4sglE2YuCPQoUgcmIYJgW4m5aZQl97A4VvrEiTIlVMtqC2cQ2h6_c4SUQ8kO8PATA

## API Externa
Essa API realizar o consumo de CEP do serviço postmon
Documentação: https://postmon.com.br/

## Monitaramento
Para visualizar a saude da aplicação acesse o endpoint: http://localhost:8090/actuator/health

![health](https://user-images.githubusercontent.com/7126514/96516850-3b792700-123e-11eb-8467-0e0ed90908d5.png)

Para visualizar as metricas da aplicação acesse o endpoint: http://localhost:8090/actuator/metrics
