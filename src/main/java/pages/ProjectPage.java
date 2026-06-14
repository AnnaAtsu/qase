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

    public ProjectPage createProject(String projectName, String projectCode) {
        log.info("Создание проекта");
        $(byText("Create new project")).click();
        $("#project-name").setValue(projectName);
        $("#project-code").setValue(projectCode);
        $("#description-area").setValue("My description");
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
                .find("button[aria-label='Open action menu']")
                .click();
        $("[data-testid=remove]").click();
        $x("//span[text()='Delete project']").click();
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
        $("#project-name").setValue(project.getProjectName());
        $("#project-code").setValue(project.getProjectCode());
        $("#description-area").setValue(project.getDescription());
        return this;
    }
}
