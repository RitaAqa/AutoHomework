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

    public Response getFilesFromSpecificFolder(String folderID, String limit, String offset(OPTIONAL)) {
        HashMap<String, String> DEFAULT_PARAMS = new HashMap<>();
        // Option for params you would like to hide from codem but they are mandatory for HTTP request
        DEFAULT_PARAMS.put("default_limit", 0);
        if (limit == null) {
         String limit = DEFAULT_PARAMS.default_limit
        }
        
        
        HashMap<String, String> headers = new HashMap<>();
        headers.put("x-token", token);

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("breadcrumbs", "1");
        
        // Option for optioanl params
        if (offset != null): queryParams.put("offset", offset);
        
        queryParams.put("limit", limit);
        queryParams.put("folder_id", folderID);

        return get(FILES_FOLDER_PATH, headers, queryParams);
    }

    public Response getFilesCount(String folderID) {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("x-token", token);

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("folder_id", folderID);

        return get(FILES_COUNT_PATH, headers, queryParams);
    }

    public Response getRuns() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("x-token", token);

        HashMap<String, String> queryParams = new HashMap<>();

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
