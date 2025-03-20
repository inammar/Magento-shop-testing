package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    // Locators for the login page - positive scenario
    private By signInButton = By.linkText("Sign In");
    private By usernameField = By.id("email");
    private By passwordField = By.id("pass");
    public By loginButton = By.id("send2");
    public By welcomeMessage = By.xpath("//span[@class='base' and @data-ui-id='page-title-wrapper' and text()='Home Page']");

    // Locators for negative scenario (wrong email and wrong password)
    public By invalidLoginMessage = By.cssSelector("div[data-bind='html: $parent.prepareMessageForHtml(message.text)']");

    //Locators, when one field: the email or password, remains empty
    public By emailError = By.id("email-error");
    public By passwordError = By.id("pass-error");

    // Constructor - makes sure driver is passed correctly to LoginPage
    public LoginPage(WebDriver driver) {
        this.driver = driver;  // Ensure driver is initialized and passed correctly
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Initialize WebDriverWait with 20 seconds
    }

    // Method to click the SignIn button
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    // Method to enter username
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    // Method to enter password
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Method to click the login button
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
        wait.withTimeout(Duration.ofSeconds(20));
    }

    // Method to perform login (combines the actions of entering username, password, and clicking login)
    public void login(String username, String password) {
        clickSignInButton();
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    // Method to wait for the welcome message to appear after login
    public void waitForWelcomeMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessage));  // Wait for visibility of the message
        System.out.println("Welcome message is displayed");  // Print confirmation after it appears
    }

    // Method to check if invalid login error message is displayed (top)
    public boolean isInvalidLoginMessageDisplayed() {
        return driver.findElement(invalidLoginMessage).isDisplayed();
    }

    // Method to check if both email and password error messages are displayed
    public boolean areFieldErrorsDisplayed() {
        boolean isEmailErrorDisplayed = driver.findElement(emailError).isDisplayed();
        boolean isPasswordErrorDisplayed = driver.findElement(passwordError).isDisplayed();
        // Return true only if both error messages are displayed
        return isEmailErrorDisplayed && isPasswordErrorDisplayed;
    }
}

