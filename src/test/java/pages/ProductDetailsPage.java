package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailsPage {

    WebDriver driver;
    WebDriverWait wait;

    public By name = By.className("page-title");
    private By price = By.cssSelector("span.price");
    private By size = By.id("option-label-size-143-item-169");
    public By colour = By.cssSelector("div.swatch-option[aria-label='Purple']");

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public String itemName() {
        return driver.findElement(name).getText();
    }

    public String itemPrice() {
        // Added wait to make sure the price is visible before retrieving
        wait.until(ExpectedConditions.visibilityOfElementLocated(price));
        return driver.findElement(price).getText();
    }

    public String itemSize() {
        return driver.findElement(size).getText();
    }

    public String itemColour() {
        // Wait explicitly for the color element to be visible and clickable
        wait.until(ExpectedConditions.visibilityOfElementLocated(colour));
        WebElement colorElement = driver.findElement(colour);
        return colorElement.getAttribute("aria-label");
    }

    public void navigateBackToMainScreen() {
        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(), 'Search results for:')]")));
    }
}
