package cookiesAndHeaders;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class HeadersDemo {


    @Test

    void testHeader(){
        given()

                .when()
                .get("https://www.google.com/")

                .then()
                .statusCode(200)
                .header("Content-Type" ,"text/html; charset=ISO-8859-1")
                .and()
                .header("Expires","-1")
                .and()
                .header("Server" ,"gws")
                .log().all();

    }



}
