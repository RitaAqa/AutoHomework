package framework.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static utils.PropertiesLoader.*;

/**
 * class contains base methods for POST and GET requests
 */
public class BaseRequests {
    private String token;

    /**
     * method sets up token variable
     *
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Method to set up common settings for all requests
     *
     * @return RequestSpecification object
     */
    private RequestSpecification setRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .build();
    }

    /**
     * base method for all post requests
     *
     * @param path
     * @param headers
     * @param body
     * @return Response object
     */
    /**/
    public Response post(String path, HashMap<String, String> headers, JSONObject body) {
        headers.put("x-token", this.token);

        return given(setRequestSpec())
                .headers(headers)
                .body(body.toString())
                .when()
                .post(path);
    }

    /**
     * base method for all get requests
     *
     * @param path
     * @param params
     * @return Response object
     */
    public Response get(String path, HashMap<String, String> params) {
        //set up headers
        HashMap<String, String> headers = new HashMap<>();
        headers.put("x-token", this.token);
        return given(setRequestSpec())
                .headers(headers)
                .params(params)
                .when()
                .get(path);
    }
}
