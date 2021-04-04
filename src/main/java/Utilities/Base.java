package Utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Base {


    public static RequestSpecification get_Request_Specifications_For_AddPLaceAPI() throws FileNotFoundException {

        PrintStream log = new PrintStream(new FileOutputStream("LOGGING_FOR_ADD_PLACE_API.txt"));

        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("key", "qaclick123")
                .setContentType(ContentType.JSON).setRelaxedHTTPSValidation()
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .build();

        return req;

    }


}
