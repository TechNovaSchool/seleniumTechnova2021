package api.API_models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Fields {

//    firstname": "Jimmy",
//            "lastnotes": "James",
//            "phone": "(224) 316-9699",
//            "address": "759 Road Drive"
    private String firstname;
    private String lastname;
    private String address;
    private String phone;

}
