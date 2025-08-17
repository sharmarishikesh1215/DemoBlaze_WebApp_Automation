package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    public WebDriver driver;
    public WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    final By EmailField = By.xpath("//input[@id='loginusername']");
    final By PasswordField = By.xpath("//input[@id='loginpassword']");
    final By LoginButton = By.xpath("//button[contains(text() ,'Log in')]");
    final By WelcomeText = By.xpath("//a[contains(text(), 'Welcome testplaywrightautomation@gmail.com')]");
    final By LoginLink = By.xpath("//a[@id='login2']");

    @Step("Clicking on Login Link")
    public void clickOnLoginLink() {
        wait.until(ExpectedConditions.elementToBeClickable(LoginLink));
        driver.findElement(LoginLink).click();
    }

    @Step("Entering email in email field")
    public void EnterEmail(String UserName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(EmailField));
        driver.findElement(EmailField).sendKeys(UserName);
    }

    @Step("Enter password in password field")
    public void EnterPassword(String Password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PasswordField));
        driver.findElement(PasswordField).sendKeys(Password);
    }

    @Step("Clicking on Login Button")
    public void ClickOnLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LoginButton));
        driver.findElement(LoginButton).click();
    }

    @Step("Verifying if login is successfully completed")
    public void NativeLogin(String userName, String password) {
        clickOnLoginLink();
        EnterEmail(userName);
        EnterPassword(password);
        ClickOnLoginButton();
    }

    @Step("Verify if welcome text is present")
    public boolean IsWelcomeTextPresent() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(WelcomeText));
        return driver.findElement(WelcomeText).isDisplayed();
    }

    @Step("Verify JS alert on wrong credentials")
    public boolean WrongPasswordAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        return alert.getText().equals("Wrong password.");
    }
}
