import org.testng.annotations.Test;

import static dict.Elements.PASSWORD;
import static dict.Elements.USER;

public class ProjectTest extends BaseTest {

    private static final String PROJECT_NAME = "TMS01";
    private static final String PROJECT_CODE = "TMS01";

    @Test(description = "Проверка создания проекта")
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
    }

    @Test(description = "Проверка удаления проекта")
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
}
