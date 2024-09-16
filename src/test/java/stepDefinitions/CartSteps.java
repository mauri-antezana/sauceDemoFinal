package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.CartPage;

public class CartSteps {
    CartPage cartPage = new CartPage(DriverManager.getDriver().driver);

    @And("I click on the checkout button")
    public void clickCheckoutButton(){cartPage.clickOnCheckoutButton();}

    @Then("I should see the product {string} in the cart")
    public void verifyProductInCart(String product){
        String actualProduct = cartPage.getProduct();
        Assertions.assertEquals(product,actualProduct);
    }

    @And("I remove the product {string} from cart")
    public void removeProductFromCart(String product){cartPage.removeProduct(product);}
}
