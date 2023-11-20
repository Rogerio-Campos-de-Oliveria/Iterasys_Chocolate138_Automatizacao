//1 - Pacote
package apitest;
// 2 - Bibliotecas

import com.google.gson.Gson;
import entities.AccountEntity;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

// 3 - Classes
public class Account {
    // 3.1 - Atributos
    String userId;
    String ct = "application/json"; // contentType de API

    String jsonBody; // guardar o json que será enviado

    String uri = "https://bookstore.toolsqa.com/Account/v1/"; // endereço base

    Response resposta; // guardar o retorno da API

    String token; // guardar o token - autenticação do usuário

    // 3.1.2 - Instanciar Classes Externas

    Gson gson = new Gson(); // Intancia o objeto de conversão classe para json

    // Dados do Usuário


    // 3.2 - Métodos e Funções


    // Método #1 - Criar Usuário
    @Test(priority = 1)
    public void testCreateUser(){
        // Arrange - Configura
        AccountEntity account = new AccountEntity(); // Instancia a entidade usuario
        account.userName = "charlie2087"; // entrada e saida (resultado esperado)
        account.password = "P@ss0rd1"; // entrada


        jsonBody = gson.toJson(account); // Converte a entidade usuario no formato json

        // Tradicional
        //String userName = "charlie"; // usuário
        //String password = "123456"; // senha


        // Act - Executa

        // Dado - Quando - Então
        // Given - When - Then
         resposta = (Response) given()     // dado
                .contentType(ct)    // tipo de conteudo
                .log().all()                        // registre tudo
                .body(jsonBody)                     // corpo da mensagem que será enviada

        .when() // quando
                .post(uri + "User") // endereço da API que vai os endereços




        // Assert - Valida

        .then() // então
                .log().all()                                   // registre tudo na volta
                .statusCode(201)              // valida a comunicação
                .body("username", is(account.userName)) // valida o usuário
                .extract()
        ;// fim da linha do REST-assured

        // extrair o userId (identificação do usuário)

        userId = resposta.jsonPath().getString("userID");
        System.out.println("UserID extraido: " + userId);


    }// fim do método de criação de usuário


    @Test(priority = 2)
    public void testGenerateToken(){
        // Configura

        // Dados de Entradas são fornecidos pela AccountEntity

        // REsultado Esperado é que ele receba um Token

        // Executa
        resposta = (Response) given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)

        .when()
                .post(uri + "GenerateToken")

        .then()
                .log().all()
                .statusCode(200) // valida a comunicação
                .body("status", is("Success")) // Status = Sucesso
                .body("result", is("User authorized successfully."))

        .extract()



        ;// fim do método da geração do Token

        // Extração do Token

        token = resposta.jsonPath().getString("token");
        System.out.println("token: " + token);

        // Valida

        Assert.assertTrue(token.length() != 0);

    } // fim do método de geração de token de identificação do usuário

}
