package session08;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Authorization {

    @Test
    public void BasicAuth() {
        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.baseUri("https://postman-echo.com/");
        requestSpec.basePath("/basic-auth");

        //performed get request with basic auth with non-preemptive
//        Response response = requestSpec.auth().basic("postman","password").get();

        //performed get request with basic auth with preemptive
        Response response = requestSpec.auth().preemptive().basic("postman", "password").get();

        System.out.println("Response Status Line :  " + response.getStatusLine());
    }

    @Test
    public void DigestAuth() {

        RequestSpecification requestSpec = RestAssured.given();

        requestSpec.baseUri("https://httpbin.org");
        requestSpec.basePath("/digest-auth/undefined/tester/tester");

        Response response = requestSpec.auth().digest("tester","tester").get();
//        Response response = requestSpec.get();
        System.out.println(response.statusLine());
    }


}
