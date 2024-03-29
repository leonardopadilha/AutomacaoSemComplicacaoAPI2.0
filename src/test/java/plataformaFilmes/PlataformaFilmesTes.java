package plataformaFilmes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import maps.LoginMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.RestUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PlataformaFilmesTes {

    @Test
    public void validarLogin() {
        RestUtils.setBaseUri("http://localhost:8080");

        String jsonBody = "{" +
                "\"email\": \"aluno@email.com\"," +
                "\"senha\": \"123456\"" +
                "}";

        Response response = RestUtils.post(jsonBody, ContentType.JSON, "/auth");

        LoginMap.token = response.body().jsonPath().get("token");
        assertEquals(200, response.statusCode());
        assertNotNull(LoginMap.token);
    }

    @BeforeAll
    public static void validarLoginMap() {
        RestUtils.setBaseUri("http://localhost:8080");
        LoginMap.initLogin();

        Response response = RestUtils.post(LoginMap.getLogin(), ContentType.JSON, "/auth");

        LoginMap.token = response.body().jsonPath().get("token");
        assertEquals(200, response.statusCode());
        assertNotNull(LoginMap.token);
    }

    @Test
    public void validarConsultaCategoria() {
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "Bearer " + LoginMap.token);

       Response response = RestUtils.get(header, "/categorias");
       assertEquals(200, response.statusCode());

        System.out.println(response.jsonPath().get().toString());

        assertEquals("Terror", response.jsonPath().get("tipo[2]"));

        List<String> listTipo = response.jsonPath().get("tipo");
        assertTrue(listTipo.contains("Terror"));
    }
}
