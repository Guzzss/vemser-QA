package aceitacao.service;

import aceitacao.dto.UserDTO;
import aceitacao.dto.UserResponseDTO;
import io.restassured.http.ContentType;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserService {

    String baseUrl = "https://petstore.swagger.io/v2/user";

    public UserResponseDTO adicionarUser(String jsonBody) {

        //  REST-ASSURED
        UserResponseDTO result = given() // Dado
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when() // Quando
                .post(baseUrl)
                .then() // Então
                .log()
                .all()
                .statusCode(200) // Extração do resultado
                .extract().as(UserResponseDTO.class);
        return result;
    }

    public UserResponseDTO createWithList(String jsonBody) {
        String getUrl = baseUrl + "/createWithList";
        //  REST-ASSURED
        UserResponseDTO result = given() // Dado
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when() // Quando
                .post(getUrl)
                .then() // Então
                .log().all()
                .statusCode(200) // Extração do resultado
                .extract().as(UserResponseDTO.class);
        return result;
    }

    public UserResponseDTO createWithArray(String jsonBody) {
        String getUrl = baseUrl + "/createWithArray";
        //  REST-ASSURED
        UserResponseDTO result = given() // Dado
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when() // Quando
                .post(getUrl)
                .then() // Então
                .log().all()
                .statusCode(200) // Extração do resultado
                .extract().as(UserResponseDTO.class);
        return result;
    }

    public UserResponseDTO logoutUser() {
        String getUrl = baseUrl + "/logout";

        //  REST-ASSURED
        UserResponseDTO result = given() // Dado
                .contentType(ContentType.JSON)
                .log().all()
                .when() // Quando
                .get(getUrl)
                .then() // Então
                .log()
                .all()
                .statusCode(200) // Extração do resultado
                .extract().as(UserResponseDTO.class);
        return result;
    }

    public UserDTO getUser(String username, String jsonBody) {
        String getUrl = baseUrl + "/" + username;

        //  REST-ASSURED
        UserDTO result = given() // Dado
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when() // Quando
                .get(getUrl)
                .then() // Então
                .log()
                .all()
                .statusCode(200) // Extração do resultado
                .extract().as(UserDTO.class);
        return result;
    }

    public UserResponseDTO loginUser(String username, String password) {
        String getUrl = baseUrl + "/login?username=" + username + "&password=" + password;

        //  REST-ASSURED
        UserResponseDTO result = given() // Dado
                .contentType(ContentType.JSON)
                .log().all()
                .when() // Quando
                .get(getUrl)
                .then() // Então
                .log()
                .all()
                .statusCode(200) // Extração do resultado
                .extract().as(UserResponseDTO.class);
        return result;
    }

    public UserResponseDTO deleteUser(String username) {
        String getUrl = baseUrl + "/" + username;

        //  REST-ASSURED
        UserResponseDTO result = given() // Dado
                .contentType(ContentType.JSON)
                .log().all()
                .when() // Quando
                .delete(getUrl)
                .then() // Então
                .log()
                .all()
                .statusCode(200) // Extração do resultado
                .extract().as(UserResponseDTO.class);
        return result;
    }

    public UserResponseDTO putUser(String username, String jsonBody) {
        String getUrl = baseUrl + "/" + username;

        //  REST-ASSURED
        UserResponseDTO  result = given() // Dado
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when() // Quando
                .put(getUrl)
                .then() // Então
                .log()
                .all()
                .statusCode(200) // Extração do resultado
                .extract().as(UserResponseDTO.class);
        return result;
    }

}
