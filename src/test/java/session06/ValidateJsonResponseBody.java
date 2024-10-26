package session06;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ValidateJsonResponseBody {

    @Test
    public void UserListResponseBody() {
        RequestSpecification resquestSpec = RestAssured.given();
        resquestSpec.baseUri("https://reqres.in/");
        resquestSpec.basePath("api/users/?page=2");

        Response response = resquestSpec.get();

        ResponseBody responsebody = response.body();

        String responseString = responsebody.asString();
        System.out.println(responseString);

        JsonPath jsonPathView = response.jsonPath();

        List<String> emails = jsonPathView.getList("data.email");
        List<String> ids = jsonPathView.getList("data.id");
        String support =  jsonPathView.get("support.url");
        System.out.println(support);
        int page = jsonPathView.get("per_page");
        System.out.println("First Name:  "+emails);
        System.out.println("Id :  "+ ids);
        System.out.println("Per Page Number:  "+page);



    }
}
