package pages;

import helper.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static helper.Utility.driver;
import static helper.Utility.getProductsInfo;
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
    By button_sort = By.xpath("//select[@class='product_sort_container']");
    List<Utility.ProductInfo> expectedOrder;

    By text_error_message(String message) {
        return By.xpath("//*[contains(text(),'" + message + "')]");
    }

    By items_name(String name) {
        return By.xpath("//*[contains(text(),'" + name + "')]");
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

    public void userClicksAddToCartButtonOn(String itemName) {
        By itemId = By.id(Utility.itemNameToItemId(itemName));
        driver.findElement(itemId).click();
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

    public void userClicksTheCartIcon() {
        driver.findElement(icon_cart).click();
    }

    public void userRedirectedToCartPage() {
        String currentUrl = driver.getCurrentUrl();
        assertThat(currentUrl).isEqualTo("https://www.saucedemo.com/cart.html");
    }

    public void userShouldSeeTheItemInCart(String itemName) {
        String nameActual = driver.findElement(items_name(itemName)).getText();
        assertThat(nameActual).isEqualTo(itemName);
    }

    public void userClicksSortButtonAndSelect(String sortOptions) {
        driver.findElement(button_sort).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//select[@class='product_sort_container']//option")));
        List<Utility.ProductInfo> productsBeforeSort = getProductsInfo();
        System.out.println(productsBeforeSort);

        WebElement options = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select option = new Select(options);

        switch (sortOptions) {
            case "Name (A to Z)":
                option.selectByValue("az");
                break;
            case "Name (Z to A)":
                option.selectByValue("za");
                break;
            case "Price (low to high)":
                option.selectByValue("lohi");
                break;
            case "Price (high to low)":
                option.selectByValue("hilo");
                break;
            default:
                System.out.println("Invalid sort option provided: " + sortOptions);
        }
        expectedOrder = new ArrayList<>(productsBeforeSort);
    }

    public void userShouldSeeTheItemsSortedBy(String sortOptions) {
        List<Utility.ProductInfo> productsAfterSort  = getProductsInfo();
        System.out.println(productsAfterSort);

        switch (sortOptions) {
            case "Name (A to Z)":
                expectedOrder.sort(Comparator.comparing(Utility.ProductInfo::getName));
                break;
            case "Name (Z to A)":
                expectedOrder.sort(Comparator.comparing(Utility.ProductInfo::getName).reversed());
                break;
            case "Price (low to high)":
                expectedOrder.sort(Comparator.comparing(Utility.ProductInfo::getPrice));
                break;
            case "Price (high to low)":
                expectedOrder.sort(Comparator.comparing(Utility.ProductInfo::getPrice).reversed());
                break;
            default:
                System.out.println("Invalid sort option provided: " + sortOptions);
        }
    }
}
