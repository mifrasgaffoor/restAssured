package apiChaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DeleteUser {


    @Test
    void deleteUserReq(ITestContext context) {

        String token = "63b79f7bf4fe46f0dcb88a138f3cc3a7c29145797a7b99137ae9fe61ee0dfe7b";
        int id = (Integer) context.getAttribute("uid");

        given()
                .header("Authorization", "Bearer " + token)
                .pathParams("id", id)
                .when()
                .delete("https://gorest.co.in/public/v2/users/{id}")
                .then()
                .statusCode(204)
                .log().all();


    }
}
