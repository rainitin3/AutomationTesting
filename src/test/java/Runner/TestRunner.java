package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\raini\\IdeaProjects\\DemoCucumberFW\\src\\test\\resource\\features",
        glue = "stepDefs",

        plugin = { "pretty",
                "html:target/Reports/cucumber-report.html",
                "json:target/Reports/cucumber-json-report.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        publish = true,
        dryRun = false

)
public class TestRunner {

}
