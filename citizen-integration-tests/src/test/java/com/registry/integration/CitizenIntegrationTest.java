
package com.registry.integration;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CitizenIntegrationTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    public void testCreateAndGetCitizen() {
        String jsonBody = "{\"at\":\"12345678\",\"firstName\":\"Anna\",\"lastName\":\"Nika\",\"gender\":\"Γυναίκα\",\"birthDate\":\"1995-05-10\"}";

        // Δημιουργία
        given()
            .contentType(ContentType.JSON)
            .body(jsonBody)
        .when()
            .post("/api/citizens")
        .then()
            .statusCode(200)
            .body("at", equalTo("12345678"));

        // Ανάκτηση
        given()
        .when()
            .get("/api/citizens/12345678")
        .then()
            .statusCode(200)
            .body("firstName", equalTo("Anna"))
            .body("lastName", equalTo("Nika"));
    }
}
