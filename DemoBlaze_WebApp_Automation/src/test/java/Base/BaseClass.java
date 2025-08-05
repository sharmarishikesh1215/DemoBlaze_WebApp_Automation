package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
    public static WebDriver driver;

    protected String UserName = "testplaywrightautomation@gmail.com";
    protected String Password = "Test@123";
    protected String URL = "https://demoblaze.com/index.html";

    public void SetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }
}
