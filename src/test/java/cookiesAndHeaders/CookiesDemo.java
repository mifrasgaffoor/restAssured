package cookiesAndHeaders;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class CookiesDemo {


    // @Test
    void cookiesDemo(){
        given()

                .when()
                .get("https://www.google.com/")

                .then()
                .cookie("AEC","AVYB7cptC0kQz8Pbp2K-UoeD3fOA9OHCUSX5Tuk3oXVlmfOGoCztAYIKPg")
                .statusCode(200)
                .log().all();
    }


    @Test
    void getCookie(){

        Response rs =  given()
                .when()
                .get("https://www.google.com/");

        String cookieValue =  rs.getCookie("AEC");
        System.out.println("Cookie ====> " + cookieValue);


        Map<String,String> cookie_val = rs.getCookies();
        System.out.println(cookie_val.keySet());

        for (String k :cookie_val.keySet()){
            String cookie_value = rs.getCookie(k);
            System.out.println(k + " " + cookie_value);
        }




    }




}
