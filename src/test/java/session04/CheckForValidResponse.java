package session04;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckForValidResponse {
    @Test
    public void GetSingleUser(){
        RequestSpecification requestspec = RestAssured.given();
        requestspec.baseUri("https://reqres.in/");
        requestspec.basePath("api/users/2");

        Response res = requestspec.get();

        //Validate using Assert

        int status = res.getStatusCode();
        String statusline = res.getStatusLine();

        Assert.assertEquals(status,200,"Check Request Status Code ");

        Assert.assertEquals(statusline,"HTTP/1.1 200 OK","Check Status Line ");

        //Validate using Validatable

        ValidatableResponse validateRes = res.then();

        validateRes.statusCode(200);
        validateRes.statusLine("HTTP/1.1 200 OK");

    }


}
