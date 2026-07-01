package adapters;

import models.project.Caserequest;
import models.project.CaseResponse;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class CaseAdapter extends BaseAdapter{


    public static CaseResponse createCase(Caserequest cr) {
        return  given()
                .spec(spec)
                .body(cr)
                .log().all()
                .when()
                .post("/case")
                .then()
                .log().all()
                .body(matchesJsonSchemaInClasspath("schemas/create_case_schema.json"))
                .statusCode(200)
                .extract()
                .as(CaseResponse.class);
    }

    public static void deleteCase(String code, int id) {
        given()
                .spec(spec)
                .pathParams("code", code)
                .pathParams("id", id)
                .log().all()
                .when()
                .delete("/delete/{code}/{id}")
                .then()
                .log().all()
                .spec(ok200);
    }


}
