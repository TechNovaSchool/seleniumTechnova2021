package api.tests;

import Utilities.APIUtillities;
import api.API_models.Fields;
import api.API_models.Record;
import api.API_models.RequestBody;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class APIUtilTest {

    @Test
    public void getRecord() {
        String resource = ""; // this string is empty cause out airtable endpoint has no additional resource
        APIUtillities.hitGET(resource);
        System.out.println(APIUtillities.getResponseBody().getRecords().get(1).getFields().getFirstname());
    }

    @Test
    public void postRecord() {
        String resource = "";

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

        APIUtillities.hitPOST(resource,requestBody );

    }

    @Test
    public void updateRecord() {
        String resource = "";

        Fields fields = new Fields();
        fields.setFirstname("James");
        fields.setLastname("LeBron");
        fields.setPhone("777-999-7777");
        fields.setAddress("999 Test this API");

        Record record = new Record();
        record.setFields(fields);
        record.setId("recDTTzYDhugTG7pX");
        List<Record> records = new ArrayList<>();
        records.add(record);

        RequestBody requestBody = new RequestBody();
        requestBody.setRecords(records);

        APIUtillities.hitPATCH(resource,requestBody);
    }

    @Test
    public void deleteRecord() {
        String resource = "";
        APIUtillities.hitDELETE(resource, "rec0xqYu5ng0HaGmw");
    }






}
