package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.HomePage;

public class CommonSteps {
    HomePage homepage = new HomePage(DriverManager.getDriver().driver);

    @Given("I am in sauce demo web page")
    public void goToSauceDemoWebPage() {
        DriverManager.getDriver().driver.get("https://www.saucedemo.com/");
    }

    @And("I close the page")
    public void closePage(){
        DriverManager.getDriver().driver.close();
    }

    @And("I reset the page state")
    public void resetPageState(){
        homepage.resetAppState();
    }
}
