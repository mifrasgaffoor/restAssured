package cookiesAndHeaders;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class HeadersDemo {


    // @Test
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


    @Test

    void  getHeader(){

        Response rs = given()
                .when()
                .get("https://www.google.com/");

        // Sinlge Header value
        String headerValue =  rs.getHeader("Content-Type");
        System.out.println(headerValue);
        
        // Get all header info
        Headers myHeaders = rs.getHeaders();
        for (Header h:myHeaders) {
            System.out.println(h.getName() + h.getValue());
        }
        

    }
    
    
    
    


}
