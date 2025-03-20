package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;

    private By searchField = By.id("search");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    public void enterSearchPhrase(String phrase) {
        driver.findElement(searchField).sendKeys(phrase);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        System.out.println("Entered search phrase and pressed Enter.");
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    public void search(String phrase) {
        enterSearchPhrase(phrase);
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(home));
    }

    public void navigateBackToMainScreen() {

        // Navigate back to the home page
        driver.navigate().back();

        // Wait for the home page to load after navigating back
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }
}
