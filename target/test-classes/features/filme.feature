#language:pt

  @filme
  Funcionalidade: CRUD Filme

    @cadastroFilme
    Cenario: Cadastro Filme
      Dado que tenha realizado o login com dados validos
      E que tenha um payload da API de Filme
      Quando realizo uma requisicao do tipo POST de Filme
      Entao valido que recebo status 201 no response
      E valido que no campo "categorias[0].tipo[1]" possui o valor "Comédia"
      E armazeno o id do response de Filme

    Cenario: Consulta Filme
      Dado que tenha realizado o login com dados validos
      E que tenha um payload da API de Filme
      Quando realizo uma requisicao do tipo GET de Filme atraves do nome
      Entao valido que recebo status 200 no response
      E valido que no campo "categorias[0].tipo[1]" possui o valor "Comédia"