package stepDefs;

import core.TestContext;
import core.WebDriverFactory;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartStepDefs {

    TestContext testContext;
    public Scenario scn;

    public void temp(Scenario s) {

        this.scn = s;
    }

    public CartStepDefs(TestContext testContext) {

        this.testContext = testContext;
        this.scn = testContext.scn;

    }


    @Given("user search product {string}")
    public void user_search_product(String string) {
         testContext.driver.get(testContext.base_url);
         testContext.cmnPageObject.setSearchTextBox("Nokia 3.4 Dusk, 4GB RAM, 64GB Storage");
         testContext.cmnPageObject.clickOnSearchButton();
         testContext.addToCartPageObjects.clickOnProduct();
         scn.log("User search product As mobile");
    }
    @When("user add the product in the cart with quantity {int}")
    public void user_add_the_product_in_the_cart_with_quantity(Integer int1) {
        WebDriverFactory.switchBrowserToTab();
        testContext.productDescriptionPageObjects.selectQuantity("1");
        testContext.productDescriptionPageObjects.clickOnAddToCartButton();
        scn.log("select a quantity 1");
    }
    @Then("Product should be in the Cart")
    public void product_should_be_in_the_cart() {
        testContext.productDescriptionPageObjects.checkAddedToCartMessageIsDisplayed();
        scn.log("product in a cart");

    }

}
