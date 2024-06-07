package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WebPage;

public class WebStep {

    WebPage webPage;

    public WebStep() {
        this.webPage = new WebPage();
    }

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        webPage.userIsOnLoginPage();
    }

    @When("user input username {string}")
    public void userInputUsername(String username) {
        webPage.userInputUsername(username);
    }

    @And("user input password {string}")
    public void userInputPassword(String password) {
        webPage.userInputPassword(password);
    }

    @And("user clicks login button")
    public void userClicksLoginButton() {
        webPage.userClicksLoginButton();
    }

    @Then("user should see cart icon on inventory page")
    public void userShouldSeeCartIconOnInventoryPage() {
        webPage.assertHomePage();
    }

    @Then("user should see error message {string}")
    public void userShouldSeeErrorMessage(String errorMessage) {
        webPage.assertErrorMessage(errorMessage);
    }

    @When("user clicks add to cart button {int} time\\(s)")
    public void userClicksAddToCartButton(int clicks) {
        for (int i = 0; i < clicks; i++) {
            webPage.userClicksAddToCartButton();
        }
    }

    @Then("verify number of items in cart matches")
    public void verifyNumberOfItemsInCartMatches() {
        webPage.assertNumberOfItemsInCart();
    }

    @When("user clicks remove button {int} time\\(s)")
    public void userClicksRemoveButtonTimeS(int clicks) {
        for (int i = 0; i < clicks; i++) {
            webPage.userClicksRemoveButton();
        }
    }
}
