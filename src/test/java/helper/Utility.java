package helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Utility {

    public static WebDriver driver;

    public static void startDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments(("--headless"));
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public static void quitDriver() {
        driver.quit();
    }

    public static String itemNameToItemId(String itemName) {
        return "add-to-cart-" + itemName.toLowerCase().replaceAll("\\s+", "-");
    }

    public record ProductInfo(String name, double price) {
        public String getName() {
            return name;
        }
        public double getPrice() {
            return price;
        }
    }

    public static List<ProductInfo> getProductsInfo() {
        List<ProductInfo> productInfoList = new ArrayList<>();
        List<WebElement> productElements = driver.findElements(By.className("inventory_item_description"));

        for (WebElement productElement : productElements) {
            String productName = productElement.findElement(By.className("inventory_item_name")).getText();
            double price = Double.parseDouble(productElement.findElement(By.className("inventory_item_price")).getText().substring(1));
            ProductInfo productInfo = new ProductInfo(productName, price);
            productInfoList.add(productInfo);
        }
        return productInfoList;
    }
}
