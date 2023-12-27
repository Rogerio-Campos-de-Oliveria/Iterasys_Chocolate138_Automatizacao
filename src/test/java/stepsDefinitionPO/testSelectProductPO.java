package stepsDefinitionPO;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class testSelectProductPO {
    // Atributos
    final WebDriver driver; // este é objeto final do Selenium (Uma única bola em campo)
    private CartPage cartPage;
    private HomePage homePage;
    private InventoryPage inventoryPage;
    private InventoryItemPage inventoryItemPage;


    // Construtor
    public testSelectProductPO(Base base){
        this.driver = base.driver; // passagem de bola = integração Selenium dentro e fora
    }

    @Given("I access SauceDemo store PO")
    public void i_access_sauce_demo_store() {
        driver.get("https://www.saucedemo.com");
        homePage = new HomePage(this.driver);
        inventoryPage = new InventoryPage(this.driver);
        inventoryItemPage = new InventoryItemPage(this.driver);
        cartPage = new CartPage(this.driver);
    }

    @When("I filled a user {string} and password {string} PO")
    public void i_filled_a_user_and_password(String user, String password) {
        homePage.logar(user, password);

    }

    @And("I click in Login PO")
    public void i_click_in_login() {
        homePage.clicarNoBotaoLogin();
        inventoryPage = new InventoryPage(this.driver);
    }
    // @Then("show page's title {string}")
    @Then("I verify the page's title {string} PO")
    public void show_page_s_title_po(String pageTitle) {
        // Verifica se o titulo da página coincide com o informado na feature
        assertEquals(inventoryPage.lerTituloDaPagina(), pageTitle);
    }
    @And("show cart's link PO")
    public void show_cart_s_link() {
        // Verifica se o elemento do carrinho de compras está visível
        assertTrue(inventoryPage.imgCarrinho.isDisplayed());
    }
    @When("I click in product {string} PO")
    public void i_click_in_product(String productId) {
        // Clica no elemento correspondente ao código do produto informado na feature
        inventoryPage.clicarNotituloDoProduto(productId);
    }
    @Then("I verify the product title {string} PO")
    public void i_verify_the_product_title(String productTitle) {
        // Verifica se o titulo do produto corresponde ao informado na feature
        assertEquals(inventoryItemPage.lerTituloDoProduto(), productTitle);
    }
    @And("I verify the product price {string} PO")
    public void i_verify_the_product_price(String productPrice) {
        // Verifica se o preço do produto corresponde ao informado na feature
        assertEquals(inventoryItemPage.lerPrecoDoProduto(), productPrice);
    }
    @And("I click in Add to Cart PO")
    public void i_click_in_add_to_cart() throws InterruptedException {
        // Clica no botão de adicionar no carrinho
        inventoryItemPage.clicarNoBotaoAdicionarOuRemoverNoCarrinho();

    }

    @And("I click in Cart icon PO")
    public void i_click_in_cart_icon() {
        // Clica no icone do carrinho de compras
        inventoryPage.clicarNoCarrinho();
    }

    @And("I verify the quantity is {string} PO")
    public void i_verify_the_quantity_is(String quantity) {
        // Verifica se a quantidade corresponde a feature
        assertEquals(cartPage.lerQuantidadeDoProdutoNoCarrinho(), quantity);
    }

    @Then("I verify the product title {string} in cart PO")
    public void i_verify_the_product_title_in_cart(String productTitle) throws InterruptedException {


        for (int i = 1; i < cartPage.contarProdutosNoCarrinho(); i++) {
            cartPage.clicarNoBotaoRemoverNoCarrinho();
        }

        assertEquals(cartPage.lerTituloProdutoNoCariinho(), productTitle);
        Thread.sleep(2000);
    }

    @Then("I verify the product price {string} in cart PO")
    public void i_verify_the_product_price_in_cart(String productPrice) {
        assertEquals(cartPage. lerPrecoProdutoNoCarrinho(), productPrice);
    }


}