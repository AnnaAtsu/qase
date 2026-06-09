package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertTrue;

public class ProjectPage extends BasePage{
    private final SelenideElement PROJECT_ITEM = $x("//div/a");

    public ProjectPage createProject(String projectName, String projectCode) {
        $(byText("Create new project")).click();
        $("#project-name").setValue(projectName);
        $("#project-code").setValue(projectCode);
        $("#description-area").setValue("My description");
        return this;
    }

    public ProjectPage verifyProjectUrl(String projectCode) {
        assertTrue(url().contains("/project/" + projectCode));
        return this;
    }

    public ProjectPage clickButtonCreateProject() {
        $(byText("Create project")).click();
        return this;
    }

    public ProjectPage openProjectPage() {
        Selenide.open("/projects");
        return this;
    }

    public ProjectPage deleteProject(String projectName) {
        $(byText(projectName))
                .ancestor("tr")
                .find("button[aria-label='Open action menu']")
                .click();
        $("[data-testid=remove]").click();
        $x("//span[text()='Delete project']").click();
        return this;
    }

    @Override
    public ProjectPage isPageOpened() {
        PROJECT_ITEM.shouldBe(visible);
        return this;
    }
}
