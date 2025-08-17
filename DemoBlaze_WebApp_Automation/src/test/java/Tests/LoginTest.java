package Tests;

import Base.BaseClass;
import Pages.LoginPage;
import io.qameta.allure.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest extends BaseClass {
    LoginPage loginPage;

    @BeforeMethod
    public void SetUpTests() {
        super.SetUp();
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void TearDown() {
        driver.quit();
    }

    @Epic("Login Module")
    @Feature("Positive Flow")
    @Story("Successful Login Scenario")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Login successfully using valid credentials and verify Welcome Text")
    public void VerifyLoginWithValidCredentials() {
        loginPage.NativeLogin(UserName, Password);
        if (!loginPage.IsWelcomeTextPresent())
            Assert.fail("Dashboard Landing failed!");
    }

    @Epic("Login Module")
    @Feature("Positive Flow")
    @Story("Unsuccessful Login Scenario")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Login successfully using valid credentials and verify Welcome Text")
    public void VerifyLoginWithInvalidCredentials() {
        loginPage.NativeLogin(UserName, "Password");
        if(!loginPage.WrongPasswordAlert()) Assert.fail();
    }
}
