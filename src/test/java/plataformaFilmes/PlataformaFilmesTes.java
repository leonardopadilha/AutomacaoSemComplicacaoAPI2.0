package plataformaFilmes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.RestUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PlataformaFilmesTes {

    static String token;

    @Test
    public void validarLogin() {
        RestUtils.setBaseUri("http://localhost:8080");

        String jsonBody = "{" +
                "\"email\": \"aluno@email.com\"," +
                "\"senha\": \"123456\"" +
                "}";

        Response response = RestUtils.post(ContentType.JSON, jsonBody, "/auth");

        token = response.body().jsonPath().get("token");
        assertEquals(200, response.statusCode());
        assertNotNull(token);
    }

    @BeforeAll
    public static void validarLoginMap() {
        RestUtils.setBaseUri("http://localhost:8080");

        Map<String, String> map = new HashMap<>();
        map.put("email", "aluno@email.com");
        map.put("senha", "123456");

        Response response = RestUtils.post(ContentType.JSON, map, "/auth");

        token = response.body().jsonPath().get("token");
        assertEquals(200, response.statusCode());
        assertNotNull(token);
    }

    @Test
    public void validarConsultaCategoria() {
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "Bearer " + token);

       Response response = RestUtils.get(header, "/categorias");
       assertEquals(200, response.statusCode());

        System.out.println(response.jsonPath().get().toString());

        assertEquals("Terror", response.jsonPath().get("tipo[2]"));

        List<String> listTipo = response.jsonPath().get("tipo");
        assertTrue(listTipo.contains("Terror"));
    }
}
