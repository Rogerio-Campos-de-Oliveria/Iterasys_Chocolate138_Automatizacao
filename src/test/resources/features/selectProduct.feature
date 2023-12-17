##language: pt
#  Funcionalidade: Selecionar Produto na Loja
#    Cenario: Selecionar Produto com Sucesso
#      Dado que acesso a loja SauceDemo
#      Quando preencho o usuario e senha
#      E clica em login
#      Entao exibe o titulo da pagina como "Products"
#      E exibe o link dio carrinho de compras
#      Quando clica no produto "Sauce Labs Backpack"


  Feature: Select Product in Store
    Scenario: Selecting product with Sucess
      Given I access SauceDemo Store
      When I filled a user "stander_user" and password "secret_sauce"
      And click in Login
      Then show page's title "Products"
      And show cart's link
      When I click in product "4"
      Then I verify the product title "Sauce Labs Backpack"
      And I verify the product price "$ 29.99"
      When I click in Add to Cart
      And I click in Cart icon
      Then I verify then page's title "Your Cart"
      And I verify the product title "Sauce Labs Backpack"
      And I verify the quantity is "1"
      And I verify the product price "$ 29.99"

