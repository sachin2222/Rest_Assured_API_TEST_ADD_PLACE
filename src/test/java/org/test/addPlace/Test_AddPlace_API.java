package org.test.addPlace;


import Payload.AddPlacePayload;
import Payload.DataProvider.API_DataProvider;
import Pojo.AddPlacePOJO;
import Utilities.APIResources;
import Utilities.Base;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;


import static io.restassured.RestAssured.given;

public class Test_AddPlace_API extends Base {

    RequestSpecification requestSpecification;
    Response response;
    AddPlacePOJO pj;
    AddPlacePOJO addPlacePOJO;

    @Test(priority = 1,dataProvider = "get_Add_Place_Payload",dataProviderClass = API_DataProvider.class)
    public void AddPlace_Payload_Pojo_Conversion(String name , String address , String website , int accuracy , double latitude , double  longitude , String phone_number , String Language) {
        pj = AddPlacePayload.getPojo(name, address, website, accuracy, latitude, longitude, phone_number, Language);


    }

    @Test(priority = 2)
    public void set_Request_Parameters_For_AddPlace_API() throws FileNotFoundException {
        requestSpecification = given().spec(get_Request_Specifications_For_AddPLaceAPI());
    }

    @Test(priority = 3)
    public void Post_Payload_on_Add_Place_API() {
        String addPlaceResource = APIResources.valueOf("AddPlaceAPI").getResource();
        response = requestSpecification.when().body(pj).post(addPlaceResource);
        addPlacePOJO = response.as(AddPlacePOJO.class);//Deserialisation

    }

    @Test(priority = 4)
    public void Validate_Status_Code() {
        response.then().assertThat().statusCode(200);
    }

    @Test(priority = 5)
    public void getPlaceID(){
        System.out.println(addPlacePOJO.getPlace_id());


    }

}
