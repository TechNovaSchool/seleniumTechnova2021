package api.tests;

import api.API_models.Fields;
import api.API_models.Record;
import api.API_models.RequestBody;
import api.API_models.ResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.internal.http.Status;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AirtableTests {
    static String recordID;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test (priority = 1)
    public void getRecord() throws Exception {
        Response response = RestAssured.given()
                .header("Authorization","Bearer " +"keyUciDKN0atCXT7w")
                .urlEncodingEnabled(false)
                .get("https://api.airtable.com/v0/app14gUrLadaStkxx/Table%201");

        System.out.println(response.statusCode());
        System.out.println(response.asString());

        ObjectMapper objectMapper = new ObjectMapper();

        ResponseBody rb = objectMapper.readValue(response.asString(), ResponseBody.class);
        for (Record elements : rb.getRecords()) {
            if(elements.getFields().getLastname().startsWith("W")) {
                System.out.println(elements.getFields().getFirstname() + " "
                        + elements.getFields().getLastname()  + " "
                        + elements.getFields().getPhone() + " "
                        + elements.getFields().getAddress());
            }
        }
    }


    @Test (priority = 2)
    public void postRecords() throws Exception{
        Fields fields = new Fields();
        fields.setFirstname("James");
        fields.setLastname("LeBron");
        fields.setPhone("777-999-7777");
        fields.setAddress("999 Test this API");

        Record record = new Record();
        record.setFields(fields);
        List<Record> records = new ArrayList<>();
        records.add(record);

        RequestBody requestBody = new RequestBody();
        requestBody.setRecords(records);

        Response response = RestAssured.given()
                .header("Authorization","Bearer keyUciDKN0atCXT7w")
                .urlEncodingEnabled(false).contentType("application/json")
                .body(requestBody)
                .post("https://api.airtable.com/v0/app14gUrLadaStkxx/Table%201");

        Assert.assertEquals(response.getStatusCode(), 200);
        ResponseBody rb = objectMapper.readValue(response.asString(), ResponseBody.class);
        System.out.println(rb.getRecords().get(0).getId());
        recordID = rb.getRecords().get(0).getId();
    }


    @Test (priority = 3)
    public void UpdateRecord(){
        Fields fields = new Fields();
        fields.setFirstname("Safarbeg");
        fields.setLastname("Like API Testing");
        fields.setPhone("777-999-7777");
        fields.setAddress("999 Test this API");

        Record record = new Record();
        record.setFields(fields);
        record.setId(recordID);
        List<Record> records = new ArrayList<>();
        records.add(record);

        RequestBody requestBody = new RequestBody();
        requestBody.setRecords(records);

        Response response = RestAssured.given()
                .header("Authorization","Bearer keyUciDKN0atCXT7w")
                .urlEncodingEnabled(false).contentType("application/json")
                .body(requestBody)
                .patch("https://api.airtable.com/v0/app14gUrLadaStkxx/Table%201");

        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test (priority = 4)
    public void deleteRecord() throws Exception {
        System.out.println("record id " + recordID);
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + "keyUciDKN0atCXT7w")
                .urlEncodingEnabled(false).queryParam("records[]", recordID)
                .delete("https://api.airtable.com/v0/app14gUrLadaStkxx/Table%201");

        System.out.println(response.statusCode());
        System.out.println(response.asString());

        ObjectMapper objectMapper = new ObjectMapper();

        ResponseBody rb = objectMapper.readValue(response.asString(), ResponseBody.class);
    }
}
