package session09;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class AuthorizationDemo {
    @Test
    public void BearerToken(){

        RequestSpecification requestSpec = RestAssured.given();

        requestSpec.baseUri("");
        requestSpec.basePath("");
        //Bearer Token
        String AuthToken = "jhsdhfgjasfasa";
        requestSpec.header("Authorization",AuthToken).contentType(ContentType.JSON);
        Response response = requestSpec.post();
    }
}
