package tests;

import adapters.CaseAdapter;
import adapters.ProjectAdapter;
import models.project.CaseResponse;
import models.project.Caserequest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static adapters.CaseAdapter.createCase;

public class CaseAPITest {
    private final String CODE = "AT";
    private int caseId;
        @Test
    public void checkcreateCase() {

        Caserequest cr = Caserequest.builder()
                .title("qa343")
                .code("AT")
                .description("Description for a created test")
                .is_flaky(0)
                .severity(2)
                .priority(2)
                .build();
        CaseResponse cs = createCase(cr);

        Assert.assertTrue(cs.status);
        Assert.assertEquals(cs.result.code, "AT");
        Assert.assertNotNull(cs.id);
        caseId = cs.id.id;
    }

    @AfterMethod
    public void deleteCase() {
       CaseAdapter.deleteCase(CODE, caseId);
    }
}
