package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

public class RestUtils {

    private static Response response;

    public static Response getResponse() {
        return response;
    }

    public static void setBaseUri(String uri) {
        RestAssured.baseURI = uri;
    }

    public static String getBaseUri() {
        return RestAssured.baseURI;
    }



    public static Response get(Map<String, String> header, String endpoint) {
        return response = RestAssured
                                .given()
                                .relaxedHTTPSValidation()
                                .headers(header)
                                .when()
                                .get(endpoint)
                                .thenReturn();
                    }

    public static Response post(Object jsonBody, ContentType contentType, String endpoint) {
        return response = RestAssured
                                .given()
                                .relaxedHTTPSValidation()
                                .contentType(contentType)
                                .body(jsonBody)
                                .when()
                                .post(endpoint)
                                .thenReturn();
    }
}
