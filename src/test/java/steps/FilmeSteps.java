package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;
import maps.FilmesMap;
import utils.RestUtils;

public class FilmeSteps {

    @Dado("que tenha um payload da API de Filme")
    public void queTenhaUmPayloadDaAPIDeFilme() {
        FilmesMap.initAll();
    }
    @Quando("realizo uma requisicao do tipo POST de Filme")
    public void realizoUmaRequisicaoDoTipoPOSTDeFilme() {
        RestUtils.post(FilmesMap.getHeader(), FilmesMap.getFilme(), ContentType.JSON, "filmes");
    }
    @Entao("armazeno o id do response de Filme")
    public void armazenoOIdDoResponseDeFilme() {
        FilmesMap.id = RestUtils.getResponse().jsonPath().get("id");
    }

    @Quando("realizo uma requisicao do tipo GET de Filme atraves do nome")
    public void realizoUmaRequisicaoDoTipoGETDeFilmeAtravesDoNome() {
    }
}
