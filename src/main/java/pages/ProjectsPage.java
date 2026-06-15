package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.Assert.assertEquals;

@Log4j2
public class ProjectsPage extends BasePage{
    private final String EXPECTED_TITLE = "Projects";
    private final SelenideElement PROJECT_ITEMS = $x("//tbody");


    public ProjectsPage openPage() {
        log.info("Открытие страницы проектов");
        Selenide.open("/projects");
        return this;
    }

    public ProjectsPage verifyProjectInList(String projectName) {
        log.info("Проверка, есть ли на странице проект '{}'", projectName);
        $(byText(projectName)).shouldBe(visible);
        return this;
    }

    public ProjectsPage checkTitleProjectsPage() {
        log.info("Проверка заголовка страницы проектов");
        String actualTitle = $("h1").shouldBe(visible).getText();
        assertEquals(actualTitle, EXPECTED_TITLE);
        return this;
    }

    @Override
    public ProjectsPage isPageOpened() {
        log.info("Проверка, открыта ли страница проектов");
        PROJECT_ITEMS.shouldBe(visible);
        return this;
    }
}
