package pages;

import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    WebDriver driver;

    @FindBy(className = "app_logo")
    WebElement sauceDemoTitle;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

    @FindBy(className = "product_sort_container")
    WebElement sortContainer;

    @FindBy(className = "inventory_item_name")
    List<WebElement> productsTitleList;

    @FindBy(className = "inventory_item_price")
    List<WebElement> productsPriceList;

    @FindBy(id = "react-burger-menu-btn")
    WebElement reactBurgerMenu;

    @FindBy(id = "reset_sidebar_link")
    WebElement resetSidebarLink;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean sauceDemoTitleIsDisplayed(){
        return sauceDemoTitle.isDisplayed();
    }

    public void addProductToCart(String productName) {
        String productId = "add-to-cart-" + productName.replace(" ", "-").toLowerCase();
        WebElement productAddToCartButton = driver.findElement(By.id(productId));
        productAddToCartButton.click();
    }

    public void addAllProductsToCart() {
        for (WebElement product : productsTitleList) {
            String productId = "add-to-cart-" + product.getText().replace(" ", "-").toLowerCase();
            WebElement productAddToCartButton = driver.findElement(By.id(productId));
            productAddToCartButton.click();
        }
    }

    public void clickCartIcon() {
        cartIcon.click();
    }

    public boolean verifyNameOrder(String orderText){
        boolean res = false;
        Select select = new Select(sortContainer);
        List<String> actualOrder = new ArrayList<>();

        switch (orderText){
            case "Name (A to Z)":
                select.selectByVisibleText(orderText);

                for (WebElement element : productsTitleList){
                    actualOrder.add(element.getText());
                }

                res = Ordering.natural().isOrdered(actualOrder);
                break;

            case "Name (Z to A)":
                select.selectByVisibleText(orderText);

                for (WebElement element : productsTitleList){
                    actualOrder.add(element.getText());
                }

                res = Ordering.natural().reverse().isOrdered(actualOrder);
                break;

            default:
                break;
        }

        return res;
    }

    public boolean verifyPriceOrder(String orderText){
        boolean res = false;
        Select select = new Select(sortContainer);
        List<String> actualOrder = new ArrayList<>();
        List<Double> actualPrice = new ArrayList<>();

        switch (orderText){
            case "Price (low to high)":
                select.selectByVisibleText(orderText);

                for (WebElement element : productsPriceList){
                    actualOrder.add(element.getText());
                }

                for (String s : actualOrder){
                    String noSymbol = s.replace("$","");
                    double price = Double.parseDouble(noSymbol);

                    actualPrice.add(price);
                }

                res = Ordering.natural().isOrdered(actualPrice);
                break;

            case "Price (high to low)":
                select.selectByVisibleText(orderText);

                for (WebElement element : productsPriceList){
                    actualOrder.add(element.getText());
                }

                for (String s : actualOrder){
                    String noSymbol = s.replace("$","");
                    double price = Double.parseDouble(noSymbol);

                    actualPrice.add(price);
                }

                res = Ordering.natural().reverse().isOrdered(actualPrice);
                break;

            default:
                break;
        }

        return res;
    }

    public void resetAppState(){
        reactBurgerMenu.click();
        resetSidebarLink.click();
    }
}
