package pages;

import org.openqa.selenium.By;

import static helper.Utility.driver;
import static org.assertj.core.api.Assertions.assertThat;

public class WebPage {
    public int items = 0;
    By input_username = By.id("user-name");
    By input_password = By.id("password");
    By button_login = By.id("login-button");
    By icon_cart = By.xpath("//a[@class='shopping_cart_link']");
    By icon_cart_item = By.xpath("//span[@class='shopping_cart_badge']");
    By add_to_cart = By.xpath("(//*[text()='Add to cart'])[1]");
    By remove_from_cart = By.xpath("(//*[text()='Remove'])[1]");

    By text_error_message(String message) {
        return By.xpath("//*[contains(text(),'" + message + "')]");
    }

    public void userIsOnLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    public void userInputUsername(String username) {
        driver.findElement(input_username).sendKeys(username);
    }

    public void userInputPassword(String password) {
        driver.findElement(input_password).sendKeys(password);
    }

    public void userClicksLoginButton() {
        driver.findElement(button_login).click();
    }

    public void assertHomePage() {
        driver.findElement(icon_cart).isDisplayed();
    }

    public void assertErrorMessage(String errorMessage) {
        driver.findElement(text_error_message(errorMessage));
    }

    public void userClicksAddToCartButton() {
        driver.findElement(add_to_cart).click();
        items++;
    }

    public void userClicksRemoveButton() {
        driver.findElement(remove_from_cart).click();
        items--;
    }

    public void assertNumberOfItemsInCart() {
        if (!driver.findElements(icon_cart_item).isEmpty()) {
            String itemExpected = Integer.toString(items);
            String itemActual = driver.findElement(icon_cart_item).getText();
            assertThat(itemActual).isEqualTo(itemExpected);
        } else {
            System.out.println("There are no items in the cart.");
        }
    }
}
