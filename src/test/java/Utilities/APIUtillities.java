package Utilities;

import api.API_models.RequestBody;
import api.API_models.ResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class APIUtillities {
    //CRUD operations
    //GET, POST, Patch, DELETE

    private static ResponseBody responseBody;
    private static ObjectMapper objectMapper;

    public static void hitGET(String resource) {
        String uri = Config.getProperty("baseURL" + resource);
        Response response = RestAssured.given().header("Authorization", Config.getProperty("token"))
                .urlEncodingEnabled(false)
                .get(uri);
        System.out.println("Status Code: " + response.statusCode());
//        System.out.println(response.asString());

         objectMapper = new ObjectMapper();

        try {
            responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static ResponseBody getResponseBody() {
        return responseBody;
    }


    public static void hitPOST(String resource, RequestBody body ) {
        String uri = Config.getProperty("baseURL" + resource);

        ObjectMapper objectMapper = new ObjectMapper();
        String bodyJson ="";
        try {
             bodyJson = objectMapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Response response = RestAssured.given().header("Authorization", Config.getProperty("token"))
                .urlEncodingEnabled(false)
                .contentType(ContentType.JSON)
                .body(bodyJson)
                .post(uri);
        System.out.println("Status Code: " + response.statusCode());
        //        System.out.println(response.asString());
        try{
            responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);
        }
        catch (Exception j){
            j.printStackTrace();
        }
    }

    public static void hitPATCH(String resource, RequestBody body ) {
        String uri = Config.getProperty("baseURL" + resource);

        ObjectMapper objectMapper = new ObjectMapper();
        String bodyJson ="";
        try {
            bodyJson = objectMapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Response response = RestAssured.given().header("Authorization", Config.getProperty("token"))
                .urlEncodingEnabled(false)
                .contentType(ContentType.JSON)
                .body(bodyJson)
                .patch(uri);
        System.out.println("Status Code: " + response.statusCode());
        //        System.out.println(response.asString());
        try{
            responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);
        }
        catch (Exception j){
            j.printStackTrace();
        }
    }

    public static void hitDELETE(String resource, String recordID) {
        String uri = Config.getProperty("baseURL" + resource);
        System.out.println(uri);
        Response response = RestAssured.given().header("Authorization", Config.getProperty("token"))
                .urlEncodingEnabled(false)
                .queryParam("records[]", recordID)
                .delete(uri);
        System.out.println("Status Code: " + response.statusCode());
//        System.out.println(response.asString());

        objectMapper = new ObjectMapper();

        try {
            responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }




}
