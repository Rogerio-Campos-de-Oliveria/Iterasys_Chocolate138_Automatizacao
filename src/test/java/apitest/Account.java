//1 - Pacote
package apitest;
// 2 - Bibliotecas

import com.google.gson.Gson;
import entities.AccountEntity;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

// 3 - Classes
public class Account {
    // 3.1 - Atributos
    String userId;


    // 3.1.2 - Instanciar Classes Externas

    Gson gson = new Gson(); // Intancia o objeto de conversão classe para json

    // Dados do Usuário


    // 3.2 - Métodos e Funções


    // Método #1 - Criar Usuário
    @Test
    public void testCreateUser(){
        // Arrange - Configura
        AccountEntity account = new AccountEntity(); // Instancia a entidade usuario
        account.userName = "charlie2015"; // entrada e saida (resultado esperado)
        account.password = "P@ss0rd1"; // entrada


        String jsonBody = gson.toJson(account); // Converte a entidade usuario no formato json

        // Tradicional
        //String userName = "charlie"; // usuário
        //String password = "123456"; // senha


        // Act - Executa

        // Dado - Quando - Então
        // Given - When - Then
         Response resposta = (Response) given()     // dado
                .contentType("application/json")    // tipo de conteudo
                .log().all()                        // registre tudo
                .body(jsonBody)                     // corpo da mensagem que será enviada

        .when() // quando
                .post("https://bookstore.toolsqa.com/Account/v1/User") // endereço da API que vai os endereços




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

}
