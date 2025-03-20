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
import pages.ProductDetailsPage;
import pages.SearchPage;
import utils.WebDriverUtil;

import java.time.Duration;
import java.util.List;


public class ProductDetailsTests {

    WebDriver driver;
    WebDriverWait wait;
    ProductDetailsPage productDetailsPage;
    SearchPage searchPage;

    @BeforeClass
    public void Setup() {
        driver = WebDriverUtil.initializeDriver();
        productDetailsPage = new ProductDetailsPage(driver);
        searchPage = new SearchPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void testProductItem() {
        // Test Case 4
        searchPage.search("jacket");

        // Wait for the search results page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//strong[contains(text(), 'Search results for:')]")));

        // Find the product items (list of product links)
        List<WebElement> products = driver.findElements(By.className("product-item-link"));

        // Loop through each product and verify the details
        for (int i = 0; i < 2; i++) {  // Adjust the number (2) to match how many products you want to test
            // Click the product item
            products.get(i).click();

            // Wait for the product details page to load
            wait.until(ExpectedConditions.visibilityOfElementLocated(productDetailsPage.name));

            // Directly call the methods from ProductDetailsPage to get product details and perform assertions
            Assert.assertNotNull(productDetailsPage.itemName(), "Product name is null.");
            Assert.assertNotNull(productDetailsPage.itemPrice(), "Product price is null.");
            Assert.assertNotNull(productDetailsPage.itemSize(), "Product size is null.");

            // Wait for the color to be visible before retrieving it
            wait.until(ExpectedConditions.visibilityOfElementLocated(productDetailsPage.colour));

            // Directly call the method to get color and perform assertion
            Assert.assertNotNull(productDetailsPage.itemColour(), "Product color is null.");

            // Print product details (optional)
            System.out.println("Product " + (i + 1) + ": Name - " + productDetailsPage.itemName() +
                    ", Price - " + productDetailsPage.itemPrice() +
                    ", Size - " + productDetailsPage.itemSize() +
                    ", Color - " + productDetailsPage.itemColour());

            // Navigate back to the main search results page
            productDetailsPage.navigateBackToMainScreen();

            // Wait for the search results to be visible again before selecting the next product
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//strong[contains(text(), 'Search results for:')]")));

            // Re-locate the products on the main screen, because the previous references might be stale
            products = driver.findElements(By.className("product-item-link"));
        }
    }

    @AfterClass
    public void tearDown() {
        // Quit the WebDriver after tests are done
        WebDriverUtil.quitDriver();  // Quit driver using WebDriverUtil method
    }
}

