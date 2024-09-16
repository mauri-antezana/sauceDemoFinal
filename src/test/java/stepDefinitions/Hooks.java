package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.sql.Driver;

public class Hooks {

    @Before
    public void beforeScenario() {
        DriverManager.getDriver().driver.manage().window().maximize();
    }

    /*@After
    public void afterScenario() {
        DriverManager.getDriver().driver.close();
    }*/
}
