package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.shadowCss;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static dict.Elements.SIGN_IN;

public class LoginPage extends BasePage {

    private final String LOGIN = "[name=email]";
    private final String PASSWORD = "[name=password]";
    private final String EXPECTED_TITLE = "Log in to your account";

    public LoginPage openPage() {
        Selenide.open("/login");
        return this;
    }

    public LoginPage login(String user, String password) {
        sleep(10000);
        $(shadowCss("#accept", "#usercentrics-cmp-ui")).click();
        $(LOGIN).setValue(user);
        $(PASSWORD).setValue(password);
        $(byText(SIGN_IN)).click();
        return this;
    }
    @Override
    public LoginPage isPageOpened() {
        $(byText(EXPECTED_TITLE)).shouldBe(visible);
        return this;
    }
}
