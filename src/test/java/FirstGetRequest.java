import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class FirstGetRequest {
    //https://reqres.in/api/users/2

    @Test
    void testcase01(){
        Response res = RestAssured.get("https://reqres.in/api/users/2");
        System.out.println(res.asString());
        System.out.println(res.getStatusCode());
        System.out.println(res.getContentType());
        System.out.println(res.getHeaders().asList());
    }
}
