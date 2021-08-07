package pageObject;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AddToCartPageObjects {

    private static final Logger logger = LogManager.getLogger(ProductDetailsPageObject.class);
    private WebDriver driver;

    private By select_product = By.linkText("Nokia 3.4 Dusk, 4GB RAM, 64GB Storage");
    private By add_to_cart = By.xpath("//*[@id=\"add-to-cart-button\"]");
    private By textbox_addedToCart = By.xpath("    //*[@id=\"huc-v2-order-row-confirm-text\"]/h1");

    public AddToCartPageObjects(WebDriver driver){
        this.driver = driver;

    }

    public void clickOnProduct(){
        driver.findElement(select_product).click();
    }
    public void ClickOnAddToCart(){
        driver.findElement(add_to_cart).click();
    }

    public void velidateToAddToCartPage(){
        driver.findElement(textbox_addedToCart);

    }



}
