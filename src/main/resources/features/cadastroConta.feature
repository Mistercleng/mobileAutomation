#language: pt
@TestSetId:01
Funcionalidade: Registro de cliente
  Como cliente
  Eu gostaria de me cadastrar
  Não sou cliente Stone Mais

  Contexto:
    Dado que o usuario acessa o aplicativo
    E escolher a opcão criar nova conta
    E deverá mostrar pergunta Você já é cliente Stone Mais?

  @TestCaseID:01
  Cenário: Acessar area de cadastro não cliente Stone Mais
    Quando selecionar não sou cliente
    Entao deverá exibir tela de tipo de conta

  @skip @TestCaseID:02
  Cenário:  Acessar area de cliente Stone Mais
    Quando selecionar sou cliente
    Entao deverá exibir tela login

  @skip @TestCaseID:03
  Cenário: Acessar area de cadastro não cliente Stone para Pessoa Fisica
    Quando selecionar não sou cliente
    E escolher a tipo de conta pessoa fisica
    Então deverá exibir a tela de termos de utilizacao de dados