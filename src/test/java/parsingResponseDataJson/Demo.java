package parsingResponseDataJson;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Demo {



    // Apprach O1
    // @Test
    void testJson() {
        given()
                .contentType("application/json") // Corrected content type

                .when()
                .get("http://localhost:3000/books")

                .then()
                .log().all()
                .statusCode(200)
                .body("[2].author", equalTo("F. Scott Fitzgerald")) // Check JSON path
                .header("Content-Type", equalTo("application/json"))
                .log().all();  // Logs all details for better debugging
    }



    // Approch -2


    @Test
    void testJson2() throws JSONException {
        // Get the response from the server
        Response rs = given()
                .contentType("application/json")
                .when()
                .get("http://localhost:3000/books");

        // Assert the status code is 200
        Assert.assertEquals(rs.getStatusCode(), 200);

        // Assert the content type header
        Assert.assertEquals(rs.getHeader("Content-Type"), "application/json");

        // Fetch the title of the 3rd book (index 2)
        String title = rs.jsonPath().get("[2].title").toString();
        Assert.assertEquals(title, "The Great Gatsby");

        // Parse the response as a JSONArray
        JSONArray jsonArray = new JSONArray(rs.asString());

        // Loop through the array to print book titles
        for (int i = 0; i < jsonArray.length(); i++) {
            String bookTitle = jsonArray.getJSONObject(i).getString("title");
            System.out.println(bookTitle); // Print each book title
        }
    }


}
