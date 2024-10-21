package apiChaining;

import com.github.javafaker.Faker;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class UpdateUser {


    @Test
    void  updateUserReq(ITestContext context) throws JSONException {
        JSONObject data  = new JSONObject();
        Faker faker = new Faker();
        data.put("name",faker.idNumber());
        data.put("gender","female");
        data.put("email",faker.internet().emailAddress());
        data.put("status","inactive");
        String token = "63b79f7bf4fe46f0dcb88a138f3cc3a7c29145797a7b99137ae9fe61ee0dfe7b";
        int id = (Integer) context.getAttribute("uid");
        given()
                .header("Authorization", "Bearer "+token)
                .body(data.toString())
                .when()
                .pathParams("id",id)
                .put("https://gorest.co.in/public/v2/users/{id}")
                .then()
                .statusCode(200)
                .log().all();

    }
}
