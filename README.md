# Desafio Conversor de Moedas

O Primeiro desafio do programa Oracle Next Education(ONE) consiste em criar um conversor de moedas utilizando [Exchangerate-API](https://www.exchangerate-api.com).

## Dependências

Para lidar com os arquivos json, foi é utilizada a biblioteca [Gson 2.11.0](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.11.0)

## Virtual Machine Options

Para lidar com números float foi adicionada a configuração de VM: *-Duser.language=en -Duser.country=US*

## Utilização

A interface é simples, onde o usuário deve escolher o tipo de retorno:
- 1: Informa a taxa de câmbio entre algumas moedas pré selecionadas.
- 2: Converte um valor informado entre as moedas pré selecionadas.