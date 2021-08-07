package core;


import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Log4j2
public class WebDriverFactory {

    private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);
    private static WebDriver driver=null;



    public static WebDriver getWebDriverForBrowser() throws Exception {
        String browser = Base.getBrowser().toLowerCase();
        log.info("WebDriverFactory->getWebDriverForBrowser");

        if(browser.equals("firefox")){
            System.setProperty("webdriver.gecko.driver","src/test/resource/geckodriver.exe");
            driver = new FirefoxDriver();
        }else{
            System.setProperty("webdriver.chrome.driver", "src/test/resource/chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
    public static void quitDriver() {
        driver.quit();
        logger.info("Driver Closed");
    }
    public static void switchBrowserToTab() {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> hamdles = driver.getWindowHandles();
        logger.info("no. of Windows Found : "+hamdles.size());
        logger.info("Windows Handles : " + hamdles.toString());
        Iterator<String> It = hamdles.iterator();
        String original = It.next();
        String nextTab = It.next();
        driver.switchTo().window(nextTab);
        logger.info("Switch to The new Window/tab");

    }

    public static void switchToOriginalTab() {
        Set<String> handles = driver.getWindowHandles();
        logger.info("no. of windows found : " + handles.size());
        logger.info("Windows Handles : " + handles.toString());
        Iterator<String> It = handles.iterator();
        String Original = It.next();
        driver.switchTo().window(Original);
        logger.info("Switch to the original window or tab");
    }

    public static String getBrowserName() {
        String browserDefault = "chrome";
        String browserSentFromcmd = System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        if(browserSentFromcmd == null) {
            return browserDefault;
        }else {
            return browserSentFromcmd;
        }
    }





    }
