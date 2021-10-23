package api.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstApiTest {
    //1. Hit an endpoint or hit an api
    //2. What type of https requests (method), Endpoint,Body,Header


    @Test
    public void getList() {

        Response response = RestAssured.get("https://simple-books-api.glitch.me/books");

        System.out.println(response.statusCode());
       System.out.println(response.asString());
        Assert.assertEquals(response.statusCode(), 200, "Test Failed");
        //("Test failed", 200, response.statusCode())
        JsonPath jsonPath = response.jsonPath();
        int size = jsonPath.getList("").size();
        System.out.println(size);
        String str = jsonPath.get("[1].name");
//        System.out.println(str);
        int counterFiction = 0;

//        for ( )

        for (int i = 0; i < size; i++) {
            String names = jsonPath.get("["+ i +"].name");
            System.out.println(names);
            Assert.assertTrue(names != null,"["+ i +"]");
        }
    }

    @Test
    public void authorizationTest() {
        Response response = RestAssured.given()
                .header("Authorization","Bearer " +"5f0181b5de128c3b6c79d28bfca1c3f2bf9b12f526330c82a75d10288ae15425")
                .get("https://simple-books-api.glitch.me/orders");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
    }

    @Test
    public void authorizationTestAirtable() {
        Response response = RestAssured.given()
                .header("Authorization","Bearer " +"keyUciDKN0atCXT7w")
                .urlEncodingEnabled(false)
                .get("https://api.airtable.com/v0/app14gUrLadaStkxx/Table%201");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
    }








}
