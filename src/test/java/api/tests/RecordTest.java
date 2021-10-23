package api.tests;

import Utilities.Config;
import api.API_models.Fields;
import api.API_models.books.OrderBook;
import api.API_models.books.Records123;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
public class RecordTest {

    @Test
    public void createJsonObject() throws Exception {
        Records123 records  = new Records123();

        records.setId("igigdsf43");
        records.setBookId(22);
        records.setCustomerName("Jimmy Jhon");
        records.setQuantity(100);

        ObjectMapper objectMapper = new ObjectMapper();//object which comes from jackson library
        String recordJson = objectMapper.writeValueAsString(records);
        System.out.println(recordJson);
    }

    @Test
    public void createAnOrder() throws Exception {
        OrderBook orderBook = new OrderBook();
        orderBook.setBookId(5);
        orderBook.setCustomerName("James Bond 777");

        ObjectMapper objectMapper = new ObjectMapper();
        java.lang.String orderJson = objectMapper.writeValueAsString(orderBook);
        System.out.println(orderJson);

        Response response = RestAssured.given()
                .header("Authorization","Bearer " + "5f0181b5de128c3b6c79d28bfca1c3f2bf9b12f526330c82a75d10288ae15425")
                .contentType(ContentType.JSON)
                .body(orderJson).post(Config.getProperty("baseURL") + "/orders");

        System.out.println(response.statusCode());
        System.out.println(response.asString());
    }


}
