package pageObject;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class ProductDetailsPageObject {
    private static final Logger logger = LogManager.getLogger(ProductDetailsPageObject.class);

    private WebDriver driver;

    private By product_title = By.id("productTitle");
    private By add_to_cart_button = By.id("add-to-cart-button");
    private By drop_down_select_quantity = By.xpath("//select[@name='quantity']");
    private By text_added_to_cart_message = By.xpath("//div[@class='a-box a-alert a-alert-success added-to-cart-message-box']//h4[text()='Added to Cart']");
    private By text_added_to_cart_message_other_version = By.xpath("//h1[@class='a-size-medium a-text-bold' and contains(text(),'Added to Cart')]");


    public ProductDetailsPageObject(WebDriver driver) {

        this.driver = driver;
    }

    public void  clickOnAddToCartButton() {
        driver.findElement(add_to_cart_button).click();
        logger.info("Add to cart button on product description page is clicked.");
    }

    public void selectQuantity(String quantity) {

        Select select = new Select(driver.findElement(drop_down_select_quantity));
        select.selectByValue(quantity);
        logger.info("Quantity is selected as : " + quantity);
    }



    public void checkAddedToCartMessageIsDisplayed() {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(text_added_to_cart_message));
            Assert.assertEquals("Added to Cart Message", true, element.isDisplayed());

        } catch (Exception e) {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(text_added_to_cart_message_other_version));
            Assert.assertEquals("Added to Cart Message", true, element.isDisplayed());
        }
    }

    public void ValidateProductTileIsCorrectlyDisplayed(){
        if(driver.findElement(product_title).isDisplayed()) {
            Assert.assertTrue(true);
            logger.info("Product title is Displayed");
        }else {
            Assert.fail("Product Title is Not displyed");
            logger.fatal("Product Title is Not displyed");
        }

    }

    public void ValidateAddToCartButtonIsCorrectlyDisplayed() {
        if(driver.findElement(add_to_cart_button).isDisplayed()) {
            Assert.assertTrue(true);
            logger.info("Add to Cart Button Is Displayed");
        }else {
            Assert.fail("Add to cart Button is Not displayed");
            logger.fatal("Add to Cart Button is nOt Displayed");
        }

    }
}
