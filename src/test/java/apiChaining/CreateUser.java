package apiChaining;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CreateUser {

    @Test()
    void createUserReq(ITestContext context) throws JSONException {
        String token = "63b79f7bf4fe46f0dcb88a138f3cc3a7c29145797a7b99137ae9fe61ee0dfe7b";
        Faker faker = new Faker();
        JSONObject data  = new JSONObject();
        data.put("name",faker.idNumber());
        data.put("gender","male");
        data.put("email",faker.internet().emailAddress());
        data.put("status","active");

      int  id=   given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer "+token)
                .body(data.toString())
                .when()
                .post("https://gorest.co.in/public/v2/users")
              .jsonPath().getInt("id");

        System.out.println("ID : " + id);

        context.setAttribute("uid",id);




    }
}
