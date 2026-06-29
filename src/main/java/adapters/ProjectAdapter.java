package adapters;


import models.project.ProjectResponse;
import models.project.Projectrequest;


import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ProjectAdapter extends BaseAdapter{

   // static Gson gson = new Gson();

    public static ProjectResponse createProject(Projectrequest rq) {
        return  given()
        .spec(spec)
                .body(rq)
                .log().all()
                .when()
                .post("/project")
                .then()
                .log().all()
                .body(matchesJsonSchemaInClasspath("schemas/create_project_schema.json"))
                .statusCode(200)
                .extract()
                .as(ProjectResponse.class);
    }

    public static void deleteProject(String code) {
        given()
                .spec(spec)
                .pathParams("code", code)
                .log().all()
                .when()
                .delete("/delete/{code}")
                .then()
                .log().all()
                .spec(ok200);
    }
}
