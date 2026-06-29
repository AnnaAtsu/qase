package tests;
import adapters.ProjectAdapter;
import models.project.ProjectResponse;
import models.project.Projectrequest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static adapters.ProjectAdapter.createProject;
import static io.restassured.RestAssured.given;

public class ProjectAPITest {

    private final String CODE = "qa";
    @Test
    public void checkcreateProject() {
        Projectrequest rq = Projectrequest.builder()
                .title("qa23")
                .code("348")
                .description("fgddfgdf")
                .access("all")
                .group("test")
                .build();
       ProjectResponse rs = createProject(rq);
        Assert.assertTrue(rs.status);
        Assert.assertEquals(rs.result.code, "348");
    }


    @AfterMethod
    public void deleteProject() {
        ProjectAdapter.deleteProject(CODE);
    }

}
