package stepDefs;

import core.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.log4j.Log4j2;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Hooks {



    TestContext testContext;
    WebDriver driver;

    public Hooks(TestContext testContext) {

        this.testContext = testContext;
        driver = testContext.driver;

    }


    @Before
    public void setUp(Scenario scn) throws Exception {

        testContext.initializeWebDriver();
        testContext.initializePageObject();
        testContext.scn = scn;
    }



    @After(order = 1)
    public void cleanUp(Scenario scn) {
        testContext.quitDriver();
        scn.log("Browser Closed");
    }

    @After(order = 2)
    public void takeScreenShot(Scenario scn) {

        if (scn.isFailed()) {
            TakesScreenshot scrnShot = (TakesScreenshot) driver;
            byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
            scn.attach(data, "image/png", "Failed Step name : " + scn.getName());

        } else {

            scn.log("Test case is passed, no screen shot captured");

        }
    }
    }
