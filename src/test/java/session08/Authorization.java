package session08;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Authorization {

    @Test
    public void BasicAuth(){
        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.baseUri("https://postman-echo.com/");
        requestSpec.basePath("/basic-auth");
    }
}
