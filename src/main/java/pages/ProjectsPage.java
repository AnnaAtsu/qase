package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.Assert.assertEquals;


public class ProjectsPage extends BasePage{
    private final String EXPECTED_TITLE = "Projects";
    private final SelenideElement PROJECT_ITEMS = $x("//tbody");


    public ProjectsPage openPage() {
        Selenide.open("/projects");
        return this;
    }

    public ProjectsPage verifyProjectInList(String projectName) {
        $(byText(projectName)).shouldBe(visible);
        return this;
    }

    public ProjectsPage checkTitleProjectsPage() {
        String actualTitle = $("h1").shouldBe(visible).getText();
        assertEquals(actualTitle, EXPECTED_TITLE);
        return this;
    }

    @Override
    public ProjectsPage isPageOpened() {
        PROJECT_ITEMS.shouldBe(visible);
        return this;
    }
}
