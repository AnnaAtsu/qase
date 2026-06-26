package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class OnlinerTest {


    @Test
    public void checkOnlinerWeather() {
        when()
                .get("https://profile.onliner.by/sdapi/pododa/api/now")
                .then()
                .log().all()
                .statusCode(200)
                .body("city", equalTo("Минске"));
    }
}
