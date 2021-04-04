package Payload;

import Pojo.AddPlacePOJO;
import Pojo.AddPlace_Location_PoJo;

import java.util.ArrayList;
import java.util.List;

public class AddPlacePayload {

    public static AddPlacePOJO getPojo(String name , String address , String website , int accuracy , double latitude , double  longitude , String phone_number , String Language ) {
        AddPlacePOJO pj = new AddPlacePOJO();
        pj.setAccuracy(accuracy);
        pj.setAddress(address);
        pj.setLanguage(Language);
        pj.setName(name);
        pj.setPhone_number(phone_number);

        List<String> myList = new ArrayList<String>();
        myList.add("shoes");
        myList.add("Park");

        pj.setTypes(myList);
        AddPlace_Location_PoJo loc = new AddPlace_Location_PoJo();
        loc.setLat(latitude);
        loc.setLng(longitude);
        pj.setLocation(loc);

        return pj;
    }
}
