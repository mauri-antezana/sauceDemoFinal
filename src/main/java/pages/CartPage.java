package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    WebDriver driver;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    @FindBy(className = "inventory_item_name")
    List<WebElement> cartItems;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnCheckoutButton(){
        checkoutButton.click();
    }

    public String getProduct(){
        String actualProduct = cartItems.getFirst().getText();
        System.out.println(actualProduct);
        return actualProduct;
    }

    public void removeProduct(String product){
        String productId = "remove-"+product.replace(" ", "-").toLowerCase();
        WebElement removeProductButton = driver.findElement(By.id(productId));
        removeProductButton.click();
    }
}
