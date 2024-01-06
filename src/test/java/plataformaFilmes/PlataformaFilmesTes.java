package plataformaFilmes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PlataformaFilmesTes {

    String token;

    @Test
    public void validarLogin() {
        RestAssured.baseURI = "http://localhost:8080";

        String jsonBody = "{" +
                "\"email\": \"aluno@email.com\"," +
                "\"senha\": \"123456\"" +
                "}";

        Response response = post(ContentType.JSON, jsonBody, "/auth");

        token = response.body().jsonPath().get("token");
        assertEquals(200, response.statusCode());
        assertNotNull(token);
    }

    @BeforeAll
    public void validarLoginMap() {
        RestAssured.baseURI = "http://localhost:8080";

        Map<String, String> map = new HashMap<>();
        map.put("email", "aluno@email.com");
        map.put("senha", "123456");

        Response response = post(ContentType.JSON, map, "/auth");

        token = response.body().jsonPath().get("token");
        assertEquals(200, response.statusCode());
        assertNotNull(token);
    }

    public Response post(ContentType contentType, Object jsonBody, String endpoint) {
        return RestAssured
                    .given()
                        .relaxedHTTPSValidation()
                        .contentType(contentType)
                        .body(jsonBody)
                    .when()
                        .post(endpoint)
                    .thenReturn();
    }
}
