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
import pages.LoginPage;
import utils.WebDriverUtil;

import java.time.Duration;

public class LoginTests {

    WebDriver driver;
    LoginPage loginPage;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // Initialize WebDriver using WebDriverUtil (which now uses WebDriverManager)
        driver = WebDriverUtil.initializeDriver();  // WebDriverManager will automatically handle ChromeDriver setup
        loginPage = new LoginPage(driver);// Initialize the LoginPage object
        wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Set the timeout to 20 seconds
    }

    @Test
    public void testEmptyFieldsLogin() {

        // Test case 1: Email field empty
        loginPage.login("", "validPassword123");
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.emailError));
        WebElement emailError = driver.findElement(loginPage.emailError);
        Assert.assertTrue(emailError.isDisplayed(), "Error message not displayed for empty email.");
    }

    @Test
    public void testEmptyFieldsLogin1() {
        // Test case 2: Password field empty
        loginPage.login("validEmail@test.com", "");
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.passwordError));
        WebElement passwordError = driver.findElement(loginPage.passwordError);
        Assert.assertTrue(passwordError.isDisplayed(), "Error message not displayed for empty password.");
    }

    @Test
    public void testEmptyFieldsLogin2() {
        // Test case 3: Both fields empty
        loginPage.login("", "");
        // Wait for both email and password error messages to be present
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.emailError));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.passwordError));
        Assert.assertTrue(loginPage.areFieldErrorsDisplayed(), "Error messages not displayed for both email and password.");
    }

    @Test
    public void testInvalidLogin() {
        // Test  case 4: wrong credentials
        loginPage.login("wronguser@gmail.com", "wrongpassword");
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.invalidLoginMessage));
        Assert.assertTrue(loginPage.isInvalidLoginMessageDisplayed(), "Invalid login message is not displayed.");

        System.out.println("Invalid login test passed. Error message displayed.");
    }

    @Test
    public void testValidLogin() {
        // Test  case 5: valid credentials
        loginPage.login("inam999@gmail.com", "Menulis123");  // valid credentials
        loginPage.waitForWelcomeMessage();
        WebElement welcomeMessageElement = driver.findElement(loginPage.welcomeMessage);
        Assert.assertTrue(welcomeMessageElement.isDisplayed(), "Welcome message is not displayed.");
    }

    //@AfterClass
    //public void tearDown() {
        // Quit the WebDriver after tests are done
        //WebDriverUtil.quitDriver();  // Quit driver using WebDriverUtil method
    //}
}


