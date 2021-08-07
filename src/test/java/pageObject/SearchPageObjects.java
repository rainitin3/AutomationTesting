package pageObject;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

@Log4j2
public class SearchPageObjects {


    private static final Logger logger = LogManager.getLogger(SearchPageObjects.class);
    private WebDriver driver;
    private By refinement_categories_segment = By.id("s-refinements");
    private By product_link_list = By.xpath("//a[@class='a-link-normal a-text-normal']");
    private By txtbx_minimum_price_filter = By.name("low-price");
    private By txtbx_maximum_price_filter = By.name("high-price");
    private By go_button_price_filter = By.xpath("//input[@aria-labelledby='a-autoid-1-announce']");
    private By product_price_list = By.xpath("//span[@class='a-price-whole']");

    public SearchPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public void validateProductSearchSuccessful() {
        if (driver.findElement(refinement_categories_segment).isDisplayed()) {
            Assert.assertTrue(true);
            logger.info("Search Page is displayed because refinement category is displayed");
        } else {
            logger.fatal("Search Page is not displayed because refinement category is not displayed");
            Assert.fail("Search Page is not displayed because refinement category is not displayed");

        }

    }

    public String clickOnTheProductLink(int productIndex) {

        List<WebElement> listOfProducts = driver.findElements(product_link_list);
        logger.info("No. of Products Searched : " + listOfProducts.size());
        listOfProducts.get(productIndex).click();
        logger.info("click On the Link In The List with Index " + productIndex + "Link text : " + listOfProducts.get(productIndex).getText());
        return listOfProducts.get(productIndex).getText();

    }

    public void FilterSearchResultByPrice(String min, String max) {
        driver.findElement(txtbx_minimum_price_filter).sendKeys(min);
        logger.info("Min Price Field set " + min);

        driver.findElement(txtbx_maximum_price_filter).sendKeys(max);
        logger.info("max price field set " + max);

        driver.findElement(go_button_price_filter).click();
        logger.info("Search Price Filter - Go Button Click ");

    }


    public void verifiedThatSearchProductAreInPriceRange(int min, int max) {

        List<WebElement> product_Prices = driver.findElements(product_price_list);
        boolean bResult = false;
        int price_temp = 0;

        for (int i = 0; i < product_Prices.size(); i++) {
            price_temp = Integer.parseInt(product_Prices.get(i).getText().replaceAll(",", ""));
            if (price_temp >= min && price_temp <= max) {
                bResult = true;
                logger.info("for Index : " + i + "Product Price : " + price_temp + " and for product " + product_Prices.get(i).getText());
            } else {
                bResult = false;
                logger.info("Product list is not With in Price List . Failed");
                break;
            }

            if (bResult) {
                Assert.assertTrue("Search Result is with in the defined range i.e. Min: " + min + "Max:" + max, true);
                logger.info("All product is filtered with right price range. Min: " + min + " Max: " + max);
            } else {
                logger.error("All product is not filtered with right price range. Min: " + min + " Max: " + max);
                Assert.fail("Search Result is not with in the defined range i.e. Min: " + min + " Max: " + max);

            }


        }

    }
}
