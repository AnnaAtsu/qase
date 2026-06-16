package tests;

import dto.Project;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import static dict.Elements.PASSWORD;
import static dict.Elements.USER;

public class ProjectTest extends BaseTest {

    private static final String PROJECT_NAME = "TMS01";
    private static final String PROJECT_CODE = "TMS01";

    @Test(description = "Проверка создания проекта с хард данными")
    public void checkCreateProject() {
        loginPage.openPage()
                 .isPageOpened()
                 .login(USER, PASSWORD);
        projectPage.isPageOpened()
                   .createProject(PROJECT_NAME, PROJECT_CODE)
                   .clickButtonCreateProject()
                   .verifyProjectUrl(PROJECT_CODE);
        projectsPage.openPage()
                    .isPageOpened()
                    .checkTitleProjectsPage()
                    .verifyProjectInList(PROJECT_NAME);
        checkDeleteProject();
    }

    @Test(description = "Проверка удаления проекта с хард данными")
    public void checkDeleteProject() {
        loginPage.openPage()
                 .isPageOpened()
                 .login(USER, PASSWORD);
        projectPage.createProject(PROJECT_NAME, PROJECT_CODE)
                   .clickButtonCreateProject();
        projectsPage.openPage()
                    .isPageOpened();
        projectPage.deleteProject(PROJECT_NAME);
        projectsPage.verifyProjectInList(PROJECT_NAME);
    }

    @Test(description = "Проверка создания проекта с генерированными данными")
    public void checkCreateProject(Project project) {
        loginPage.openPage()
                .isPageOpened()
                .login(USER, PASSWORD);
        projectPage.isPageOpened()
                .createProject(project.getProjectName(), project.getProjectCode())
                .clickButtonCreateProject()
                .verifyProjectUrl(project.getProjectCode());
        projectsPage.openPage()
                .isPageOpened()
                .checkTitleProjectsPage()
                .verifyProjectInList(project.getProjectName());
        checkDeleteProject();
    }

    @Test(description = "Проверка удаления проекта с генерированными данными")
    public void checkDeleteProjectWithGeneratedData(Project project) {
        loginPage.openPage()
                .isPageOpened()
                .login(USER, PASSWORD);
        projectPage.createProject(project.getProjectName(), project.getProjectCode())
                .clickButtonCreateProject();
        projectsPage.openPage()
                .isPageOpened();
        projectPage.deleteProject(project.getProjectName());
        projectsPage.verifyProjectInList(project.getProjectName());
    }
}
