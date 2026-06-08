import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://app.qase.io";
        Configuration.timeout = 50000;
        Configuration.clickViaJs = true;
        //Configuration.assertionMode = AssertionMode.SOFT;
        Configuration.browserSize = "1200x1080";
        loginPage = new LoginPage();
    }

    @AfterMethod
    public void quit() {
        getWebDriver().quit();
    }
}
