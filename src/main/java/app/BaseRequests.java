package app;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static utils.PropertiesLoader.*;

public class BaseRequests {

    public BaseRequests(String token) {
        private String token = token;
    }
    
    
    // """Method to concat base url and api path"""
    private String formUrl(String url) {
        return BASE_URL + url;
    }

    // """Method to set up common settings for all requests"""
    private RequestSpecification setRequestSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }

    public Response post(String path, HashMap<String, String> headers, JSONObject body) {
        String url = formUrl(path);
        
        headers.put('x-token', this.token)
        
        return given(setRequestSpec())
                .headers(headers)
                .body(body.toString())
                .when()
                .post(url);
    }

    public Response get(String path, HashMap<String, String> headers, HashMap<String, String> params) {
        String url = formUrl(path);
        headers.put('x-token', this.token);
        
        return given(setRequestSpec())
                .headers(headers)
                .params(params)
                .when()
                .get(url);
    }
}
