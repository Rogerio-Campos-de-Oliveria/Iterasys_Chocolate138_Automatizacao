//1 - Pacote
package apitest;
// 2 - Bibliotecas

import com.google.gson.Gson;
import entities.AccountEntity;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

// 3 - Classes
public class TestAccount {
    // 3.1 - Atributos
    String userId;
    String ct = "application/json"; // contentType de API

    String jsonBody; // guardar o json que será enviado

    String uri = "https://bookstore.toolsqa.com/Account/v1/"; // endereço base

    Response resposta; // guardar o retorno da API

    static String token; // guardar o token - autenticação do usuário

    // 3.1.2 - Instanciar Classes Externas

    Gson gson = new Gson(); // Intancia o objeto de conversão classe para json

    AccountEntity account = new AccountEntity(); // Instancia a entidade usuario

    // Dados do Usuário


    // 3.2 - Métodos e Funções


    // Método #1 - Criar Usuário
    @Test(priority = 1)
    public void testCreateUser(){
        // Arrange - Configura

        account.userName = "charlie2026"; // entrada e saida (resultado esperado)
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
    public void testGenerateToken(ITestContext context){ // Declarar a Interface de Contexto
        // Configura

        // Dados de Entradas são fornecidos pela AccountEntity

        // Resultado Esperado é que ele receba um Token

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
        context.setAttribute("token", token);
        System.out.println("token: " + token);

        // Valida

        Assert.assertTrue(token.length() != 0);

    } // fim do método de geração de token de identificação do usuário

    @Test(priority = 3)
    public void testAuthorized() {
        // Configura
        // Dados entrada
        // --> Forncedidos pelo AccountEntity através do método testCreatUser - priority = 1

        // Dados Saída / Resultados Esperadp
        // StatusCode = 200
        //  Response Body = true

        // Executa
        given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)

        .when()
                .post(uri + "Authorized")


        // Valida
        .then()
                .log().all()
                .statusCode(200)

        ;

    }

    @Test(priority = 4)
    public void testResearchUserNotAuthorized () {
        // Configura
        // Dados de Entrada
        // userID foi etraido no método testCreatedUser e está na memória

        // Dados de Seída / Resulado Esperado
        // Status Code = 401, Code = 1200 e  Message = User not authorized!

        // Executa
        given()                                                             // Dado // Comandos do REST-assured
                .contentType(ct)                                            // Formato da Mensagem
                .log().all()                                                // Exibir tudo que acontece na ida

        .when()                                                             // Quando
                .get(uri + "User/" + userId)                           // Consulta o usuário pelo userId


        // Valida
        .then()                                                             // Então
                .log().all()                                                // Exibir tudo que acontece na volta
                .statusCode(401)                           // Valida se a conexão teve sucesso
                .body("code", is("1200"))                        // Valida o código de mensagem "não autorizado"
                .body("message", is("User not authorized!"))     // Valida o nome do usuário

        ;                                                                   // Conclui o bloco do REST-assured

    }

    @Test(priority = 5)
    public void testResearchUser () {
        // Configura
        // Dados de Entradas
        // userID foi etraido no método testCreatedUser e está na memória

        // Dados de Seída / Resulado Esperado
        // userName virá da classe TestAccount e o Status Code deve ser 200


        // Executa
        given()                                                 // Dado // Comandos do REST-assured
                .contentType(ct)                                // Formato da Mensagem
                .log().all()                                    // Exibir tudo que acontece na ida
                .header("Authorization", "Bearer " + token)

        .when()                                                 // Quando
                .get(uri + "User/" + userId)               // Consulta o usuário pelo userId


        // Valida
        .then()                                                 // Então
                .log().all()                                    // Exibir tudo que acontece na volta
                .statusCode(200)               // Valida se a conexão teve sucesso
                .body("username", is(account.userName))   // Validar o nome do usuário
                .body("userId", is(userId))               // Validar 0 ID do usuário

        ;                                                       // Conclui o bloco do REST-assured

    }

    @Test(priority = 6)
    public void testDeletUserUnauthorized(){
        // Configura
        // Dados de entrada vem do método de teste da criação ddo usuáio (userId)
        // Resultado esperado é o código e mensagem de sucesso na exclusão do usuário

        // Executa
        given()
                .log().all()
                .contentType(ct)
                .header("Authorization", "Bearer " + token)

        .when()
                .delete(uri + "User/" + userId)


        // Valida
        .then()
                .log().all()
                .statusCode(204)

        ;

    }


}
