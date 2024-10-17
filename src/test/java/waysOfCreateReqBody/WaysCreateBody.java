package waysOfCreateReqBody;

import netscape.javascript.JSObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

// post using hashmap
public class WaysCreateBody {

    @Test(priority = 1)
    // post using hashmap
    void createStudent(){
        HashMap data =  new HashMap();
        data.put("name" , "NewName");
        data.put("age" ,22);
        String[] courseArr ={"Mathematics", "Computer Science"};
        data.put("courses",courseArr);

        given()
                         .contentType("application/json")
                         .body(data)

        .when()
                        .post("http://localhost:3000/students")

        .then()
                .statusCode(201)
                .body("name" ,equalTo("NewName"))
                .body("age" ,equalTo(22))
                .body("courses[0]" ,equalTo("Mathematics"))
                .body("courses[1]" ,equalTo("Computer Science"))
                .header("Content-Type","application/json")
                .log().all();



    }

    // post using org.json
    //@Test(priority = 1)
    void createStudentUsingJson() throws JSONException {

        JSONObject data = new JSONObject();
        data.put("name", "Kamla");
        data.put("age", 22);
        String[] courseArr = {"dbms", "OOP", "React"};
        data.put("courses", courseArr); // Use 'courses' here, not 'courseArr'

        given()
                .contentType("application/json")
                .body(data.toString())

                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name", equalTo("Kamla"))
                .body("age", equalTo(22))
                .body("courses[0]", equalTo("dbms"))  // Fixed array reference
                .body("courses[1]", equalTo("OOP"))     // Fixed array reference
                .body("courses[2]", equalTo("React"))  // Fixed array reference
                .header("Content-Type", equalTo("application/json"))  // Corrected Content-Type validation
                .log().all();
    }

    // @Test(priority = 1)
    void createStudentUsingPojo(){

        Pojo_PostReq data = new Pojo_PostReq();
        data.setName("Mira");
        data.setAge(34);
        String[] courses ={"IT", "PM"};
        data.setCourseArr(courses);

        given()
                .contentType("application/json")
                .body(data)

                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name" ,equalTo("Mira"))
                .body("age" ,equalTo(34))
                .body("courses[0]" ,equalTo("IT"))
                .body("courses[1]" ,equalTo("PM"))
                .header("Content-Type","application/json")
                .log().all();

    }

    // void using json file external

   // @Test(priority = 1)
    void createJsonExternalFile() throws FileNotFoundException, JSONException {


        File f =  new File(".\\body.json");
        FileReader fr =  new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject jo = new JSONObject(jt);


        given()
                .contentType("application/json")
                .body(jo.toString())

                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name" ,equalTo("NewName"))
                .body("age" ,equalTo(23))
                .body("courses[0]" ,equalTo("Mathematics"))
                .body("courses[1]" ,equalTo("AI/ML"))
                .header("Content-Type","application/json")
                .log().all();
    }

}
