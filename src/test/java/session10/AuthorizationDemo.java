package session10;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class AuthorizationDemo {

    //https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}

    @Test
    public void ApiKeyAuthorization(){

        RequestSpecification requestSpec = RestAssured.given();

        requestSpec.baseUri("https://api.openweathermap.org");
        requestSpec.basePath("/data/2.5/weather");
        requestSpec.queryParam("q", "delhi").queryParam("appid","f57bcd49569ff955e89bb1fb61a0c134");
        Response response= requestSpec.get();
        System.out.println(response.body().asString());

    }
}
