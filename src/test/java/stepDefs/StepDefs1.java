package stepDefs;

import core.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefs1 {


    TestContext testContext;
    public Scenario scn;

    public void temp(Scenario s) {

        this.scn = s;
    }

    public StepDefs1(TestContext testContext) {

        this.testContext = testContext;
        this.scn = testContext.scn;

    }


    @Given("User navigated to the Home Application URL")
    public void user_navigated_to_the_home_application_url() {
      testContext.driver.get(testContext.base_url);
      String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
      testContext.cmnPageObject.velidatePageTitleMatch(expected);
      scn.log("Browser navigated to the URL ; "+ testContext.base_url);
    }
    @When("User Search For Product {string}")
    public void user_search_for_product(String productName) {
        testContext.cmnPageObject.setSearchTextBox(productName);
        testContext.cmnPageObject.clickOnSearchButton();
        scn.log("product search :" +productName);

    }

    @Then("search Result Page Dispalyed")
    public void search_result_page_dispalyed() {
        testContext.searchPageObjects.validateProductSearchSuccessful();

    }

    @When("User search for a Product as {string}")
    public void user_search_for_a_product_as(String productName) {
     testContext.cmnPageObject.setSearchTextBox(productName);
     testContext.cmnPageObject.clickOnSearchButton();
    }

    @When("User enters minimum as {string} and maximum as {string} in the filter criteria")
    public void user_enters_minimum_as_and_maximum_as_in_the_filter_criteria(String string, String string2) {
        testContext.searchPageObjects.FilterSearchResultByPrice(string, string2);
    }


    @Then("User is able to see results with price between {string} and {string}")
    public void user_is_able_to_see_results_with_price_between_and(String string, String string2) {
        testContext.searchPageObjects.verifiedThatSearchProductAreInPriceRange(20000, 50000);

    }

//sighin

    @Given("user Navigate to Url")
    public void user_navigate_to_url() {
       testContext.driver.get(testContext.base_url);
       testContext.signInPageObjects.ClickOnSighInLink();
    }
    @When("User Enter UserId {string}")
    public void user_enter_user_id(String userId) {
        testContext.signInPageObjects.enterTextInEmailTextBox("rainitin3@gmail.com");
        testContext.signInPageObjects.ClickOnButton();
    }
    @Then("user should be able to enter password {string}")
    public void user_should_be_able_to_enter_password(String password) {
        testContext.signInPageObjects.enterTextPassword();
        testContext.signInPageObjects.clickOnSighInButton();


    }


}
