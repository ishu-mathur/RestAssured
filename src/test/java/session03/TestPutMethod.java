package session03;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TestPutMethod {
    @Test
    public void test01() {
        baseURI = "https://reqres.in/api/users/186";
        JSONObject jsondata = new JSONObject();
        jsondata.put("name", "Pulkit");
        jsondata.put("job", "Tester");
        given().header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body(jsondata.toJSONString())
                .when().put()
                .then().statusCode(200).log().body();

    }
}
