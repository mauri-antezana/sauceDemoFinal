package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInformationPage {
    WebDriver driver;

    @FindBy(id = "first-name")
    WebElement firstNameTextBox;

    @FindBy(id="last-name")
    WebElement lastNameTextBox;

    @FindBy(id="postal-code")
    WebElement zipCodeTextBox;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(css = "#checkout_info_container > div > form > div.checkout_info > div.error-message-container.error > h3")
    WebElement errorMessage;

    public CheckoutInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickContinueButton() {continueButton.click();}

    public boolean verifyErrorMessage() {return errorMessage.isDisplayed();}

    public void setFirstNameTextBox(String firstName){
        firstNameTextBox.sendKeys(firstName);
    }

    public void setLastNameTextBox(String lastName){
        lastNameTextBox.sendKeys(lastName);
    }

    public void setZipCodeTextBox(String zipCode){
        zipCodeTextBox.sendKeys(zipCode);
    }

}
