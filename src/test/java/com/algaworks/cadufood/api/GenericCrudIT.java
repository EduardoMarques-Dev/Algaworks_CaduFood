package com.algaworks.cadufood.api;

import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import io.restassured.RestAssured;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GenericCrudIT {

    @LocalServerPort
    private int port;

    @Test
    public void deveRetornarStatus200_QuandoConsultarCozinhas() {
        // EXIBE O REQUEST E RESPONSE, CASO FALHE A REQUISIÇÃO
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        RestAssured.given()
                .basePath("/cozinhas")
                .port(port)
                .accept(ContentType.JSON)
            .when()
                .get()
            .then()
                .body("", Matchers.hasSize(2))
                .body("nome", Matchers.hasItems("Indiana","Tailandesa"))
                .statusCode(200);
    }

}
