package session15;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class JsonObjectUsingJavaMapDemo {

    @Test
    public void createUser(){
        /*{
           "firstname":"Ishu",
           "lastname":"Mathur",
           "age":24,
           "salary":20000,
           "isMarried":true,
           "Hobbies":["Music","Computer","Games"].
           "TechSkill":{
                "Programming":"Java",
                "WebAutomation":"Selenium",
                "APITesting":"RestAssured"
           }
        }*/


        HashMap<String,Object> userData = new HashMap<String, Object>();

        userData.put("firstname","Ishu");
        userData.put("lastname","Mathur");
        userData.put("age",24);
        userData.put("salary",20000);
        userData.put("isMarried",false);

        ArrayList<String> hobbies = new ArrayList<String>();
        hobbies.add("Music");
        hobbies.add("Computer");
        hobbies.add("Games");
        userData.put("Hobbies",hobbies);

        HashMap<String,String> techSkill = new HashMap<String, String>();
        techSkill.put("Programming","Java");
        techSkill.put("WebAutomation","Selenium");
        techSkill.put("APITesting","RestAssured");


        userData.put("TechSkills",techSkill);


        RequestSpecification requestSpec = RestAssured.given();

        requestSpec.baseUri("https://reqres.in/");
        requestSpec.basePath("api/users");

        Response response = requestSpec.contentType(ContentType.JSON).body(userData).post();
        System.out.println(response.prettyPrint());



    }
}
