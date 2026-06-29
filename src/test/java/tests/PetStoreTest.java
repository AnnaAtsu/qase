package tests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class PetStoreTest {


    @Test
    public void checkAddPetWithoutBody() {
        given()
                .contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2")
                .body("")
                .log().all()
                .when()
                .post("/pet")
                .then()
                .log().all()
                .statusCode(405)
                .body("code", equalTo(405))
                .body("type", equalTo("unknown"))
                .body("message", equalTo("no data"));
    }

    @Test
    public void checkCRUD() {
        long id =
        given()
                .contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2")
                .body("  \"category\": {\n" +
                        "    \"id\": 10,\n" +
                        "    \"name\": \"Cat\"\n" +
                        "  },\n" +
                        "  \"name\": \"Tomas\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"www.onliner.by\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 9,\n" +
                        "      \"name\": \"street\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .log().all()
                .when()
                .post("/pet")
                .then()
                .log().all()
                .statusCode(405)
                .body("id", notNullValue())
                .body("categoty.name", equalTo("Cat"))
                .body("name", equalTo("Tomas"))

                .extract()
                .path("id");


        given()
                .contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2")
                .pathParams("id", id)
                .log().all()
                .when()
                .get("/pet/{id}")
                .then()
                .statusCode(200);


    }
}
