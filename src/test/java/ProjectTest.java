import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class ProjectTest extends BaseTest {

    @Test
    public void checkCreateProject() {
        loginPage.openPage();
        loginPage.login("anna.atsulus@gmail.com", "atsulus1988");
        $(byText("Create new project")).click();
        $("#project-name").setValue("TMSkills");
        $("#project-code").setValue("TMS01");
        $(byText("Create project")).click();
        open("/projects");
        deleteProject("TMS02");
    }

    public void deleteProject(String projectName) {
        loginPage.openPage();
        loginPage.login("anna.atsulus@gmail.com", "atsulus1988");
        $(byText(projectName))
                .ancestor("tr")
                .find("button[aria=label='Open action menu']")
                .click();
        $("[data-testid=remove]").click();
        $x("//span[text()='Delete project']").click();

    }
}
