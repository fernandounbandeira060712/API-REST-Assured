package services;

import io.restassured.response.ValidatableResponse;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class Services {
    public static ValidatableResponse getSemAutenticacao(String endPoint) {
        return when()
                .get(endPoint)
                .then();
    }

    public static ValidatableResponse deleteSemAutenticacao(String endPoint) {
        return when()
                .delete(endPoint)
                .then();
    }

    public static ValidatableResponse postComLoginNoBody(String endPoint, Map<String, Object> body) {
        return given()
                .body(body)
                .when()
                .post(endPoint)
                .then();
    }

    public static ValidatableResponse putComLoginNoBody(String endPoint, Map<String, Object> body) {
        return given()
                .body(body)
                .when()
                .put(endPoint)
                .then();
    }

    public static ValidatableResponse patchComLoginNoBody(String endPoint, Map<String, Object> body) {
        return given()
                .body(body)
                .when()
                .patch(endPoint)
                .then();


    }

}
