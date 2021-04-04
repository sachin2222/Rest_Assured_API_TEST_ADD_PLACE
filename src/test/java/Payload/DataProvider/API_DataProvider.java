package Payload.DataProvider;

import org.testng.annotations.DataProvider;

public class API_DataProvider {

    @DataProvider
    public Object[][] get_Add_Place_Payload(){
        Object[][] addPlacePayload={
                {"TestUser2", "NewYork", "google.com", 10, 10.345
                , 10.78, "8700896892", "English"}

        };

        return addPlacePayload;


    }
}
