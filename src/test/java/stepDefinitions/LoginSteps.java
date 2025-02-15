package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);

    @Given("I set the user name text box with {string}")
    public void setUserName(String userName){
        loginPage.setUserNameTextBox(userName);
    }
    @And("I set the password text box with {string}")
    public void setPassword(String password){
        loginPage.setPasswordTextBox(password);
    }

    @When("I click on the login button")
    public void clickOnLogin(){
        loginPage.clickOnLoginButton();
    }

    @And("A error message that says {string} should be displayed")
    public void verifyErrorMessage(String message){
        Assertions.assertTrue(loginPage.getErrorMessage(message));
    }
}
