package session03;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TestPostMethod {
    @Test
    public void test01(){
        baseURI ="https://reqres.in/api/users";
        JSONObject jsondata = new JSONObject();
        jsondata.put("name","Rahul");
        jsondata.put("job","TeamLead");
        //186
        given().header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .body(jsondata.toJSONString())
                .when().post()
                .then().statusCode(201).log().body();

    }

}
