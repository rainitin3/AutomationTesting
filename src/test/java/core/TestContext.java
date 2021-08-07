package core;

import io.cucumber.java.Scenario;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pageObject.*;

@Log4j2
public class TestContext {

    public WebDriver driver;
    public String base_url = "https://amazon.in";
    public int implicit_wait_timeout_in_sec = 20;
    public Scenario scn;

    public CmnPageObject cmnPageObject;
    public ProductDetailsPageObject productDescriptionPageObjects;
    public SearchPageObjects searchPageObjects;
    public SignInPageObjects signInPageObjects;
    public AddToCartPageObjects addToCartPageObjects;

    public void initializeWebDriver() throws Exception {

        String browserName = WebDriverFactory.getBrowserName();
        driver = WebDriverFactory.getWebDriverForBrowser();
        log.info("Browser Invoked");
    }

    public void quitDriver() {
        driver.quit();
        log.info("Browser closed");
    }

    public void initializePageObject() {

        cmnPageObject = new CmnPageObject(driver);
        productDescriptionPageObjects = new ProductDetailsPageObject(driver);
        searchPageObjects = new SearchPageObjects(driver);
        signInPageObjects = new SignInPageObjects(driver);
        addToCartPageObjects = new AddToCartPageObjects(driver);

    }

}
