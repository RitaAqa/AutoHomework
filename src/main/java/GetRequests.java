import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static utils.PropertiesLoader.*;

public class GetRequests {
    public static final String FILESROOTFOLDERPATH = "/metagenid/v2/files?breadcrumbs=1&offset=0&limit=1000&folder_id=84c966d5-8dce-429d-8f92-44d5e28b1581&_=1622700773180";
    public static final String FILESSPECIFICFOLDERATH = "/metagenid/v2/files?breadcrumbs=1&offset=0&limit=1000&folder_id=84c966d5-8dce-429d-8f92-44d5e28b1581&_=1622700773180";
    public static final String FILESCOUNTPATH = "/metagenid/v2/files/count?folder_id=84c966d5-8dce-429d-8f92-44d5e28b1581&_=1622700773179";
    public static final String FILESGETRUNSPATH = "/metagenid/v1/files/7f4c7326-0a4e-4b56-a8d0-8ce002191672/runs?_=1622700773181";
    public static final String FILESGETANALYSESPATH = "/metagenid/v1/runs/437ef8e4-b595-4fd8-a2f5-64221831e925/analysis?filter=total&_=1622700773184";
    public static final String FILESGETARTIFACTSPATH = "metagenid/v1/runs/437ef8e4-b595-4fd8-a2f5-64221831e925/artifacts?_=1622700773185";

    private String token;

    public void setIdentificationToken() throws NullPointerException {
        IdentificationToken identificationToken = new IdentificationToken();
        token  = identificationToken.getToken();
        if (null == token) {
            throw new NullPointerException();
        }
    }

    private RequestSpecification setRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(HOST)
                .addHeader("x-token", token)
                .build();
    }

    public void getFilesFromRootFolder() {
        given(setRequestSpec())
                .when()
                .get(FILESROOTFOLDERPATH)
                .then()
                .extract()
                .response()
                .prettyPrint();
    }

    public void getFilesFromSpecificFolder() {
        given(setRequestSpec())
                .when()
                .get(FILESSPECIFICFOLDERATH)
                .then()
                .extract()
                .response()
                .prettyPrint();
    }

    public void getFilesCount() {
        given(setRequestSpec())
                .when()
                .get(FILESCOUNTPATH)
                .then()
                .extract()
                .response()
                .prettyPrint();
    }

    public void getGetRuns() {
        given(setRequestSpec())
                .when()
                .get(FILESGETRUNSPATH)
                .then()
                .extract()
                .response()
                .prettyPrint();
    }

    public void getGetAnalyses() {
        given(setRequestSpec())
                .when()
                .get(FILESGETANALYSESPATH)
                .then()
                .extract()
                .response()
                .prettyPrint();
    }

    public void getGetArtifacts() {
        given(setRequestSpec())
                .when()
                .get(FILESGETARTIFACTSPATH)
                .then()
                .extract()
                .response()
                .prettyPrint();
    }

}
