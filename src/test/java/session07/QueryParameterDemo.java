package session07;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class QueryParameterDemo {

    @Test
    public void filterData(){
        RequestSpecification requestSpec = RestAssured.given();

        requestSpec.baseUri("https://reqres.in/");
        requestSpec.basePath("api/users/");
        requestSpec.queryParam("page",2).queryParam("id",7);

        Response response = requestSpec.get();

        JsonPath jsonPathview = response.jsonPath();
        String firstName= jsonPathview.get("data.first_name");
        System.out.println(firstName);
        System.out.println(response.getBody().asString());

    }
}
