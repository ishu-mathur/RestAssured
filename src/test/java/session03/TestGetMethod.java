package session03;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class TestGetMethod {
    @Test
    public void Test01() {
        Response res = get("https://reqres.in/api/users/?page=2");
        System.out.println("Response :  " + res.getBody());
        System.out.println("Statue Code :  " + res.getStatusCode());
        System.out.println("Response Header  :   " + res.getHeader("Content-Type"));

        int statuscode = res.getStatusCode();
        Assert.assertEquals(200, statuscode);
    }

    @Test
    public void test02() {
        //Given when then

        baseURI = "https://reqres.in/api/users/";


        given().queryParam("page", "2").when().get().then().statusCode(200);
    }

}
