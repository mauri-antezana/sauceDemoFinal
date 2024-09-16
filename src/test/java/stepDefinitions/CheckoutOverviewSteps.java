package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.CheckoutOverviewPage;

public class CheckoutOverviewSteps {
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(DriverManager.getDriver().driver);

    @Then("Verify the tax is {double} of the total")
    public void verifyTax(double tax){
        Assertions.assertEquals(checkoutOverviewPage.getTax(),checkoutOverviewPage.calculateTax(tax));}

    @Then("Verify the total is equal to the products price summation")
    public void verifySubtotal(){
        Assertions.assertEquals(checkoutOverviewPage.getSubtotal(),checkoutOverviewPage.calculateSubtotal());
    }
}
