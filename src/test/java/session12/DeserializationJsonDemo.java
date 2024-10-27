package session12;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeserializationJsonDemo {

    @Test
    public void createUser() {
        //create Request Specification
        RequestSpecification requestSpec = RestAssured.given();

        //Specify url
        requestSpec.baseUri("https://reqres.in/");
        requestSpec.basePath("api/users");

        //Create Json Data
        JSONObject jsonData = new JSONObject();
        jsonData.put("name", "Tester");
        jsonData.put("job", "Tester");

        Response response = requestSpec.contentType(ContentType.JSON).body(jsonData.toJSONString()).post();
        ResponseBody responseBody = response.getBody();


        //Deserialization responsebody i.e json response body to class object

        JsonPostRequestResponse responseClass = responseBody.as(JsonPostRequestResponse.class);


        Assert.assertEquals(responseClass.name,"Tester","Check for Name ");
        Assert.assertEquals(responseClass.job,"Tester","Check for Job ");




    }

}
