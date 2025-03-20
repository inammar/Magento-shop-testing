package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SearchPage;
import utils.WebDriverUtil;

import java.time.Duration;
import java.util.List;

public class SearchTests {

WebDriver driver;
SearchPage searchPage;
WebDriverWait wait;


@BeforeClass
    public void Setup() {
    driver = WebDriverUtil.initializeDriver();
    searchPage = new SearchPage(driver);
    wait = new WebDriverWait(driver, Duration.ofSeconds(20));
}

        @Test
        public void testSearchPhase1() {
            // Test Case 5
            searchPage.search("watch");

            // Wait for the search result page title to appear and ensure it's visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement resultPage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//strong[contains(text(), 'Search results for:')]")));

            // Assert the result page is displayed
            Assert.assertTrue(resultPage.isDisplayed(), "Search result message not displayed.");
            System.out.println(resultPage.getText());

            // Get the search results
            List<WebElement> results = driver.findElements(By.className("product-item-link"));

            // Verify search results contain 'watch' in the first 2 items
            for (int i = 0; i < 2; i++) {
                if (i >= results.size()) break; // Handle case if fewer than 2 results exist
                WebElement result = results.get(i);
                Assert.assertTrue(result.getText().toLowerCase().contains("watch"),
                        "Search result at index " + i + " does not contain 'watch'. Actual text: " + result.getText());
            }

            // Ensure that the first 2 items have images
            for (int i = 0; i < 2; i++) {
                if (i >= results.size()) break; // Handle case if fewer than 2 results exist
                WebElement result = results.get(i);
                WebElement image = result.findElement(By.xpath("//img[contains(@src, 'catalog/product/cache')]"));
                Assert.assertTrue(image.isDisplayed(), "Image is not displayed in result at index " + i);
            }

            // Navigate back to the main screen - method
            searchPage.navigateBackToMainScreen();
        }


    @Test
    public void testSearchPhase2() {
        searchPage.search("top");
        // Wait for the search result page title to appear and ensure it's visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement resultPage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//strong[contains(text(), 'Search results for:')]")));

        // Assert the result page is displayed
        Assert.assertTrue(resultPage.isDisplayed(), "Search result message not displayed.");

        // Print the result
        System.out.println(resultPage.getText());

        // Get the search results
        List<WebElement> results = driver.findElements(By.className("product-item-link"));

        // Verify search results contain 'watch' in the first 2 items
        for (int i = 0; i < 2; i++) {
            if (i >= results.size()) break; // Handle case if fewer than 2 results exist
            WebElement result = results.get(i);
            Assert.assertTrue(result.getText().toLowerCase().contains("top"),
                    "Search result at index " + i + " does not contain 'top'. Actual text: " + result.getText());
        }

        // Ensure that the first 2 items have images
        for (int i = 0; i < 2; i++) {
            if (i >= results.size()) break; // Handle case if fewer than 2 results exist
            WebElement result = results.get(i);
            WebElement image = result.findElement(By.xpath("//img[contains(@src, 'catalog/product/cache')]"));
            Assert.assertTrue(image.isDisplayed(), "Image is not displayed in result at index " + i);
        }

        // Navigate back to the main screen
        searchPage.navigateBackToMainScreen();
    }

    @Test
    public void testSearchPhase3() {
        searchPage.search("jacket");
        // Wait for the search result page title to appear and ensure it's visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement resultPage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//strong[contains(text(), 'Search results for:')]")));

        // Assert the result page is displayed
        Assert.assertTrue(resultPage.isDisplayed(), "Search result message not displayed.");

        // Print the result
        System.out.println(resultPage.getText());

        // Get the search results
        List<WebElement> results = driver.findElements(By.className("product-item-link"));

        // Verify search results contain 'watch' in the first 2 items
        for (int i = 0; i < 2; i++) {
            if (i >= results.size()) break; // Handle case if fewer than 2 results exist
            WebElement result = results.get(i);
            Assert.assertTrue(result.getText().toLowerCase().contains("jacket"),
                    "Search result at index " + i + " does not contain 'jacket'. Actual text: " + result.getText());
        }

        // Ensure that the first 2 items have images
        for (int i = 0; i < 2; i++) {
            if (i >= results.size()) break; // Handle case if fewer than 2 results exist
            WebElement result = results.get(i);
            WebElement image = result.findElement(By.xpath("//img[contains(@src, 'catalog/product/cache')]"));
            Assert.assertTrue(image.isDisplayed(), "Image is not displayed in result at index " + i);
        }

        // Navigate back to the main screen
        searchPage.navigateBackToMainScreen();
    }

    @AfterClass
    public void tearDown() {
    // Quit the WebDriver after tests are done
    WebDriverUtil.quitDriver();  // Quit driver using WebDriverUtil method
    }
}
