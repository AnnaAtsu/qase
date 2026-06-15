package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import dto.Project;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.url;
import static dto.ProjectFactory.getProject;
import static org.testng.Assert.assertTrue;

@Log4j2
public class ProjectPage extends BasePage {
    private final SelenideElement PROJECT_ITEM = $x("//div/a");
    private final SelenideElement PROJECT_NAME = $("#project-name");
    private final SelenideElement PROJECT_CODE = $("#project-code");
    private final SelenideElement DESCRIPTION_AREA = $("#description-area");
    private final SelenideElement REMOVE_BUTTON = $("[data-testid=remove]");
    private final SelenideElement DELETE_PROJECT_BUTTON = $("//span[text()='Delete project']");
    private final String OPEN_ACTION_MENU_BUTTON = "button[aria-label='Open action menu']";

    public ProjectPage createProject(String projectName, String projectCode) {
        log.info("Создание проекта");
        $(byText("Create new project")).click();
        PROJECT_NAME.setValue(projectName);
        PROJECT_CODE.setValue(projectCode);
        DESCRIPTION_AREA.setValue("My description");
        return this;
    }

    public ProjectPage verifyProjectUrl(String projectCode) {
        log.info("Верификация урла страницы проекта");
        assertTrue(url().contains("/project/" + projectCode));
        return this;
    }

    public ProjectPage clickButtonCreateProject() {
        log.info("Нажатие на кнопку создания проекта");
        $(byText("Create project")).click();
        return this;
    }

    public ProjectPage openProjectPage() {
        log.info("Открыть страницу проектов");
        Selenide.open("/projects");
        return this;
    }

    public ProjectPage deleteProject(String projectName) {
        log.info("Удаление проекта по имени '{}'", projectName);
        $(byText(projectName))
                .ancestor("tr")
                .find(OPEN_ACTION_MENU_BUTTON)
                .click();
        REMOVE_BUTTON.click();
        DELETE_PROJECT_BUTTON.click();
        return this;
    }

    @Override
    public ProjectPage isPageOpened() {
        log.info("Проверка, открыта ли страница проекта");
        PROJECT_ITEM.shouldBe(visible);
        return this;
    }

    Project project = getProject();

    public ProjectPage createProjectWithGeneratedData(Project project) {
        log.info("Создание проекта");
        $(byText("Create new project")).click();
        PROJECT_NAME.setValue(project.getProjectName());
        PROJECT_CODE.setValue(project.getProjectCode());
        DESCRIPTION_AREA.setValue(project.getDescription());
        return this;
    }
}
