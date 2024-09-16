package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.CheckoutInformationPage;

import java.util.List;

public class CheckoutInformationSteps {
    CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(DriverManager.getDriver().driver);

    @And("I click the continue button in the information page")
    public void clickContinueButton() {checkoutInformationPage.clickContinueButton();}

    @And("I fill the information for the checkout with")
    public void fillCheckoutInformation(DataTable checkoutInformation) {
        List<String> data = checkoutInformation.transpose().asList(String.class);

        checkoutInformationPage.setFirstNameTextBox(data.get(0));
        checkoutInformationPage.setLastNameTextBox(data.get(1));
        checkoutInformationPage.setZipCodeTextBox(data.get(2));
    }

    @Then("An error message for incomplete fields should appear")
    public void errorMessageForIncompleteFields() {
        Assertions.assertTrue(checkoutInformationPage.verifyErrorMessage());
    }
}
