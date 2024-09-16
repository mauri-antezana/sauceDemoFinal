package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CheckoutOverviewPage {
    WebDriver driver;

    @FindBy(className = "inventory_item_price")
    List<WebElement> itemPrices;

    @FindBy(className = "summary_tax_label")
    WebElement taxLabel;

    @FindBy(className = "summary_subtotal_label")
    WebElement subtotalLabel;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String calculateTax(double percentage) {
        double total = 0;
        String taxTotal = "";

        for (WebElement element : itemPrices){
            total += Double.parseDouble(element.getText().replace("$",""));
        }

        taxTotal = String.format("%.2f",total* percentage);

        return taxTotal;
    }

    public String calculateSubtotal() {
        double total = 0;
        String subtotalTotal = "";

        for (WebElement element : itemPrices){
            total += Double.parseDouble(element.getText().replace("$",""));
        }

        subtotalTotal = String.format("%.2f",total);

        return subtotalTotal;
    }

    public String getSubtotal() {
        return subtotalLabel.getText().substring(13);
    }

    public String getTax(){
        return taxLabel.getText().substring(6);
    }
}
