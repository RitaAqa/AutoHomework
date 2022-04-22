import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static utils.PropertiesLoader.*;

public class IdentificationToken {
    public static final String LOGINPATH = "/v1/login";
    public static final String LOGINPAYLOAD = "{ 'expiry' :86400, 'login_from':'login page'}";

    public String getToken() {
        String token;
        token = given()
                .baseUri(HOST)
                .header("Authorization", AUTHBASIC)
                .contentType(ContentType.JSON)
                .body(LOGINPAYLOAD)
                .when()
                .post(LOGINPATH)
                .then()
                .extract()
                .response()
                .jsonPath()
                .getString("token");
        return token;
    }
}
