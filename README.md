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

![metrics](https://user-images.githubusercontent.com/7126514/96517087-a7f42600-123e-11eb-8dc6-0087dc74f5b0.png)

## LOG
Escolhi utilizar uma ferramenta de log centralizado chamada rollbar (porque ela é gratuita), como para o contexto da aplicação não vi sentido _logar_ o _payload_, realizei logs apenas de erros internos da aplicação.

![log_centralizado](https://user-images.githubusercontent.com/7126514/96518036-5cdb1280-1240-11eb-9bc5-b0b7ef759167.png)

## Qualidade de Código
Para verificar a qualidade do código que estou produzindo utilizo o sonar, aqui está algumas metricas dessa aplicação

![qualidade](https://user-images.githubusercontent.com/7126514/96524142-d4636e80-124d-11eb-8528-a25c5d217cfe.png)

Obs.: Não sei porque o sonarqube está apresentando 97.4% (rodando o coverage do IntelliJ está com 100%)

## Preferencias das tecnologias  
Optei por trabalhar com java, pois é uma linguagem que domino e o framework do Spring facilita a vida do desenvolvedor em varias tarefas complexas, como APIs de metricas, entre outras. Escolhi adicionar um pouco de Kotlin também pois ela tem um contexto de linguagem menos verboso e colabora com o Clean Architecture, pois não temos a necessidade de criar uma grande quantidade de _gets_, e também não precisamos utilizar dependências externas dentro do nucleo da aplicação, assim ganhamos a agilidade que temos com o lombok, dentro da propria JVM, sem quebrar alguns conceitos de qualidade de arquitetura.

# Atividade 2
#### Quando você digita a URL de um site (http://www.netshoes.com.br) no browser e pressiona enter, explique da forma que preferir, o que ocorre nesse processo do protocolo HTTP entre o Client e o Server?

