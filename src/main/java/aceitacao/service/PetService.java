package aceitacao.service;

import aceitacao.dto.UserResponseDTO;
import io.restassured.http.ContentType;
import aceitacao.dto.PetPayloadDTO;

import static io.restassured.RestAssured.given;


public class PetService {

    //Definir interface
    String baseUrl = "https://petstore.swagger.io/v2/pet";

    public PetPayloadDTO adicionarPet(String jsonBody) {

        //  REST-ASSURED
        PetPayloadDTO result = given() // Dado
                .contentType(ContentType.JSON)
                    .log().all()
                    .body(jsonBody)
        .when() // Quando
                     .post(baseUrl)
        .then() // Então
                    .log()
                    .all()
                .statusCode(200) // Extração do resultado
        .extract().as(PetPayloadDTO.class);
        return result;
    }

    public PetPayloadDTO editarPet(String jsonBody) {
       PetPayloadDTO result = given()
               .contentType(ContentType.JSON)
               .log().all()
               .body(jsonBody)
               .when().put(baseUrl)
               .then()
               .log()
               .all()
               .statusCode(200)
               .extract().as(PetPayloadDTO.class);
       return result;
    }

    public PetPayloadDTO getPet(Integer idPet) {

        String getUrl = baseUrl + "/" + idPet;

        PetPayloadDTO result = given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(getUrl)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().as(PetPayloadDTO.class);
        return result;
    }

    public UserResponseDTO deletePet(Integer idPet) {

        String getUrl = baseUrl + "/" + idPet;

        return given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .delete(getUrl)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().as(UserResponseDTO.class);
    }
}
