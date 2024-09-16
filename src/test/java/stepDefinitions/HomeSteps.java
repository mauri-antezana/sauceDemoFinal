package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.And;
import org.junit.jupiter.api.Assertions;
import pages.HomePage;
import io.cucumber.java.en.Then;


public class HomeSteps {
    HomePage homePage = new HomePage(DriverManager.getDriver().driver);

    @Then ("The home page should be displayed")
    public void verifyHomePageIsDisplayed(){
        Assertions.assertTrue(homePage.sauceDemoTitleIsDisplayed());
    }

    @Then ("The order of the products name has to be as the selection {string}")
    public void verifyNameOrder(String orderType){Assertions.assertTrue(homePage.verifyNameOrder(orderType));}

    @Then ("The order of the products price has to be as the selection {string}")
    public void verifyPriceOrder(String orderType){Assertions.assertTrue(homePage.verifyPriceOrder(orderType));}

    @And("I click the cart icon")
    public void clickCartIcon(){homePage.clickCartIcon();}

    @And("I add the product {string} to the cart")
    public void addProductToCart(String productName) throws InterruptedException {
        homePage.addProductToCart(productName);
    }

    @And("I add all the products to the cart")
    public void addAllProductsToCart(){ homePage.addAllProductsToCart();}
}
