package session14;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class ValidateXMLResponse {

    @Test
    public void addPet(){

        String json = "{\n" +
                "  \"id\": 0,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
        //Create Request Specification

        RequestSpecification requestSpec = RestAssured.given();

        //Set Url
        requestSpec.baseUri("https://petstore.swagger.io/");
        requestSpec.basePath("v2/pet");


         Response response= requestSpec.header("accept","application/xml").
                header("Content-Type","application/json").
                body(json).post();


        System.out.println(response.prettyPrint());

        response.then().body("Pet.name", Matchers.equalTo("doggie"));

        XmlPath xmlpathview = new XmlPath(response.asString());

        String name = xmlpathview.get("Pet.name");
        System.out.println("Name of Dog :  " +name);
    }
}
