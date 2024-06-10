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

    @When("user clicks add to cart button on {string}")
    public void userClicksAddToCartButtonOn(String itemName) {
        webPage.userClicksAddToCartButtonOn(itemName);
    }

    @When("user clicks remove button {int} time\\(s)")
    public void userClicksRemoveButtonTimeS(int clicks) {
        for (int i = 0; i < clicks; i++) {
            webPage.userClicksRemoveButton();
        }
    }

    @Then("verify number of items in cart matches")
    public void verifyNumberOfItemsInCartMatches() {
        webPage.assertNumberOfItemsInCart();
    }

    @When("user clicks the cart icon")
    public void userClicksTheCartIcon() {
        webPage.userClicksTheCartIcon();
    }

    @Then("user redirected to cart page")
    public void userRedirectedToCartPage() {
        webPage.userRedirectedToCartPage();
    }

    @And("user should see the {string} item in cart")
    public void userShouldSeeTheItemInCart(String itemName) {
        webPage.userShouldSeeTheItemInCart(itemName);
    }

    @When("user clicks sort button and select {string}")
    public void userClicksSortButtonAndSelect(String sortOptions) {
        webPage.userClicksSortButtonAndSelect(sortOptions);
    }

    @Then("user should see the items are sorted")
    public void userShouldSeeTheItemsSortedBy() {
        webPage.userShouldSeeTheItemsSortedBy();
    }
}
