package session13;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class QueryRequestSpecification {

    @Test
    public void createUser(){

        RequestSpecification resquestSpec = RestAssured.given();

        resquestSpec.baseUri("https://reqres.in/");
        resquestSpec.basePath("api/users");

        JSONObject jsondata = new JSONObject();

        jsondata.put("name","Tester");
        jsondata.put("job","Tester");

        resquestSpec.contentType(ContentType.JSON).body(jsondata.toJSONString());

        //Query Details from requestSpecification

        QueryableRequestSpecification queryRequest = SpecificationQuerier.query(resquestSpec);

        //Get Url Details

        String retrieveUri = queryRequest.getURI();
        System.out.println(retrieveUri);

        //Get Base Path
        String retrievepath = queryRequest.getBasePath();
        System.out.println(retrievepath);

        //Get Body

        String retrievebody = queryRequest.getBody();
        System.out.println(retrievebody);


        //Get Header
        Headers header = queryRequest.getHeaders();

        for(Header h: header){
            System.out.println("Name :  " + h.getName()+"\t Value : "+h.getValue());
        }

    }
}
