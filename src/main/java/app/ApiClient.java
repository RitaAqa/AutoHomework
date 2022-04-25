package app;

import io.restassured.response.Response;
import org.json.JSONObject;
import static utils.PropertiesLoader.*;
import static app.Urls.*;
import java.util.HashMap;

public class ApiClient extends BaseRequests {
    private String token;

    public Response login() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Authorization", AUTH_BASIC);

        JSONObject body = new JSONObject();
        body.put("expiry", "86400");
        body.put("login_from", "login page");

        Response response = post(LOGIN_PATH, headers, body);
        token = response.jsonPath().getString("token");
        return response;
    }

    public Response getFilesFromRootFolder() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("x-token", token);

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("breadcrumbs", "1");
        queryParams.put("offset", "0");
        queryParams.put("limit", "1000");
        queryParams.put("_", "1622700773180");

        return get(FILES_FOLDER_PATH, headers, queryParams);
    }

    public Response getFilesFromSpecificFolder(String folderID) {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("x-token", token);

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("breadcrumbs", "1");
        queryParams.put("offset", "0");
        queryParams.put("limit", "1000");
        queryParams.put("folder_id", folderID);
        queryParams.put("_", "1622700773180");

        return get(FILES_FOLDER_PATH, headers, queryParams);
    }

    public Response getFilesCount(String folderID) {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("x-token", token);

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("folder_id", folderID);
        queryParams.put("_", "1622700773179");

        return get(FILES_COUNT_PATH, headers, queryParams);
    }

    public Response getRuns() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("x-token", token);

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("_", "1622700773181");

        return get(FILES_GET_RUNS_PATH, headers, queryParams);
    }

    public Response getGetAnalyses() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("x-token", token);

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("_", "1622700773184");
        queryParams.put("filter", "total");

        return get(FILES_GET_ANALYSES_PATH, headers, queryParams);
    }

    public Response getGetArtifacts() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("x-token", token);

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("_", "1622700773185");

        return get(FILES_GET_ARTIFACTS_PATH, headers, queryParams);
    }
}
