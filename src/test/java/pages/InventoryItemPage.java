package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage extends BasePage {
    // Mapeamento
    @FindBy(css = "inventory_details_name large_size")
    WebElement lblTituloProduto;

    @FindBy(css = "dic.inventory_details_price")
    WebElement lblPrecoProduto;


    // Construtor
    public InventoryItemPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Funções e Metódos
    public String lerTituloDoProduto() {
        return lblTituloProduto.getText();
    }

    public String lerPrecoDoProduto() {
        return lblPrecoProduto.getText();
    }

}