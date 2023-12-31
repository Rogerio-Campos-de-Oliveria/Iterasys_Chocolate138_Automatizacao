package apiPetStore;

import com.google.gson.Gson;
import entities.UserEntity;
import jdk.jfr.Percentage;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class User {
    // Atributos
    String jsonBody;

    String ct = "application/json";

    String uri  = "https://petstore.swagger.io/v2/";

    Gson gson = new Gson(); // Intancia o objeto de conversão classe para json

    @Test
    public void testCreateUser(){
        // Configura
        
        
        // Dados de Entrada
        UserEntity user = new UserEntity();
        user.id = 999;
        user. username = "charlie";
        user. firstName = "charlie";
        user. lastName = "brown";
        user. email = "charlie@iterasys.com.br";
        user. password = "123456";
        user. phone = "11999999999";
        user.userStatus = 0;

        jsonBody = gson.toJson(user);

        // Dados de Saída / Resultado Esperado
        int code = 200;
        String type = "unknown";
        String message = "999";


        // Executa
        // Dado - Quando - Então
        // Given - When - Then
        given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)

        .when()
                .post(uri + "user")


        // Valida

        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(code))
                .body("type",is(type))
                .body("message",is(message))
                ;
        
    }

        @Test
    public void testCreatePet(){
        // Configura


        // Dados de Entrada
        UserEntity user = new UserEntity();
        user.idPet = 99;
        user.namePet = "Big";
        user.statusPet = "doacao";



        jsonBody = gson.toJson(user);

        // Dados de Saída / Resultado Esperado
        int code = 200;

        // Executa
        // Dado - Quando - Então
        // Given - When - Then
        given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)

                .when()
                .post(uri + "pet")


                // Valida

                .then()
                .log().all()
                .statusCode(200)
                .body("code", is(code))

        ;



    }
}
