package pageObject;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class SignInPageObjects {
    private static final Logger logger = LogManager.getLogger(SignInPageObjects.class);
    private WebDriver driver;

    private By Click_on_SighIn_link = By.xpath("//span[text()='Hello, Sign in']");
    private By input_textbox_email = By.id("ap_email");
    private By continue_button = By.id("continue");
    private By inout_text_password = By.id("ap_password");
    private By signIn_button = By.id("signInSubmit");

    public SignInPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public void validateEmailInputTextBoxIsDisplayed() {
        if(driver.findElement(input_textbox_email).isDisplayed()) {
            Assert.assertTrue(true);
            logger.info("Email input box is displayed");
        }else {
            Assert.fail("Email text box does not appear for login after clicking on Sign in button");
            logger.fatal("Email input box is  not displayed");
        }
    }

    public void enterTextInEmailTextBox(String text ) {
        driver.findElement(input_textbox_email).sendKeys("rainitin3@gmail.com");
        logger.info("text entered in email ID : "+text);

    }
    public void ClickOnButton(){
        driver.findElement(continue_button).click();
        logger.info("Click on continue button");
    }

    public void ClickOnSighInLink(){
        driver.findElement(Click_on_SighIn_link).click();
        logger.info("click on sigh in link");
    }

    public void enterTextPassword(){
        driver.findElement(inout_text_password).sendKeys("nitin@123");
        logger.info("enter password and sighin");
    }

    public void clickOnSighInButton(){
        driver.findElement(signIn_button).click();
        logger.info("click on sighin button ");
    }


}
