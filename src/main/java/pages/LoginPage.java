package pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.shadowCss;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static dict.Elements.SIGN_IN;

public class LoginPage {

    private final String LOGIN = "[name=email]";
    private final String PASSWORD = "[name=password]";

    public void openPage() {
        Selenide.open("/login");
    }

    public void login(String user, String password) {
        sleep(10000);
        $(shadowCss("#accept", "#usercentrics-cmp-ui")).click();
        $(LOGIN).setValue(user);
        $(PASSWORD).setValue(password);
        $(byText(SIGN_IN)).click();
    }
}
