package cookiesAndHeaders;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class LogDemo {
    @Test
    void  logDemo(){
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")

                .then()
//                .log().all();
 //               .log().body();
                .log().cookies();
    }
}
